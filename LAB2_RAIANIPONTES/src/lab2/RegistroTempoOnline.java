package lab2;

/**
 * Classe que representa a quantidade de horas que o aluno dedicou a alguma disciplina remotamente.
 * @author Raiani Pontes
 *
 */
public class RegistroTempoOnline {
	/**
	 * Nome da disciplina que o aluno é matriculado.
	 */
	private String nomeDisciplina;
	
	/**
	 * Tempo que se espera que o aluno irá se dedicar a disciplina.
	 */
	private int tempoOnlineEsperado;
	
	/**
	 * Tempo que o aluno dedicou a disciplina.
	 */
	private int tempo;
	
	/**
	 * Constrói a classe a partir do nome da disciplina.
	 * @param nomeDisciplina é registrado o nome da disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
		this.tempo = 0;
	}
	
	/**
	 * Método que guarda o tempo que foi dedicado a disciplina.
	 * @param nomeDisciplina é utilizado o nome da disciplina pra saber quantas horas se dedicou a ela em específico.
	 * @param tempoOnlineEsperado quanto tempo foi dedicado pra disciplina. 
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this(nomeDisciplina);
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/** 
	 * Método que acrescenta o tempo que foi dedicado a mais para a disciplina. 
	 * @param tempo quanto tempo a mais o aluno dedicou a disciplina.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempo += tempo;
	}
	
	/**
	 * Método que verifica se o aluno atingiu o tempo esperado para a disciplina.
	 * @return retorna um valor booleano.
	 */
	public boolean atingiuMetaTempoOnline() {
		return this.tempoOnlineEsperado <= this.tempo;			
	}
	
	/**
	 * Método que retorna a string da disciplina, a quantidade de horas dedicada para a disciplina, e a quantidade esperada
	 * de dedicação à disciplina.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.tempo + "/" + this.tempoOnlineEsperado;	
	}

}
