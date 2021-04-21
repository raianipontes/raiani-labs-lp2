package lab2;

import java.util.Arrays;

/**
 * Classe que representa uma disciplina, as horas dedicadas, a média das notas na disciplina 
 * e se o aluno foi aprovado ou não.
 * @author Raiani Pontes
 *
 */
public class Disciplina {
	/**
	 * Nome da disciplina.
	 */
	private String nomeDisciplina;
		
	/**
	 * Horas dedicadas a disciplina.
	 */
	private int horas;
	
	/**
	 * Array de notas que o aluno tirou.
	 */
	private double[] notas;
	
	/**
	 * Constrói a classe a partir do nome da disciplina.
	 * @param nomeDisciplina nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
		
	}
	/**
	 * Método que registra as horas dedicadas a disciplina.
	 * @param horas as horas dedicadas a disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Método que cadastra as notas que o aluno tirou na disciplina.
	 * @param nota quais as notas da disciplina (4). 
	 * @param valorNota as notas o que aluno tirou na disciplina.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Método que calcula a média das notas.
	 * @return em tipo double, retorna a média das notas.
	 */
	private double calculaMedia() {
		double soma = 0;
		for (int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}	
		double media = soma / notas.length;
		return media;			
	}
	
	/**
	 * Método que verifica se o aluno foi aprovado na disciplina ou não.
	 * @return se o aluno foi aprovado ou não.
	 */
	public boolean aprovado() {
		return this.calculaMedia() >= 7.0;
	}
	
	/**
	 * Método que retorna a string do nome da disciplina, a média do aluno na disciplina e as suas notas.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + this.calculaMedia() + " " + Arrays.toString(notas);
	}
}
