package dominio;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 80, 15, 5);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque + (int)(Math.random() * 10);
        alvo.receberDano(dano);
        System.out.printf("%s lanca um feitico em " + alvo.getNome() + " causando %d de dano!\n", nome, dano);
    }

    @Override
    public void defender() {
        defendendo = true;
        defesaGasta = false;
        System.out.printf("%s, ergue o escudo!\n", nome);
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        if (h.getTipo() == TipoHabilidade.CURA) {
            curar(h.getPoder());
            System.out.printf("%s se cura em " + h.getPoder() + " pontos!\n", nome);
        } else {
            alvo.receberDano(h.getPoder());
            System.out.printf("%s conjura " + h.getNome() + " e causa " + h.getPoder() + " de dano!\n", nome);
        }
    }
}