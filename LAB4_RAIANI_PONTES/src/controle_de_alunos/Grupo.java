package controle_de_alunos;

import java.util.HashSet;

/**
 * Classe que representa um grupo de alunos.
 * @author raiani
 *
 */
public class Grupo {
	/**
	 * Nome do grupo.
	 */
	private String nome;
	
	/**
	 * Restrição de curso do grupo.
	 */
	private String restricao;
	
	/**
	 * Conjunto de alunos que compõem o grupo.
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * Constrói o grupo a partir do nome e da restrição de curso.
	 * @param nome Nome do grupo.
	 * @param restricao Restrição do grupo.
	 */
	public Grupo(String nome, String restricao) {
		Verificador.verificaNomeNull(nome);
		Verificador.verificaNomeVazio(nome);
		Verificador.verificaRestricaoNull(restricao);
		Verificador.verificaRestricaoVazia(restricao);
		this.nome = nome;
		this.restricao = restricao;
		this.alunos = new HashSet<>();
	}
	
	/**
	 * Adiciona o aluno no grupo.
	 * @param aluno O aluno a ser adicionado.
	 */
	public void adicionaAluno(Aluno aluno) {
		Verificador.verificaAlunoNull(aluno);
		this.alunos.add(aluno);
	}
	
	/**
	 * Acessa a restrição de curso.
	 * @return Retorna a restriçãp de curso do grupo.
	 */
	public String getRestricao() {
		return restricao;
	}
	
	/**
	 * Verifica se o aluno existe dentro do grupo.
	 * @param aluno
	 * @return
	 */
	public boolean contemAluno(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public String getNome() {
		return nome;
	}	
}