package controle_de_alunos;

/**
 * Classe verificadora de exceções.
 */

public class Verificador {

	public Verificador() {
	}

	/**
	 * Verifica se o objeto é nulo, caso seja, lança uma exceção.
	 * 
	 * @param o objeto a ser verificado.
	 */
	public static void verificaNull(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
	}

	/**
	 * Verifica se a string é vazia ou possui espaço em branco.
	 * 
	 * @param string String a ser verificada.
	 */
	public static void verificaVazio(String string) {
		if (string.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

}
