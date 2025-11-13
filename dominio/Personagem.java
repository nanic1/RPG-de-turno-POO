package dominio;

import java.util.*;

public abstract class Personagem extends Entidade implements Acoes {

    protected int ataque;
    protected int defesa;
    protected List<Habilidade> habilidades = new ArrayList<>();
    protected int defesaTemporaria = 0; // zera-se após absorver um ataque

    // 🔥 NOVO: vínculo de agregação com Jogador (para acessar inventário na batalha)
    private Jogador dono;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // ---------------------------
    // 🔥 GET/SET DO DONO
    // ---------------------------
    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public Jogador getDono() {
        return this.dono;
    }

    // ---------------------------
    // DEFESA
    // ---------------------------
    public void aplicarDefesaTemporaria(int valor) {
        this.defesaTemporaria += valor;
    }

    public int getDefesaTotal() {
        return this.defesa + this.defesaTemporaria;
    }

    public void resetarDefesaTemporaria() {
        this.defesaTemporaria = 0;
    }

    // ---------------------------
    // HABILIDADES
    // ---------------------------
    public void adicionarHabilidade(Habilidade h) {
        if (!habilidades.contains(h))
            habilidades.add(h);
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public abstract void usarHabilidade(Habilidade h, Entidade alvo);

    // ---------------------------
    // STATUS
    // ---------------------------
    @Override
    public void mostrarStatus() {
        System.out.println(nome + " [HP: " + vidaAtual + "/" + vidaMaxima + "]");
    }

    @Override
    public void receberDano(int dano) {
        int danoFinal = dano;

        // Se for Personagem, aplica a defesa total (base + temporária)
        if (this instanceof Personagem) {
            Personagem p = (Personagem) this;
            int def = p.getDefesaTotal();
            danoFinal = dano - def;
            if (danoFinal < 0) danoFinal = 0;
            // defesa temporária é consumida ao absorver dano
            p.resetarDefesaTemporaria();
        }

        vidaAtual -= danoFinal;
        if (vidaAtual < 0) vidaAtual = 0;
    }
}
