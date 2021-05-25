package ufcg.ccc.domino.estrategia;


import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Alterna a estratégia interna a ser usada em cada jogada.
 * @author raiani
 *
 */
public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {
	private List<EstrategiaDeJogo> estrategias;
	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
		this.estrategias = estrategias;
	}
	
	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		EstrategiaDeJogo estrategiaUsada = estrategias.get(0);
		Jogada jogada = estrategiaUsada.decideJogada(mesa, mao);
		estrategias.remove(0);
		estrategias.add(estrategiaUsada);
		return jogada;
		
	}
	
}
