import java.util.ArrayList;
import java.util.List;

class Jogador {
    private String nome;
    private int idade;

    public Jogador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos de acesso aos dados do jogador
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando uma lista para armazenar os jogadores cadastrados
        List<Jogador> listaJogadores = new ArrayList<>();

        // Cadastrando alguns jogadores
        cadastrarJogador(listaJogadores, "Neymar", 29);
        cadastrarJogador(listaJogadores, "Messi", 34);
        cadastrarJogador(listaJogadores, "Cristiano Ronaldo", 37);

        // Exibindo os jogadores cadastrados
        System.out.println("Jogadores cadastrados:");
        for (Jogador jogador : listaJogadores) {
            System.out.println("Nome: " + jogador.getNome() + ", Idade: " + jogador.getIdade());
        }
    }

    // Método para cadastrar um jogador e adicioná-lo à lista de jogadores
    public static void cadastrarJogador(List<Jogador> listaJogadores, String nome, int idade) {
        Jogador jogador = new Jogador(nome, idade);
        listaJogadores.add(jogador);
    }
}




