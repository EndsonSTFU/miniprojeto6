public class Personagem {
    private String nome;
    private int Vida;

    public Personagem(String nome, int Vida) {
        this.nome = nome;
        setVida(Vida);
    }

    public Personagem(String nome) {
        this(nome, 100);
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return Vida;
    }

    private void setVida(int Vida) {
        if (Vida >= 0) {
            this.Vida = Vida;
        } else {
            System.out.println("Nosso heroi não pode mais continuar. Fim de jogo. ");
        }
    }

    public void atualizarVida(int incremento) {
        if (incremento != 0) {
            setVida(this.Vida + incremento);
            System.out.println(" O " + this.nome + " teve a vida alterada para " + this.Vida);
        }
    }

    @Override
    public String toString() {
        return nome + ": Vida " + Vida;
    }
}