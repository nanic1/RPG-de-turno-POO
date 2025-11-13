package dominio;

public class Inimigo extends Entidade implements Acoes {
    private int ataque;

    public Inimigo(String nome, int vida, int ataque) {
        super(nome, vida);
        this.ataque = ataque;
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque + (int)(Math.random() * 5);
        alvo.receberDano(dano);
        System.out.println(nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        System.out.println(nome + " tenta bloquear o ataque!");
    }

    @Override
    public void mostrarStatus() {
        System.out.println(nome + " [HP: " + vidaAtual + "/" + vidaMaxima + "]");
    }
}