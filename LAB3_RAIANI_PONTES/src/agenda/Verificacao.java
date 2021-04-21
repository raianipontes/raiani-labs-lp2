package agenda;

/**
 * Verifica se a posição dada pelo usuário é válida. 
 * @author raiani pontes
 *
 */

public class Verificacao {
	public Verificacao() {
	}
	/**
	 * Verifica se a posição dada pelo usuário existe no array.
	 * @param posicao Posição do contato.
	 */
	public static void verificaPosicao(int posicao) {
		if (posicao < 1 || posicao > 100) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");	
		}
	}
	
	/**
	 * Verifica se o nome e sobrenome do contato é nulo.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 */
	public static void verificaNomesNulos(String nome, String sobrenome) {
		if (nome == null || sobrenome == null) {
			throw new NullPointerException();
		}
	}
	
	/**
	 * Verifica se o nome e sobrenome do contato é string vazia ou string vazia com espaço.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 */
	public static void verificaNomesInvalidos(String nome, String sobrenome) {
		if (nome == "" || nome == " " || sobrenome == "" || sobrenome == " ") {
			throw new IllegalArgumentException();
		}
	}
	
}
