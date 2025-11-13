import dominio.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Jogador jogador = new Jogador("Herói");

        Guerreiro guerreiro = new Guerreiro("Ragnar");
        Mago mago = new Mago("Merlin");
        Arqueiro arqueiro = new Arqueiro("Robin");

        jogador.adicionarPersonagem(guerreiro);
        jogador.adicionarPersonagem(mago);
        jogador.adicionarPersonagem(arqueiro);

        System.out.println("=== Bem-vindo ao RPG: Aventura no Reino ===");

        boolean jogando = true;
        while (jogando) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Explorar área");
            System.out.println("2 - Ver inventário");
            System.out.println("3 - Ver status");
            System.out.println("4 - Sair");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1 -> {
                    int evento = rand.nextInt(3);
                    if (evento == 0) {
                        System.out.println("Você encontrou um inimigo!");
                        Inimigo inimigo = new Inimigo("Goblin", 60 + rand.nextInt(40), 10);
                        System.out.println("Com qual personagem deseja lutar?");
                        for (int i = 0; i < jogador.getPersonagens().size(); i++) {
                            System.out.println((i + 1) + " - " + jogador.getPersonagens().get(i).getNome());
                        }
                        int idx = sc.nextInt() - 1;
                        sc.nextLine();
                        Personagem p = jogador.getPersonagens().get(idx);
                        Batalha b = new Batalha(p, inimigo);
                        b.iniciar();
                        if (p.estaViva()) jogador.ganharXP(30);
                    } else if (evento == 1) {
                        System.out.println("Você encontrou um item!");
                        Item item = new Item("Poção de Vida", "Cura 20 de HP", 20);
                        jogador.getInventario().adicionar(item);
                    } else {
                        System.out.println("A área está vazia... nada acontece.");
                    }
                }

                case 2 -> {
                    jogador.getInventario().listar();
                    if (!jogador.getInventario().estaVazio()) {
                        System.out.println("Usar item? (s/n)");
                        if (sc.nextLine().equalsIgnoreCase("s")) {
                            System.out.println("Escolha o item:");
                            int idx = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Em qual personagem?");
                            for (int i = 0; i < jogador.getPersonagens().size(); i++) {
                                System.out.println((i + 1) + " - " + jogador.getPersonagens().get(i).getNome());
                            }
                            int pIdx = sc.nextInt();
                            sc.nextLine();
                            jogador.getInventario().usar(idx, jogador.getPersonagens().get(pIdx - 1));
                        }
                    }
                }

                case 3 -> {
                    jogador.mostrarStatus();
                    jogador.mostrarPersonagens();
                }

                case 4 -> {
                    jogando = false;
                    System.out.println("Saindo da aventura...");
                }
            }
        }
        sc.close();
    }
}
