import java.util.ArrayList;
import java.util.Scanner;

public class Capitulo {
    private String texto;
    private Personagem Finn;
    private Personagem Jake;
    private int incrementoFinn;
    private int incrementoJake;
    private Scanner plano;
    private ArrayList<Escolhas> escolhas;

    public Capitulo(String texto, Personagem Finn, Personagem Jake, int incrementoFinn, int incrementoJake, Scanner plano) {
        this.texto = texto;
        this.Finn = Finn;
        this.Jake = Jake;
        this.incrementoJake = incrementoJake;
        this.incrementoFinn = incrementoFinn;
        this.plano = plano;
        this.escolhas = new ArrayList<>();
    }

    public String getTexto() {
        return texto;
    }

    public Personagem getFinn() {
        return Finn;
    }

    public Personagem getJake() {
        return Jake;
    }

    private void mostrar() {
        System.out.println(getTexto());
        getFinn().atualizarVida(incrementoFinn);
        getJake().atualizarVida(incrementoJake);

        System.out.println(getFinn());
        System.out.println(getJake());

        for (int i = 0; i < escolhas.size(); i++) {
            System.out.println("- " + escolhas.get(i).getTexto());
        }

        System.out.println();
        System.out.println(". . .");
        System.out.println();
    }

    private Capitulo escolher() {
        int opcaoEscolhida = 0;
        String escolha;
        boolean escolhaCorreta = false;

        if (escolhas.isEmpty()) {
            System.out.println("E ASSIM CHEGAMOS AO FIM DA JORNADA.");
            System.exit(0);
        } else {
            while (!escolhaCorreta) {
                escolha = plano.nextLine();
                for (int i = 0; i < escolhas.size(); i++) {
                    if (escolha.equals(escolhas.get(i).getTexto())) {
                        escolhaCorreta = true;
                        opcaoEscolhida = i;
                    }
                }
                if (!escolhaCorreta) {
                    System.out.println("Escolha apenas uma das opções indicadas");
                    escolhaCorreta = false;
                    return null;
                }
            }
        }
        return escolhas.get(opcaoEscolhida).getProximo();
    }

    public void executar() {
        mostrar();
        Capitulo proximoCapitulo = escolher();

        if (proximoCapitulo != null) {
            proximoCapitulo.executar();
        } else {
            System.out.println("VOCE FOI UM GRANDE HEROI.");
            System.exit(0);
        }
    }

    public void adicionarEscolha(String texto, Capitulo proximoCapitulo) {
        Escolhas escolha = new Escolhas(texto, proximoCapitulo);
        escolhas.add(escolha);
    }
}
