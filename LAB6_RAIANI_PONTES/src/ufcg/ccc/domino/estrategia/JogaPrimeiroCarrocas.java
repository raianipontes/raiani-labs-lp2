package ufcg.ccc.domino.estrategia;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

import java.util.List;

/**
 * Tenta jogar primeiro uma carroça que encaixa. Se não tiver, joga a última peça que encaixa.
 * Tenta primeiro o lado direito e depois o esquerdo(se encaixar em ambas). 
 * @author raiani
 *
 */
public class JogaPrimeiroCarrocas implements EstrategiaDeJogo {
	
	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		Jogada jogada = null;

		for (Peca peca : mao) {
			if (mesa.getNumPecas() == 0 || peca.encaixa(mesa.getNumNaDireita())) {
				jogada = new Jogada(peca, Jogada.TipoJogada.NA_DIREITA);

				if (peca.getNumDireito() == peca.getNumEsquerdo()) {
					break;
				}
			}

			else if (peca.encaixa(mesa.getNumNaEsquerda())) {
				jogada = new Jogada(peca, Jogada.TipoJogada.NA_ESQUERDA);

				if (peca.getNumDireito() == peca.getNumEsquerdo()) {
					break;
				}
			}
		}

		if (jogada == null) {
			return new Jogada();
		}

		return jogada;
	}
}
