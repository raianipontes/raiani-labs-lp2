package lab2;

/**
 * Classe que representa a saúde de um aluno. 
 * @author Raiani Pontes
 *
 */
public class Saude {
	/**
	 * a saúde mental do aluno.
	 */
	private String mental;
	/**
	 * a saúde física do aluno.
	 */
	private String fisica;
	/**
	 * a saúde geral do aluno.
	 */
	private String status;
	
	/**
	 * Constrói a saúde de um aluno.
	 */
	public Saude() {
		this.mental = "boa";
		this.fisica = "boa";		
	}
	
	/**
	 * Método que registra a saúde mental de um aluno.
	 * @param valor o status da saúde mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.mental = valor;
	}
	
	/**
	 * Método que registra a saúde física de um aluno.
	 * @param valor o status da saúde física do ano.
	 */
	public void defineSaudeFisica(String valor) {
		this.fisica = valor;
	}
	
	/**
	 * Método que verifica a saúde geral do aluno.
	 * @return retorna um valor em string da saúde geral do aluno.
	 */
	public String getStatusGeral() {
		if (this.fisica.equals("boa") && this.mental.equals("boa")) {
			status = "boa";
		}
		
		if (this.fisica.equals("boa") && this.mental.equals("fraca") || this.fisica.equals("fraca") && this.mental.equals("boa")) {
			status = "ok";
		}

		if (this.fisica.equals("fraca") && this.mental.equals("fraca")) {
			status = "fraca";	
		}
		
		return status;	
	}
		
	}