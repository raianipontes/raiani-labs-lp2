package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;


/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		int pontuacaoJ1 = 0, pontuacaoJ2 = 0, empates = 0, normal = 0, carroca = 0, laELo = 0, cruzada = 0;

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaPrimeiraPossivel(); 
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} 
			else {
				int pontuacao = historico.getPontuacao();
				switch (pontuacao) {
				case 1:
					normal++;
					break;
				case 2:
					carroca++;
					break;
				case 3:
					laELo++;
					break;
				case 6:
					cruzada++;
					break;
				}
			}
		
			if (historico.getVencedor() == "J1") {
				pontuacaoJ1 += historico.getPontuacao();
			}
			else if (historico.getVencedor() == "J2") {
				pontuacaoJ2 += historico.getPontuacao();
			}
		}

		System.out.println("Jogos: " + REPETICOES + "\nJ1: " + pontuacaoJ1 + " pontos" +
		"\nJ2: " + pontuacaoJ2 + " pontos" + "\nEmpates: " + empates + "\n");
		System.out.println("Vitórias Por Tipo:\n" +
		"- Vitórias Normais: " + normal + "\n- Vitórias de Carroça: " + carroca + "\n- Vitórias de Lá e Ló: " + laELo + "\n- Vitórias de Cruzada: " + cruzada);
	}

}
