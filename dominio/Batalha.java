package dominio;

import java.util.Scanner;

public class Batalha {
    private Personagem jogador;
    private Inimigo inimigo;
    private Scanner input = new Scanner(System.in);

    public Batalha(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void iniciar() {
        System.out.println("\n--- A batalha começou! ---");

        while (jogador.estaViva() && inimigo.estaViva()) {

            System.out.println("\n===== STATUS =====");
            jogador.mostrarStatus();
            inimigo.mostrarStatus();
            System.out.println("==================");

            turnoJogador();

            if (!inimigo.estaViva()) break;

            turnoInimigo();
        }

        System.out.println(jogador.estaViva() ? "\n🎉 Vitória!" : "\n💀 Derrota...");
    }

    private void turnoJogador() {
        System.out.println("\n--- Sua vez ---");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Usar Habilidade");
        System.out.println("4 - Usar Item");
        System.out.println("5 - Fugir");
        System.out.print("Escolha: ");

        int escolha = safeNextInt();

        switch (escolha) {
            case 1:
                jogador.atacar(inimigo);
                break;

            case 2:
                jogador.defender();
                break;

            case 3:
                escolherHabilidade();
                break;

            case 4:
                usarItem();
                break;

            case 5:
                System.out.println("Você fugiu da batalha!");
                // finaliza batalha forçando inimigo a morrer simbolicamente
                inimigo.receberDano(inimigo.getVidaAtual());
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void turnoInimigo() {
        System.out.println("\n--- Turno do inimigo ---");

        // decisão simples: 20% de chance de defender, senão atacar
        if (Math.random() < 0.2) {
            // se quiser que defesa do inimigo seja relevante, implemente defesa nele
            inimigo.defender();
        } else {
            inimigo.atacar(jogador);
        }
    }

    private void escolherHabilidade() {
        if (jogador.getHabilidades().isEmpty()) {
            System.out.println("Você não possui habilidades!");
            return;
        }

        System.out.println("\nEscolha uma habilidade:");
        for (int i = 0; i < jogador.getHabilidades().size(); i++) {
            System.out.println((i + 1) + " - " + jogador.getHabilidades().get(i));
        }

        int escolha = safeNextInt();
        if (escolha < 1 || escolha > jogador.getHabilidades().size()) {
            System.out.println("Habilidade inválida!");
            return;
        }

        Habilidade h = jogador.getHabilidades().get(escolha - 1);

        // escolhe alvo dependendo do tipo da habilidade
        if (h.getTipo() == TipoHabilidade.CURA) {
            jogador.usarHabilidade(h, jogador); // cura a si mesmo (personagem)
        } else {
            jogador.usarHabilidade(h, inimigo); // habilidade ofensiva no inimigo
        }
    }

    private void usarItem() {
        Jogador dono = jogador.getDono();
        if (dono == null) {
            System.out.println("Este personagem não tem dono cadastrado. Não é possível acessar inventário.");
            return;
        }

        Inventario inv = dono.getInventario();
        if (inv.estaVazio()) {
            System.out.println("Inventário vazio!");
            return;
        }

        inv.listar();
        System.out.print("Escolha um item (número): ");
        int escolha = safeNextInt();

        inv.usar(escolha, jogador); // usa o item sobre o personagem que está em combate
    }

    // leitura segura de int (consome buffer)
    private int safeNextInt() {
        try {
            return Integer.parseInt(input.next());
        } catch (Exception e) {
            return -1;
        }
    }
}
