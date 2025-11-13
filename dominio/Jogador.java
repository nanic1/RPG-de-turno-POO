package dominio;

import java.util.*;

public class Jogador {
    private String nome;
    private List<Personagem> personagens = new ArrayList<>();
    private Inventario inventario = new Inventario();
    private int nivel = 1;
    private int xp = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void adicionarPersonagem(Personagem p) {
        if (!personagens.contains(p)) personagens.add(p);
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void ganharXP(int quantidade) {
        xp += quantidade;
        if (xp >= nivel * 50) {
            nivel++;
            xp = 0;
            System.out.printf("%s subiu para o nível %d\n", nome, nivel);
        }
    }

    public String getNome() { return nome; }

    public void mostrarPersonagens() {
        personagens.forEach(Personagem::mostrarStatus);
    }

    public void mostrarStatus() {
        System.out.printf("Jogador: %s | Nível: %d | XP: %d\n", nome, nivel, xp);
    }

    public void ordenarPersonagensPorNome() {
        personagens.sort(Comparator.comparing(Personagem::getNome));}
}
