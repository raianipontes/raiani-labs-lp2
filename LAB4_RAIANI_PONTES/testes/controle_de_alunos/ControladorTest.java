package controle_de_alunos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControladorTest {
	private Controlador controlador;
	private Aluno aluno;

	@BeforeEach
	void inicia() {
		this.controlador = new Controlador();
		this.aluno = new Aluno("250", "Chloe", "CC");
		this.controlador.cadastraAluno("250", "Chloe", "CC");
		this.controlador.cadastraGrupo("Cálculo", "CC");
	}

	@Test
	void criaAluno() {
		this.aluno = new Aluno("123", "Raiani", "cc");
	}

	@Test
	void testCadastraAlunoInexistente() {
		controlador.cadastraAluno("159", "Halle", "CC");
		assertEquals("Aluno: 159 - Halle - CC", controlador.consultaAluno("159"));
	}

	@Test
	void testCadastraAlunoMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.cadastraAluno(null, "Raiani", "cc");
		});
	}

	@Test
	void testCadastraAlunoMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAluno("", "Raiani", "cc");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAluno(" ", "Raiani", "cc");
		});
	}

	@Test
	void testCadastraAlunoNomeNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.cadastraAluno("100", null, "cc");
		});
	}

	@Test
	void testCadastraAlunoNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAluno("100", "", "cc");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAluno("100", " ", "cc");
		});
	}

	@Test
	void testCadastraAlunoCursoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.cadastraAluno("102", "Matheus", null);
		});
	}

	@Test
	void testCadastraAlunoCursoVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAluno("102", "Matheus", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAluno("102", "Matheus", " ");
		});
	}

	@Test
	void testConsultaAlunoMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.consultaAluno(null);
		});
	}

	@Test
	void testConsultaAlunoMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.consultaAluno("");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.consultaAluno(" ");
		});
	}

	@Test
	void testCadastraGrupoNomeNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.cadastraGrupo(null, "Engenharia");
		});
	}

	@Test
	void testCadastraGrupoNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraGrupo("", "cc");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraGrupo(" ", "cc");
		});
	}

	@Test
	void testCadastraGrupoRestricaoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.cadastraGrupo("Grafos", null);
		});
	}

	@Test
	void testAlocaAlunoGrupo() {
		assertEquals("ALUNO ALOCADO", this.controlador.alocarAluno("250", "Cálculo"));
	}

	@Test
	void testAlocaAlunoGrupoMatriculaInexistente() {
		assertEquals("Aluno não cadastrado.", this.controlador.alocarAluno("456", "Cálculo"));
	}

	@Test
	void testAlocaAlunoGrupoComGrupoInexistente() {
		assertEquals("Grupo não cadastrado.", this.controlador.alocarAluno("250", "os manolos"));
	}

	@Test
	void testAlocaAlunoGrupoMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.alocarAluno(null, "Cálculo");
		});
	}

	@Test
	void testAlocaAlunoMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.alocarAluno("", "Cálculo");
		});
	}

	@Test
	void testAlocaAlunoNomeGrupoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.alocarAluno("250", null);
		});
	}

	@Test
	void testAlocaAlunoNomeGrupoVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.alocarAluno("250", "");
		});
	}

	@Test
	void testPertinenciaGrupo() {
		this.controlador.alocarAluno("250", "Cálculo");
		assertEquals("ALUNO PERTENCE AO GRUPO", this.controlador.pertinenciaGrupo("Cálculo", "250"));
	}

	@Test
	void testNaoPertenceAoGrupo() {
		this.controlador.cadastraGrupo("TDB", "");
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO", this.controlador.pertinenciaGrupo("TDB", "250"));
	}

	@Test
	void testPertinenciaGrupoNomeNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.pertinenciaGrupo(null, "250");
		});
	}

	@Test
	void testPertinenciaGrupoNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.pertinenciaGrupo("", "250");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.pertinenciaGrupo(" ", "250");
		});
	}

	@Test
	void testPertinenciaGrupoMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.pertinenciaGrupo("Cálculo", null);
		});
	}

	@Test
	void testPertinenciaGrupoMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.pertinenciaGrupo("Cálculo", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.pertinenciaGrupo("Cálculo", " ");
		});
	}

	@Test
	void testCadastrarAlunoQuadroAlunoExistente() {
		this.controlador.cadastraAlunoRespondeQuadro("250");
		assertEquals("\nAlunos:\n1. " + this.aluno.toString() + "\n", this.controlador.representacaoAlunosQuadro());
	}

	@Test
	void testRegistraAlunoQuadroAlunoInexistente() {
		assertFalse(this.controlador.cadastraAlunoRespondeQuadro("321"));
	}

	@Test
	void testRegistraAlunoQuadroMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.cadastraAlunoRespondeQuadro(null);
		});
	}

	@Test
	void testRegistraAlunoQuadroMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAlunoRespondeQuadro("");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.cadastraAlunoRespondeQuadro(" ");
		});
	}

	@Test
	void testListaAlunosQuadro() {
		this.controlador.cadastraAlunoRespondeQuadro("250");
		assertEquals("\nAlunos:\n1. " + this.aluno.toString() + "\n", this.controlador.representacaoAlunosQuadro());
	}

	@Test
	void testContagemRestricaoCurso() {
		assertEquals(1, this.controlador.contagemRestricaoGrupo("CC"));
	}

	@Test
	void testContagemRestricaoCursoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.controlador.contagemRestricaoGrupo(null);
		});
	}

	@Test
	void testContagemRestricaoCursoVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.controlador.contagemRestricaoGrupo(" ");
		});
	}
}
