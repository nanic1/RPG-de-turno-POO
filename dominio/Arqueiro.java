package dominio;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 100, 20, 7);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque + (int)(Math.random() * 5);
        alvo.receberDano(dano);
        System.out.println(nome + " atira uma flecha em " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        System.out.println(nome + " se esquiva habilmente!");
        defesa += 4;
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        System.out.println(nome + " dispara " + h.getNome() + "!");
        alvo.receberDano(h.getPoder());
    }
}