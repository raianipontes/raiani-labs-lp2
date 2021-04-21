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
		Verificador.verificaNull(matricula);
		Verificador.verificaNull(nome);
		Verificador.verificaNull(curso);
		Verificador.verificaVazio(matricula);
		Verificador.verificaVazio(nome);
		Verificador.verificaVazio(curso);
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
	
	/**
	 * hashCode da matrícula do aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * Comparando a matrícula, verifica se um aluno é igual ao outro, 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
