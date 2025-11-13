import dominio.*;

public class ScriptedDemo {
    public static void main(String[] args) {
        Jogador j1 = new Jogador("Arthur");
        Guerreiro g = new Guerreiro("Thorin");
        Mago m = new Mago("Gandalf");
        Arqueiro a = new Arqueiro("Legolas");

        g.adicionarHabilidade(new Habilidade("Golpe Poderoso", TipoHabilidade.ATAQUE, 20));
        m.adicionarHabilidade(new Habilidade("Cura Arcana", TipoHabilidade.CURA, 15));
        a.adicionarHabilidade(new Habilidade("Flecha de Fogo", TipoHabilidade.ATAQUE, 18));

        j1.adicionarPersonagem(g);
        j1.adicionarPersonagem(m);
        j1.adicionarPersonagem(a);

        Inimigo orc = new Inimigo("Orc", 90, 10);
        Batalha b1 = new Batalha(g, orc);
        b1.iniciar();

        System.out.println("\n--- Fim da demonstração ---");
    }
}