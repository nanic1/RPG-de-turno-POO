package dominio;

public class Batalha {
    private Personagem jogador;
    private Inimigo inimigo;

    public Batalha(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void iniciar() {
        System.out.println("\n--- A batalha começou! ---");
        while (jogador.estaViva() && inimigo.estaViva()) {
            jogador.atacar(inimigo);
            if (inimigo.estaViva())
                inimigo.atacar(jogador);
        }
        System.out.println(jogador.estaViva() ? "Vitória!" : "Derrota...");
    }
}