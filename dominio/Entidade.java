package dominio;

public abstract class Entidade {
    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;

    public Entidade(String nome, int vidaMaxima) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
    }

    public boolean estaViva() {
        return vidaAtual > 0;
    }

    public void receberDano(int dano) {
        vidaAtual -= dano;
        if (vidaAtual < 0) vidaAtual = 0;
    }

    public void curar(int qtd) {
        vidaAtual += qtd;
        if (vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;
    }

    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getVidaMaxima() { return vidaMaxima; }

    public abstract void mostrarStatus();
}