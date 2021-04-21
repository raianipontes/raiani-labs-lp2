package controle_de_alunos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que controla o sistema.
 * @author raiani
 *
 */
public class Controlador {
	/**
	 * Mapa de alunos em que são identificados por sua matrícula.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Mapa de grupos em que são identificados por seu nome.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Lista de alunos que responderam questões no quadro.
	 */
	private ArrayList<Aluno> alunoRespQuadro;
	
	/**
	 * Inicializa os atributos.
	 */
	public Controlador() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunoRespQuadro = new ArrayList<>();
	}
	
	/**
	 * Cadastra um aluno, caso ele não exista.
	 * @param matricula Matrícula do aluno.
	 * @param nome Nome do aluno.
	 * @param curso Curso do aluno.
	 * @return um valor booleano se foi possível cadastrá-lo ou não.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		Verificador.verificaMatriculaNull(matricula);
		Verificador.verificaNomeNull(nome);
		Verificador.verificaCursoNull(curso);
		Verificador.verificaMatriculaVazio(matricula);
		Verificador.verificaNomeVazio(nome);
		Verificador.verificaCursoVazio(curso);
		if (existeAluno(matricula)) {
			return false;
		}
		Aluno aluno = new Aluno(matricula, nome, curso);
		this.alunos.put(matricula, aluno);
		return true;
	}
	
	/**
	 * Consulta um aluno, caso ele exista.
	 * @param matricula Matrícula do aluno.
	 * @return A representação textual do aluno, caso ele exista.
	 */
	public String consultaAluno(String matricula) {
		Verificador.verificaMatriculaNull(matricula);
		Verificador.verificaMatriculaVazio(matricula);
		if (!existeAluno(matricula)) {
			return "Aluno não cadastrado.";
		}
		return "Aluno: " + this.alunos.get(matricula).toString();
	}
	
	/**
	 * Cadastra um grupo, caso ele não exista.
	 * @param nome Nome do grupo.
	 * @param restricao Restrição de curso do grupo.
	 * @return um valor booleano se foi possível cadastrá-lo ou não.
	 */
	public boolean cadastraGrupo(String nome, String restricao) {
		Verificador.verificaNomeNull(nome);
		Verificador.verificaNomeVazio(nome);
		Verificador.verificaRestricaoNull(restricao);
		Verificador.verificaRestricaoVazia(restricao);
		if (existeGrupo(nome)) {
			return false;
		}
		Grupo grupo = new Grupo(nome, restricao);
		this.grupos.put(nome, grupo);
		return true;
	}
	
	/**
	 * Aloca um aluno para algum grupo, caso o grupo e o aluno existam.
	 * @param matricula Matrícula do aluno.
	 * @param nome Nome do grupo.
	 * @return Se o aluno foi alocado ou não.
	 */
	public String alocarAluno(String matricula, String nome) {
		Verificador.verificaMatriculaNull(matricula);
		Verificador.verificaMatriculaVazio(matricula);
		Verificador.verificaNomeNull(nome);
		Verificador.verificaNomeVazio(nome);
		if (!existeAluno(matricula)) {
			return "Aluno não cadastrado.";
		}
		
		if (!existeGrupo(nome)) {
			return "Grupo não cadastrado.";
		}
		
		Aluno aluno = this.alunos.get(matricula);
		Grupo grupo = getGrupo(nome.toUpperCase());
		if (aluno.getCurso().equals(grupo.getRestricao()) || grupo.getRestricao().equals("")) {
			grupo.adicionaAluno(aluno);
		}
		else {
			return "GRUPO COM RESTRIÇÃO DE CURSO";
		}
		return "ALUNO ALOCADO";
	} 
	
	/**
	 * Verifica se o aluno pertence ao grupo.
	 * @param nome Nome do grupo.
	 * @param matricula Matrícula do aluno.
	 * @return Se o aluno pertence ou não.
	 */
	public String pertinenciaGrupo(String nome, String matricula) {
		Verificador.verificaNomeNull(nome);
		Verificador.verificaNomeVazio(nome);
		Verificador.verificaMatriculaNull(matricula);
		Verificador.verificaMatriculaVazio(matricula);
		if (!existeGrupo(nome)) {
			return "Grupo não cadastrado.";
		}
		Grupo grupo = this.getGrupo(nome.toUpperCase());
		if (!existeAluno(matricula)) {
			return "Aluno não cadastrado.";
		}
		Aluno aluno = this.alunos.get(matricula);
		if (grupo.contemAluno(aluno)) {
			return "ALUNO PERTENCE AO GRUPO";
		}
		return "ALUNO NÃO PERTENCE AO GRUPO";
	}
	
	/**
	 * Cadastra qual aluno respondeu questões no quadro, caso o aluno exista.
	 * @param matricula Matrícula do aluno.
	 * @return m valor booleano se foi possível cadastrá-lo ou não.
	 */
	public boolean cadastraAlunoRespondeQuadro(String matricula) {
		Verificador.verificaMatriculaNull(matricula);
		Verificador.verificaMatriculaVazio(matricula);
		if (!existeAluno(matricula)) {
			return false;
		}
		Aluno aluno = this.alunos.get(matricula);
		alunoRespQuadro.add(aluno);
		return true; 	
	}
	
	/**
	 * Representação textual dos alunos que responderam questões no quadro.
	 * @return Lista de alunos que responderam questões no quadro.
	 */
	public String representacaoAlunosQuadro() {
		String mensagem = "\nAlunos:\n";
		for (int i = 0; i < this.alunoRespQuadro.size(); i++) {
			Aluno aluno = this.alunoRespQuadro.get(i);
			mensagem += (i + 1) + ". " + aluno.toString() + "\n";
		}
		return mensagem;
	}
	
	/**
	 * Faz a contagem de quantos grupos possuem restrição de curso.
	 * @param curso Curso.
	 * @return A quantidade de grupos que possuem restrição por curso.
	 */
	public int contagemRestricaoGrupo(String curso) {
		Verificador.verificaCursoNull(curso);
		Verificador.verificaCursoVazio(curso);
		int contador = 0;
		for (Grupo grupo: this.grupos.values()) {
			if (grupo.getRestricao().equals(curso)) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Acessa o grupo a partir de seu nome, com letras maiúsculas.
	 * @param nome Nome do grupo.
	 * @return O grupo.
	 */
	private Grupo getGrupo (String nome) {
		for (String key : this.grupos.keySet()) {
			if (key.toUpperCase().equals(nome)) {
				return this.grupos.get(key);
			}	
		}
		return null;
	}
	
	/**
	 * Método qu verifica se o aluno já existe ou não.
	 * @param matricula Matrícula do aluno.
	 * @return Valor booleano se existe ou não.
	 */
	private boolean existeAluno(String matricula) {
		if (this.alunos.containsKey(matricula)) {
			return this.alunos.containsKey(matricula);
		}
		return false;
	} 
	
	/**
	 * Método que verifica se existe algum grupo a partir do nome.
	 * @param nome Nome do grupo.
	 * @return Valor booleano se existe ou não o grupo.
	 */
	private boolean existeGrupo(String nome){
		for (String key : this.grupos.keySet()) {
			if (key.toUpperCase().equals(nome.toUpperCase())) {
				return true;
			}	
		}
		return false;
	}	
}
