// Autor: José Padilha
// Classe: Professor
// Descrição: Representa um professor com nome, idade e disciplina.

package Model;

public class Professor extends Pessoa {
    public String disciplina; // Atributo público

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Disciplina: " + disciplina);
    }
}

