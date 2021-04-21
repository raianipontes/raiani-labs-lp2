package controle_de_alunos;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular um controle de alunos.
 * @author raiani
 *
 */
public class MainControle {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		Scanner sc = new Scanner(System.in);
		String escolha = "";
		
		while (true) {
			escolha = menu(sc);
			comandos(escolha, controlador, sc);
			
		}

	}
	
	/**
	 * Exibe o menu e obtém a escolha do usuário.
	 * @param sc Scanner para obter a escolha do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner sc) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" + 
						"(A)locar Aluno no Grupo ou (P)ertinência a Grupo?\n" +
						"(R)egistrar Aluno que Respondeu\n" + 
						"(I)mprimir Alunos que Responderam\n" + 
						"(O)xe, e a contagem dos grupos com restrição?\n" +
						"(S)im, quero fechar o programa!"+ 
						"\n" + 
						"Opção> ");
		return sc.nextLine().toUpperCase();
	}
	
	/**
	 * Captura a escolha do usuário.
	 * @param escolha Escolha do usuário.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void comandos(String escolha, Controlador controlador, Scanner sc) {
		switch (escolha) {
		case "C":
			cadastraAluno(controlador, sc);
			break;
		case "E":
			exibeAluno(controlador, sc);
			break;
		case "N":
			novoGrupo(controlador, sc);
			break;
		case "A":
			alocarOuPertinencia(controlador, sc);
			break;
		case "R":
			registraAlunoRespQuadro(controlador, sc);
			break;
		case "I":
			imprimeAlunoRespQuadro(controlador);
			break;
		case "O":
			contagemRestricaoGrupo(controlador, sc);
			break;
		case "S":
			sair();
			break;
		}
	}
	
	/**
	 * Cadastra um aluno no controlador, caso ele não exista.
	 * @param controlador
	 * @param sc
	 */
	private static void cadastraAluno(Controlador controlador, Scanner sc) {
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine().trim();
		
		System.out.print("Nome: ");
		String nome = sc.nextLine().trim();
		
		System.out.print("Curso: ");
		String curso = sc.nextLine().trim();
		
		if (controlador.cadastraAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO!");
		}
		else {
			System.out.println("MATRÍCULA JÁ CADASTRADA!");
		}
	}
	
	/**
	 * Exibe o aluno com suas informações, caso ele exista.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void exibeAluno(Controlador controlador, Scanner sc) {
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine().trim();
		
		String informacaoAluno = controlador.consultaAluno(matricula);
		if (informacaoAluno != null) {
			System.out.println(informacaoAluno);	
		}
		
	}
	
	/**
	 * Cadastra um novo grupo, caso ele não exista.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void novoGrupo(Controlador controlador, Scanner sc) {
		System.out.print("\nGrupo: ");
		String grupo = sc.nextLine().trim();
		
		System.out.print("Restrição? ");
		String restricao = sc.nextLine().trim();
		
		if (controlador.cadastraGrupo(grupo, restricao)) {
			System.out.println("CADASTRO REALIZADO!");
		}
		else {
			System.out.println("GRUPO JÁ CADASTRADO!");
		}
	}
	
	/**
	 * Aloca um aluno para um grupo, caso ambos existam.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void alocarAluno(Controlador controlador, Scanner sc) {
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine().trim();
		
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		
		String log = controlador.alocarAluno(matricula, grupo);
		if (log != null) {
			System.out.println(log);
		}
		
	}
	
	/**
	 * Verifica se um aluno pertence a algum grupo.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void pertinenciaGrupo(Controlador controlador, Scanner sc) {
		System.out.print("\nGrupo: ");
		String grupo = sc.nextLine().trim();
		
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine().trim();
		
		String mensagem = controlador.pertinenciaGrupo(grupo, matricula);
			if (mensagem != null) {
				System.out.println(mensagem);
			}
	}
	
	/**
	 * Capta a função adequada de acordo com a opção escolhida pelo usuário.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void alocarOuPertinencia(Controlador controlador, Scanner sc) {
		System.out.print("\n(A)locar Aluno ou (P)ertinência a Grupo? ");
		String escolha = sc.nextLine().trim().toUpperCase();
		
		if (escolha.equals("A")) {
			alocarAluno(controlador, sc);
		}
		else if (escolha.equals("P")) {
			pertinenciaGrupo(controlador, sc);
		}
		else {
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * Registra o aluno que respondeu no quadro.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void registraAlunoRespQuadro(Controlador controlador, Scanner sc) {
		System.out.print("\nMatrícula: ");
		String matricula = sc.nextLine().trim();
		
		if (controlador.cadastraAlunoRespondeQuadro(matricula)) {
			System.out.println("ALUNO REGISTRADO!");	
		}
		else {
			System.out.println("Aluno não cadastrado.");
		}
	}
	
	/**
	 * Imprime os alunos que responderam questões no quadro.
	 * @param controlador Controlador do sistema.
	 */
	private static void imprimeAlunoRespQuadro(Controlador controlador) {
		System.out.println(controlador.representacaoAlunosQuadro());
	}
	
	/**
	 * Faz a contagem de quantos grupos tiveram restrição de curso.
	 * @param controlador Controlador do sistema.
	 * @param sc Scanner caso seja necessário mais input.
	 */
	private static void contagemRestricaoGrupo(Controlador controlador, Scanner sc) {
		System.out.print("\nCurso: ");
		String curso = sc.nextLine().trim();
		
		System.out.println(curso + " " + controlador.contagemRestricaoGrupo(curso));	
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sair() {
		System.out.println("Tchau! :)");
		System.exit(0);
	}
}
