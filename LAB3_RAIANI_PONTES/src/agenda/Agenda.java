package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 * @author raiani pontes
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	/**
	 * Array de contatos.
	 */
	private Contato[] contatos;
	/**
	 * Array de contatos favoritos.
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		Verificacao.verificaPosicao(posicao);
		if (temPosicao(posicao)) {
			return contatos[posicao - 1].toString();
		}
		return null;
	}	
	

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 Telefone 1 do contato.
	 * @param telefone2 Telefone 2 do contato.
	 * @param telefone3 Telefone 3 do contato.
	 * @param prioritario Qual o telefone prioritário do contato. 
	 * @param whatsapp Qual o telefone de whatsapp do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, String telefone3, int prioritario, int whatsapp) {
		Verificacao.verificaPosicao(posicao);
		Verificacao.verificaNomesNulos(nome, sobrenome);
		Verificacao.verificaNomesInvalidos(nome, sobrenome);
		Contato contato = new Contato(nome, sobrenome, telefone1, telefone2, telefone3, prioritario, whatsapp);
		this.contatos[posicao - 1] = contato;
	}
	
	/**
	 * Verifica se o contato já foi cadastrado e se não, cadastra o contato em uma posição.  
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 Telefone 1 do contato.
	 * @param telefone2 Telefone 2 do contato.
	 * @param telefone3 Telefone 3 do contato.
	 * @return
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, String telefone3) {
		if (jaCadastrado(nome, sobrenome)) {
			return false;
		}
		Contato contato = new Contato(nome, sobrenome, telefone1, telefone2, telefone3);
		this.contatos[posicao - 1] = contato;
		return true;
	}
	/**
	 * Verifica se o contato já foi cadastrado a partir do nome e sobrenome.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @return
	 */
	private boolean jaCadastrado(String nome, String sobrenome) {
		String nomeCompleto = nome + " " + sobrenome;
		for(int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null && contatos[i].getNomeCompleto().equals(nomeCompleto)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Verifica se existe a posição no array de contatos.
	 * @param posicao Posição do contato na lista.
	 * @return Se a posição existe ou não.
	 */
	public boolean temPosicao(int posicao) {
		if (contatos[posicao - 1] != null) {
			return true;
		}
		return false;
	} 
	/**
	 * Verifica se existe a posição no array de favoritos.
	 * @param posicao Posição do contato na lista.
	 * @return Se a posição existe ou não.
	 */
	private boolean temPosicaoFav(int posicao) {
		if (favoritos[posicao - 1] != null) {
			return true;
		}
		return false;
	}
	/**
	 * Adiciona o contato a lista de favoritos.
	 * @param posicaoContato Posição do contato na lista.
	 * @param posicaoFav Posição do contato na lista de favoritos.
	 */
	public void adicionaFavorito(int posicaoContato, int posicaoFav) {
		if (contatos[posicaoContato - 1] != null) { 
			this.favoritos[posicaoFav - 1] = this.contatos[posicaoContato - 1];
		}
	}
	/**
	 * Acessa a lista de favoritos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	
	/**
	 * Retorna a representação textual dos dados do contato favorito.
	 */
	public String getFavorito(int posicao) {
		Verificacao.verificaPosicao(posicao);
		if (temPosicaoFav(posicao)) {
			return this.favoritos[posicao - 1].toString();
		}
		return null;
	}		
	
	/**
	 * Verifica se o contato é favorito.
	 * @param posicao Posição do contato.
	 * @return Se é verdadeiro ou falso.
	 */
	public boolean ehFav(int posicao) {
		for (int i = 1; i <= getFavoritos().length; i++) {
			if (getFavoritos()[i - 1] != null && favoritos[i - 1].equals(contatos[posicao - 1])) {
				return true;	
			}	
		}
		return false;
	}
}
	
	
	

