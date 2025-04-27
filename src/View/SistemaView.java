// Autor: José Padilha
// Classe: SistemaView
// Descrição: Responsável pela interação com o usuário no console.

package View;

import Controller.SistemaController;
import Model.Aluno;
import Model.Professor;

import java.util.Scanner;

public class SistemaView {

    private SistemaController controller = new SistemaController();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Listar Pessoas");
            System.out.println("4. Mostrar Pilha de Alunos");
            System.out.println("5. Calcular Média de um Aluno");
            System.out.println("6. Desfazer último cadastro de aluno");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> cadastrarProfessor();
                case 3 -> controller.listarPessoas();
                case 4 -> controller.mostrarPilhaAlunos(); // Nova opção: mostrar a pilha
                case 5 -> calcularMediaAluno();            // Nova opção: calcular média
                case 6 -> controller.desfazerUltimoCadastroAluno();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        int[] notas = new int[3];
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = Integer.parseInt(scanner.nextLine());
        }

        Aluno aluno = new Aluno(nome, idade, notas);
        controller.cadastrarPessoa(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void cadastrarProfessor() {
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();

        Professor prof = new Professor(nome, idade, disciplina);
        controller.cadastrarPessoa(prof);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void calcularMediaAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nomeBusca = scanner.nextLine();
        controller.calcularMediaAluno(nomeBusca); // Chama o método do Controller
    }


}
