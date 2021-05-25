package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

class PecaPadraoComparatorTest {
	private Mesa mesa;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}
	
	@Test
	void PecaPadraoTest() {
		Comparator<Peca> cmp = new PecaPadraoComparator();

		EstrategiaDeJogo estrategiaCmp = new JogaPrimeiraPossivelComparadora(cmp);

	     Jogada j1 = estrategiaCmp.decideJogada(mesa, List.of(new Peca(0, 2), new Peca(1, 2)));

	        assertEquals(Jogada.TipoJogada.NA_DIREITA, j1.getTipo());
	        assertEquals(0, j1.getPeca().getNumEsquerdo());
	        assertEquals(2, j1.getPeca().getNumDireito());
	    }
	@Test
	void testPassa() {
		Comparator<Peca> cmp = new PecaPadraoComparator();

		EstrategiaDeJogo estrategiaCmp = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategiaCmp.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(0, 3)));

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
    void testJogaNaDireita() {
		Comparator<Peca> cmp = new PecaPadraoComparator();

		EstrategiaDeJogo estrategiaCmp = new JogaPrimeiraPossivelComparadora(cmp);

        Jogada j1 = estrategiaCmp.decideJogada(mesa, List.of(new Peca(0, 1), new Peca(1, 2)));

        assertEquals(Jogada.TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(2, j1.getPeca().getNumDireito());
    }

	
	@Test
	void testJogaNaEsquerda() {
		Comparator<Peca> cmp = new PecaPadraoComparator();

		EstrategiaDeJogo estrategiaCmp = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategiaCmp.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(4, 4), new Peca(1, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
}	