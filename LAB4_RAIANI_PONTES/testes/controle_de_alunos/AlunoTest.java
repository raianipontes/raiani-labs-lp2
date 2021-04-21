package controle_de_alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	private Aluno aluno;

	@BeforeEach
	void criaAluno() {
		this.aluno = new Aluno("123", "Raiani", "cc");
	}

	@Test
	void testMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Aluno(null, "Raiani", "cc");
		});
	}

	@Test
	void testMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("", "Raiani", "cc");
		});
	}

	@Test
	void testMatriculaVazia2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Aluno(" ", "Raiani", "cc");
		});
	}

	@Test
	void testNomeNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Aluno("100", null, "cc");
		});
	}

	@Test
	void testNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("100", "", "cc");
		});
	}

	@Test
	void testNomeVazio2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("100", " ", "cc");
		});
	}

	@Test
	void testCursoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Aluno("102", "Matheus", null);
		});
	}

	@Test
	void testCursoVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("102", "Matheus", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("102", "Matheus", " ");
		});
	}

	@Test
	void testExibeAluno() {
		assertEquals("123 - Raiani - cc", this.aluno.toString());
	}
}
