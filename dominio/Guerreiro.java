package dominio;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 120, 25, 10);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque - (int)(Math.random() * 5);
        alvo.receberDano(dano);
        System.out.printf("%s golpeia " + alvo.getNome() + " causando %d de dano", nome, dano);
    }

    @Override
    public void defender() {
        System.out.printf("%s, ergue o escudo!", nome);
        aplicarDefesaTemporaria(5);
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        System.out.printf("%s dispara " + h.getNome() + "!", nome);
        alvo.receberDano(h.getPoder());
    }
}