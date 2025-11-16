package dominio;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 100, 20, 7);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque + (int)(Math.random() * 5);
        alvo.receberDano(dano);
        System.out.printf("%s atira uma flecha em " + alvo.getNome() + " causando %d de dano\n",nome, dano);
    }

    @Override
    public void defender() {
        defendendo = true;
        defesaGasta = false;
        System.out.printf("%s ergue o escudo!\n", nome);
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        alvo.receberDano(h.getPoder());
        System.out.printf("%s dispara " + h.getNome() + " e causa " + h.getPoder() + " de dano!\n", nome);
    }
}