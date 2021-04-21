package lab2;

/**
 * Classe que representa as finanças de um aluno a fim de ajudar no controle de gastos.
 * @author Raiani Pontes
 *
 */
public class RegistroFinancas {
	/**
	 * o dinheiro que o aluno tem inicialmente.
	 */
	private int receitaInicial;
	
	/**
	 * fonte de renda 1: família.
	 */
	private int tipoFonte1;
	
	/**
	 * fonte de renda 2: projetos institucionais.
	 */
	private int tipoFonte2;

	/**
	 * fonte de renda 3: auxílio da instituição.
	 */
	private int tipoFonte3;
	
	/**
	 * fonte de renda 4: doações.
	 */
	private int tipoFonte4;
	
	/**
	 * gastos do aluno.
	 */
	private int despesas;
	
	/**
	 * Constrói a classe a partir da quantidade de dinheiro que o aluno tem com suas fontes de renda.
	 * @param receitaInicial quantidade de dinheiro em centavos do aluno.
	 */
	public RegistroFinancas(int receitaInicial) {	
		this.receitaInicial = receitaInicial;
		this.tipoFonte1 = 0;
		this.tipoFonte2 = 0;
		this.tipoFonte3 = 0;
		this.tipoFonte4 = 0;
		this.despesas = 0;
	}
	
	/**
	 * Método que registra quanto de dinheiro foi recebido por cada tipo de fonte de renda. 
	 * @param valorCentavos quanto de dinheiro em centavos foi recebido.
	 * @param tipoFonte qual tipo de fonte de renda.
	 */
	public void aumentaReceita(int valorCentavos, int tipoFonte) {
		switch (tipoFonte){
		case 1:
			this.tipoFonte1 = valorCentavos;
			this.tipoFonte1 += receitaInicial;
			break;
		case 2:	
			this.tipoFonte2 += valorCentavos;
			break;
		case 3:
			this.tipoFonte3 += valorCentavos;
			break;
		case 4:
			this.tipoFonte4 += valorCentavos;
			break;
		}		
	}
	
	/**
	 * Calcula todo o dinheiro recebido, de todas as fontes de renda.
	 * @return um valor inteiro que representa o dinheiro recebido.
	 */
	private int calculaReceitaTotal() {
		return this.tipoFonte1 + this.tipoFonte2 + this.tipoFonte3 + this.tipoFonte4;		
	}
	
	/**
	 * Método que registra a quantidade de dinheiro gasta.
	 * @param valorCentavos a quantidade de dinheiro gasta.
	 */
	public void pagaDespesa(int valorCentavos) {
		this.despesas += valorCentavos;
	}
	
	/**
	 * Método que apresenta quanto de dinheiro foi recebido por cada fonte de renda.
	 * @return retorna em String os valores que foram recebidos por cada fonte de renda.
	 */
	public String exibeFontes() {
		return "1 - " + this.tipoFonte1 + "\n" + "2 - " + this.tipoFonte2 + "\n" + "3 - " + this.tipoFonte3 +
				"\n" + "4 - " + this.tipoFonte4;				
	}
	
	/**
	 * Método que retorna um valor do tipo string com todo o dinheiro recebido, o dinheiro após as despesas, e as despesas. 
	 */
	public String toString() {
		return "Receita total: " + this.calculaReceitaTotal() + ", " + "Receita atual: " + (this.calculaReceitaTotal() - this.despesas) +
				", " + "Despesas totais: " + this.despesas; 
	}
}
