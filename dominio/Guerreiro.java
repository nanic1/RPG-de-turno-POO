package dominio;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 120, 25, 10);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque - (int)(Math.random() * 5);
        alvo.receberDano(dano);
        System.out.println(nome + " golpeia " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        System.out.println(nome + " ergue o escudo!");
        defesa += 5;
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        System.out.println(nome + " usa " + h.getNome() + "!");
        alvo.receberDano(h.getPoder());
    }
}