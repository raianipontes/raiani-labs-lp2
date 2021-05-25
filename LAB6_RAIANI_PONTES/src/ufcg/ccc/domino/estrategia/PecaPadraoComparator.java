package ufcg.ccc.domino.estrategia;

import java.util.Comparator;

import ufcg.ccc.domino.Peca;
/**
 * Ordena as peças primeiro pelo número direito, depois pelo número da esquerda.
 * @author raiani
 *
 */
public class PecaPadraoComparator implements Comparator<Peca> {
	
	@Override
	public int compare(Peca peca1, Peca peca2) {
		Integer numDireito1 = peca1.getNumDireito();
		Integer numDireito2 = peca2.getNumDireito();
		
		return numDireito2.compareTo(numDireito1);
	}
}