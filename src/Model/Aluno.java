// Autor: José Padilha
// Classe: Aluno
// Descrição: Representa um aluno com nome, idade e notas (armazenadas em vetor).
package Model;

public class Aluno extends Pessoa {
    public int[] notas; // Atributo público

    public Aluno(String nome, int idade, int[] notas) {
        super(nome, idade);
        this.notas = notas;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.print("Notas: ");
        for (int nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();
    }
}

