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
        System.out.printf("%s ataca %s causando %d de dano!\n", nome, alvo.getNome(), dano);
    }

    @Override
    public void defender() {
        defendendo = true;
        defesaGasta = false;
        System.out.printf("%s tenta bloquear o ataque!\n", nome);
    }

    @Override
    public void mostrarStatus() {
        System.out.printf("%s [HP: %d / %d]\n", nome, vidaAtual, vidaMaxima);
    }
}