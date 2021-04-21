import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

class ContatoTest {
	
	private Contato contatoPadrao;
	
	@BeforeEach
	public void geraContato() {
		this.contatoPadrao = new Contato("Nazareno", "Andrade", "(83) 8765-4321", "(83) 9999-8888", "1111-2222", 1, 2);
	}
	
	@Test
	public void testContato() {
		String msg = "Esperando receber o nome completo, telefone prioritário, o whatsapp e o telefone adicional.";
		assertEquals("Nazareno Andrade\n(83) 8765-4321 (Prioritário)\n(83) 9999-8888 (Whatsapp)\n1111-2222 (Adicional)", contatoPadrao.toString(), msg);
		
	}
	
	@Test
	public void testNomeCompleto() {
		String msg = "Esperando receber o nome completo do contato.";
		assertEquals("Nazareno Andrade", contatoPadrao.getNomeCompleto(), msg);
	}
}
