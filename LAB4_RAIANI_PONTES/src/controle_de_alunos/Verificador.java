package controle_de_alunos;

public class Verificador {
	
	public Verificador() {
	}
	
	public static void verificaMatriculaNull(String matricula) {
		if (matricula == null) {
			throw new NullPointerException();
		}	
	}
	
	public static void verificaNomeNull(String nome) {
		if (nome == null) {
			throw new NullPointerException();
		}	
	}
	
	public static void verificaCursoNull(String curso) {
		if (curso == null) {
			throw new NullPointerException();
		}	
	}
	
	public static void verificaMatriculaVazio(String matricula) {
		if (matricula == "" || matricula == " ") {
			throw new IllegalArgumentException();
		}	
	}
	
	public static void verificaNomeVazio(String nome) {
		if (nome == "" || nome == " ") {
			throw new IllegalArgumentException();
		}	
	}
	
	public static void verificaCursoVazio(String curso) {
		if (curso == "" || curso == " ") {
			throw new IllegalArgumentException();
		}	
	}
	
	public static void verificaRestricaoNull(String restricao) {
		if (restricao == null) {
			throw new NullPointerException();
		}	
	}
	
	public static void verificaRestricaoVazia(String restricao) {
		if (restricao == " ") {
			throw new IllegalArgumentException();
		}	
	}
	
	public static void verificaAlunoNull(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException();
		}
	}

}
