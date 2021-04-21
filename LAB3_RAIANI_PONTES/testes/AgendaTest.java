import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
class AgendaTest {
	
	private Agenda agenda;
	
	public AgendaTest() {
		agenda = new Agenda();
	}
	
	@BeforeEach
	public void cadastraContato() {
		agenda.cadastraContato(1, "Nazareno", "Andrade", "(83) 8765-4321", "(83) 9999-8888", "1111-2222", 1, 2);
		agenda.cadastraContato(13, "Rex", "Orange", "1111111", "2222222", "3333333", 1, 2);
		agenda.cadastraContato(100, "Halle", "Bailey", "(83) 555-222", "(83) 8989-1212", "(83) 3333-1111", 1, 2);
		agenda.cadastraContato(50, "Pedro", "Lima", "(83) 3310-6000", "(11) 4002-8922", null);
		agenda.cadastraContato(56, "Kleber", "Reudo", "(83) 3310-6000", null, "(11) 4002-8922");
		agenda.cadastraContato(55, "Joao", "Vitor", null, null, null);
	}
	
	@Test
	public void cadastroPosicaoVazia() {
		assertEquals("Rex Orange\n1111111 (Prioritário)\n2222222 (Whatsapp)\n3333333 (Adicional)", agenda.getContato(13));
	}
	
	@Test
	public void cadastroInvalidoAcima() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			agenda.cadastraContato(101, "Chloe", "Bailey", "(83) 1111-2222", "(83) 2222-3333", "(83) 3333-4444", 1, 2);
		});
	}

	@Test
	public void cadastroInvalidoAbaixo() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			agenda.cadastraContato(0, "Mariana", "Ferraz", "(83) 1211-4222", "(83) 9898-3333", "(83) 8773-4444", 1, 2);
		});
	}
	
	@Test
	public void cadastroLimiteAcima() {
		assertEquals("Halle Bailey\n(83) 555-222 (Prioritário)\n(83) 8989-1212 (Whatsapp)\n(83) 3333-1111 (Adicional)", agenda.getContato(100));
	}
	
	@Test
	public void cadastroLimiteAbaixo() {
		
		agenda.cadastraContato(1, "Maely", "Siqueira", "(83) 5551-2221", "(83) 8889-2212", "(83) 3333-1219", 2, 1);
		assertEquals("Maely Siqueira\n(83) 8889-2212 (Prioritário)\n(83) 5551-2221 (Whatsapp)\n(83) 3333-1219 (Adicional)", agenda.getContato(1));
	}
	
	@Test
	public void cadastroNomeNulo() {
		Assertions.assertThrows(NullPointerException.class, ()-> {
			agenda.cadastraContato(1, null, "Ferreira", "(83) 8891-4222", "(83) 9999-3333", "(83) 8764-4444", 1, 2);
		});
	}
	
	@Test
	public void cadastroNomeInvalido() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			agenda.cadastraContato(2, "", "Ferreira", "(83) 8891-4222", "(83) 9999-3333", "(83) 8764-4444", 1, 2);
		});
	}
	
	@Test
	public void cadastroNomeInvalido2() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			agenda.cadastraContato(1, " ", "Ferreira", "(83) 8891-4222", "(83) 9999-3333", "(83) 8764-4444", 1, 2);
		});
	}
	@Test
	public void cadastroSobrenomeNulo() {
		Assertions.assertThrows(NullPointerException.class, ()-> {
			agenda.cadastraContato(1, "Jonatas", null, "(83) 8891-4222", "(83) 9999-3333", "(83) 8764-4444", 1, 2);
		});
	}
	
	@Test
	public void cadastroSobrenomeInvalido() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			agenda.cadastraContato(1, "Jonatas", "", "(83) 8891-4222", "(83) 9999-3333", "(83) 8764-4444", 1, 2);
		});
	}
	
	@Test
	public void cadastroSobrenomeInvalido2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			agenda.cadastraContato(6, "Jonatas", " ", "(83) 8891-4222", "(83) 9999-3333", "(83) 8764-4444", 1, 2);
		});
	}	
	
	@Test
	public void testExibeContatoPosicaoInvalida() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			agenda.getContato(1000);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			agenda.getContato(0);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			agenda.getContato(-1);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			agenda.getContato(101);
		});
	}
	
	@Test
	public void testExibeContatoPosicaoValida() {
		agenda.cadastraContato(1, "Maely", "Siqueira", "(83) 8889-2212", "(83) 5551-2221", "(83) 3333-1219", 1, 2);
		Assertions.assertEquals("Maely Siqueira\n(83) 8889-2212 (Prioritário)\n(83) 5551-2221 (Whatsapp)\n(83) 3333-1219 (Adicional)", agenda.getContato(1));
	}
	
	@Test
	public void testExibeContatoInexistente() {
		Assertions.assertNull(agenda.getContato(10));
	}
	
	@Test
	public void testTelefoneNulo() {
		Assertions.assertEquals("Pedro Lima\n(83) 3310-6000 (Prioritário)\n(11) 4002-8922 (Whatsapp)", agenda.getContato(50));
		Assertions.assertEquals("Kleber Reudo\n(83) 3310-6000 (Prioritário)\n(11) 4002-8922 (Adicional)", agenda.getContato(56));
		Assertions.assertEquals("Joao Vitor", agenda.getContato(55));
	}	
	
	@Test
	public void testFavorito() {
		agenda.cadastraContato(42,"Thallyson", "Jose", "(83) 8891-4222", "(83) 9999-3333" , "1111111", 1, 2);
		agenda.adicionaFavorito(42, 2);
		assertEquals("Thallyson Jose\n(83) 8891-4222 (Prioritário)\n(83) 9999-3333 (Whatsapp)\n1111111 (Adicional)", agenda.getFavorito(2));
	}
}
