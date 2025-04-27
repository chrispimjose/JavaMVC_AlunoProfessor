// Autor: José Padilha
// Classe: Pessoa
// Descrição: Classe base para representar uma pessoa (nome e idade) no sistema.

package Model;

public class Pessoa {
    public String nome;   // Atributo público
    public int idade;     // Atributo público

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
