// Autor: José Padilha
// Classe: SistemaController
// Descrição: Controla o cadastro de pessoas e operações sobre alunos.
package Controller;

import Model.Aluno;
import Model.Pessoa;

import java.util.ArrayList;
import java.util.Stack;

public class SistemaController {
    public ArrayList<Pessoa> pessoas = new ArrayList<>(); // Lista pública
    public Stack<Aluno> pilhaAlunos = new Stack<>();      // Pilha pública

    public void cadastrarPessoa(Pessoa p) {
        pessoas.add(p);
        if (p instanceof Aluno) {
            pilhaAlunos.push((Aluno) p);
        }
    }

    public void listarPessoas() {
        for (Pessoa p : pessoas) {
            p.exibirInfo();
            System.out.println("-----");
        }
    }

    public void desfazerUltimoCadastroAluno() {
        if (!pilhaAlunos.isEmpty()) {
            Aluno removido = pilhaAlunos.pop();
            pessoas.remove(removido);
            System.out.println("Último aluno removido: " + removido.nome);
        } else {
            System.out.println("Nenhum aluno para remover.");
        }
    }

    // Método para mostrar todos os alunos da pilha
    public void mostrarPilhaAlunos() {
        if (pilhaAlunos.isEmpty()) {
            System.out.println("Pilha de alunos vazia.");
        } else {
            System.out.println("--- Pilha de Alunos ---");
            for (Aluno a : pilhaAlunos) {
                a.exibirInfo();
                System.out.println("---");
            }
        }
    }

    // Método para calcular a média de notas de um aluno pelo nome
    public void calcularMediaAluno(String nomeBusca) {
        for (Aluno a : pilhaAlunos) {
            if (a.nome.equalsIgnoreCase(nomeBusca)) {
                int soma = 0;
                for (int nota : a.notas) {
                    soma += nota;
                }
                double media = (double) soma / a.notas.length;
                System.out.printf("Média de %s: %.2f%n", a.nome, media);
                return;
            }
        }
        System.out.println("Aluno não encontrado na pilha.");
    }



}
