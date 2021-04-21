package controle_de_alunos;

import java.util.HashSet;

/**
 * Classe que representa um grupo de alunos.
 * 
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
	 * 
	 * @param nome      Nome do grupo.
	 * @param restricao Restrição do grupo.
	 */
	public Grupo(String nome, String restricao) {
		Verificador.verificaNull(nome);
		Verificador.verificaVazio(nome);
		Verificador.verificaNull(restricao);
		this.nome = nome;
		this.restricao = restricao;
		this.alunos = new HashSet<>();
	}

	/**
	 * Adiciona o aluno no grupo.
	 * 
	 * @param aluno O aluno a ser adicionado.
	 */
	public void adicionaAluno(Aluno aluno) {
		Verificador.verificaNull(aluno);
		this.alunos.add(aluno);
	}

	/**
	 * Acessa a restrição de curso.
	 * 
	 * @return Retorna a restriçãp de curso do grupo.
	 */
	public String getRestricao() {
		return restricao;
	}

	/**
	 * hashCode do nome do grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Comparando os nomes, verifica se um grupo é igual ao outro,
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Verifica se o aluno existe dentro do grupo.
	 * 
	 * @param aluno O aluno.
	 * @return Se existe o aluno no grupo ou não.
	 */
	public boolean contemAluno(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	/**
	 * Acessa o nome do grupo.
	 * 
	 * @return o nome do grupo.
	 */
	public String getNome() {
		return nome;
	}
}