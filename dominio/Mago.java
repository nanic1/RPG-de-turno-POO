package dominio;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 80, 15, 5);
    }

    @Override
    public void atacar(Entidade alvo) {
        int dano = ataque + (int)(Math.random() * 10);
        alvo.receberDano(dano);
        System.out.println(nome + " lança um feitiço em " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        System.out.println(nome + " cria uma barreira mágica!");
        defesa += 3;
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        if (h.getTipo() == TipoHabilidade.CURA) {
            curar(h.getPoder());
            System.out.println(nome + " se cura em " + h.getPoder() + " pontos!");
        } else {
            alvo.receberDano(h.getPoder());
            System.out.println(nome + " conjura " + h.getNome() + " e causa " + h.getPoder() + " de dano!");
        }
    }
}