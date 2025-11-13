package dominio;

public class Habilidade {
    private String nome;
    private TipoHabilidade tipo;
    private int poder;

    public Habilidade(String nome, TipoHabilidade tipo, int poder) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
    }

    public String getNome() { return nome; }
    public TipoHabilidade getTipo() { return tipo; }
    public int getPoder() { return poder; }

    @Override
    public String toString() {
        return nome + " (" + tipo + " - " + poder + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habilidade)) return false;
        Habilidade h = (Habilidade) o;
        return nome.equals(h.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}