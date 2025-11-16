package dominio;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 120, 25, 10);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque + (int)(Math.random() * 5);
        alvo.receberDano(dano);
        System.out.printf("%s golpeia " + alvo.getNome() + " causando %d de dano\n", nome, dano);
    }

    @Override
    public void defender() {
        defendendo = true;
        defesaGasta = false;
        System.out.printf("%s, ergue o escudo!\n", nome);
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        alvo.receberDano(h.getPoder());
        System.out.printf("%s utiliza " + h.getNome() + " e causa " + h.getPoder() + " de dano!\n", nome);
    }
}