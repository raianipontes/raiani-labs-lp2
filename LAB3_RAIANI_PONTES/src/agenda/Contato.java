package agenda;

/**
 * Um contato que possui dados. 
 * @author raiani pontes
 *
 */
public class Contato {
	/**
	 * Nome do contato.
	 */
	private String nome;
	
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * Array de telefones do contato.
	 */
	private String telefones[];
	
	/**
	 * Telefone principal do contato.
	 */
	private String telefonePrioritario;
	
	/**
	 * O whatsapp do contato.
	 */
	private String wpp;
	
	/**
	 * O telefone adicional do contato.
	 */
	private String adicional;
	
	/**
	 * Constrói o contato a partir de seus dados.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 Telefone 1 do contato.
	 * @param telefone2 Telefone 2 do contato.
	 * @param telefone3 Telefone 3 do contato.
	 * @param prioritario Número de telefone principal do contato.
	 * @param whatsapp Número de whatsapp do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone1, String telefone2, String telefone3, int prioritario, int whatsapp) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones = new String [] { telefone1, telefone2, telefone3 };
		this.telefonePrioritario = telefones[prioritario - 1];
		this.wpp = telefones[whatsapp - 1];
		this.adicional = telefone3;
	}
	/**
	 * Constrói o contato a partir de seus dados.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 Telefone 1 do contato.
	 * @param telefone2 Telefone 2 do contato.
	 * @param telefone3 Telefone 3 do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone1, String telefone2, String telefone3) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefonePrioritario = telefone1;
		this.wpp = telefone2;
		this.adicional = telefone3;				
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
	
	/**
	 * Acessa o nome completo do contato.
	 * @return retorna o nome e o sobrenome do contato.
	 */
	public String getNomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}
	/**
     * Representação textual do contato e seus dados.
     */
    public String toString() {
        return getNomeCompleto() 
                + (this.telefonePrioritario == null ? "" : "\n" + this.telefonePrioritario + " (Prioritário)") 
                + (this.wpp == null ? "" : "\n" + this.wpp + " (Whatsapp)")
                + (this.adicional == null ? "" : "\n" + this.adicional + " (Adicional)");
    }	 
}
