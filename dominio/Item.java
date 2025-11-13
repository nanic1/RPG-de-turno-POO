package dominio;

public class Item {
    private String nome;
    private String descricao;
    private int efeito; // pontos de cura, por exemplo

    public Item(String nome, String descricao, int efeito) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getEfeito() { return efeito; }

    public void usar(Entidade alvo) {
        alvo.curar(efeito);
        System.out.printf(alvo.getNome() + " usa %s e recupera %d de vida!", nome, efeito);
    }

    @Override
    public String toString() {
        return nome + " (" + descricao + ")";
    }
}
