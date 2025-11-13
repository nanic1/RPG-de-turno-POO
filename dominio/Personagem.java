package dominio;

import java.util.*;

public abstract class Personagem extends Entidade implements Acoes {
    protected int ataque;
    protected int defesa;
    protected List<Habilidade> habilidades = new ArrayList<>();

    public Personagem(String nome, int vida, int ataque, int defesa) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public void adicionarHabilidade(Habilidade h) {
        if (!habilidades.contains(h))
            habilidades.add(h);
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public abstract void usarHabilidade(Habilidade h, Entidade alvo);

    @Override
    public void mostrarStatus() {
        System.out.println(nome + " [HP: " + vidaAtual + "/" + vidaMaxima + "]");
    }
}