package controle_de_alunos;

/**
 * Classe que representa o aluno com suas informações.
 * @author raiani
 *
 */
public class Aluno {
	/**
	 * Matrícula do aluno.
	 */
	private String matricula;
	
	/**
	 * Nome do aluno;
	 */
	private String nome;
	
	/**
	 * Curso do aluno. 
	 */
	private String curso;
	/**
	 * Constrói o aluno a partir de suas informações.
	 * @param matricula Matrícula do aluno.
	 * @param nome Nome do aluno.
	 * @param curso Curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		Verificador.verificaMatriculaNull(matricula);
		Verificador.verificaNomeNull(nome);
		Verificador.verificaCursoNull(curso);
		Verificador.verificaMatriculaVazio(matricula);
		Verificador.verificaNomeVazio(nome);
		Verificador.verificaCursoVazio(curso);
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Acessa o curso que o aluno faz.
	 * @return retorna o curso do aluno
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Representação textual do aluno e suas informações.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
}
