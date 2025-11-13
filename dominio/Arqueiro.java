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
        System.out.printf("%s ergue o escudo!", nome);
        aplicarDefesaTemporaria(5); // +5 apenas para o próximo golpe
    }

    @Override
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        System.out.printf("%s dispara " + h.getNome() + "!", nome);
        alvo.receberDano(h.getPoder());
    }
}