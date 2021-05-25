package ufcg.ccc.domino.estrategia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
/**
 * Ordena a lista de peças da mão e oga sempre a primeira peça que encaixa. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambas.
 * @author raiani
 *
 */
public class JogaPrimeiraPossivelComparadora implements EstrategiaDeJogo{
	
	public JogaPrimeiraPossivelComparadora(Comparator<Peca> comparador) {
	}
	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		Peca[] copiaMao = new Peca[mao.size()];
		mao.toArray(copiaMao);
		Arrays.sort(copiaMao, new PecaPadraoComparator());
		
		if (mesa.getNumPecas() == 0) {
			return new Jogada(copiaMao[0], TipoJogada.NA_DIREITA);
		}

		for (Peca peca : copiaMao) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}

}
