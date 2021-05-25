package ufcg.ccc.domino.estrategia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Joga sempre as peças que possuem o maior somatório que encaixam. Tenta primeiro do lado direito
 * e depois do lado esquerdo(se encaixar em ambas).
 * @author raiani
 *
 */
public class JogaPesadas implements EstrategiaDeJogo {

	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		Peca[] copiaMao = new Peca[mao.size()];
		mao.toArray(copiaMao);
		Arrays.sort(copiaMao, new SomaPecaComparator());
		
		if (mesa.getNumPecas() == 0) {
            return new Jogada(copiaMao[0], Jogada.TipoJogada.NA_DIREITA);
        }
		
		for (Peca peca : copiaMao) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
                return new Jogada(peca, Jogada.TipoJogada.NA_DIREITA);
            }
            if (peca.encaixa(mesa.getNumNaEsquerda())) {
                return new Jogada(peca, Jogada.TipoJogada.NA_ESQUERDA);
            }
		}
		
		return new Jogada();
		
	}
	
	public class SomaPecaComparator implements Comparator<Peca> {
		public int compare(Peca peca1, Peca peca2) {
			Integer somatorio1 = peca1.getNumDireito() + peca1.getNumEsquerdo();
			Integer somatorio2 = peca2.getNumDireito() + peca2.getNumEsquerdo();
		
			return somatorio2.compareTo(somatorio1);
		}
	}

}
