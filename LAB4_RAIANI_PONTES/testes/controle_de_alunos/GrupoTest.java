package controle_de_alunos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class GrupoTest {
	private Grupo grupo;
	
	@BeforeEach
	void criaGrupo() {
		this.grupo = new Grupo("Titãs", "Computação");
	}
	
	@Test
	void testNomeNull() {
		Assertions.assertThrows(NullPointerException.class, ()-> {
			new Grupo(null, "Computação");
		});
	}
	@Test
	void testNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Grupo("", "cc");
		});
	}
	@Test
	void testNomeVazio2() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Grupo(" ", "engenharia elétrica");
		});
	}
	void testRestricaoNull() {
		Assertions.assertThrows(NullPointerException.class, ()-> {
			new Grupo("P2", null);
		});
	}
	@Test
	void testRestricaoVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Grupo("LP2", " ");
		});
	}
	
	@Test
	void testAddAlunoNull() {
		Assertions.assertThrows(NullPointerException.class, ()-> {
			this.grupo.adicionaAluno(null);
		});
	}
}
