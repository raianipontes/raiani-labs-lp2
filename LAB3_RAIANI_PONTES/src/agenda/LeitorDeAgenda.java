package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lógica para ler de arquivos csv os dados necessários e povoar uma agenda. 
 * 
 * @author nazarenoandrade
 * @author raiani pontes
 *
 */
public class LeitorDeAgenda {

	private static final int COLUNA_POSICAO = 0;
	private static final int COLUNA_NOME = 1;
	private static final int COLUNA_SOBRENOME = 2;
	private static final int COLUNA_TELEFONE1 = 3;
	private static final int COLUNA_TELEFONE2 = 4;
	private static final int COLUNA_TELEFONE3 = 5;
	private static final int COLUNA_PRIORITARIO = 6;
	private static final int COLUNA_WHATSAPP = 7;
	


	/**
	 * Lê contatos de um arquivo CSV e os coloca em uma agenda.
	 * @param arquivoContatos Caminho para arquivo contendo contatos.
	 * @param agenda A agenda a manipular.
	 * @return O número de contatos adicionados à agenda.
	 * @throws IOException Caso não tenhamos permissão de ler o arquivo.
	 * @throws FileNotFoundException Caso o arquivo não exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabeçalho
					continue;
				}
				String[] campos = linha.split(",");
				processaLinhaCsvContatos(campos, agenda);
			}
		}
		
		return carregados;
	}

	
	/**
	 * Coloca na agenda os dados de uma linha do arquivo de agenda inicial. 
	 * 
	 * @param campos As informações lidas do csv. 
	 * @param agenda A agenda a manipular. 
	 */
	private void processaLinhaCsvContatos(String[] campos, Agenda agenda) {
		int posicao = Integer.parseInt(campos[COLUNA_POSICAO]);
		String nome = campos[COLUNA_NOME].trim();
		String sobrenome = campos[COLUNA_SOBRENOME].trim();
		String telefone1 = campos[COLUNA_TELEFONE1].trim();
		String telefone2 = campos[COLUNA_TELEFONE2].trim();
		String telefone3 = campos[COLUNA_TELEFONE3].trim();
		int prioritario = Integer.parseInt(campos[COLUNA_PRIORITARIO].trim());
		int whatsapp = Integer.parseInt(campos[COLUNA_WHATSAPP].trim());		

		agenda.cadastraContato(posicao, nome, sobrenome, telefone1, telefone2, telefone3, prioritario, whatsapp);
	}

}
