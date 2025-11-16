package dominio;

import java.util.*;

public class Inventario {
    private List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
        System.out.println("Você obteve: " + item.getNome() + "!\n");
    }

    public void listar() {
        if (itens.isEmpty()) {
            System.out.println("Inventário vazio.");
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + itens.get(i));
        }
    }

    public Item usar(int indice, Entidade alvo) {
        if (indice < 1 || indice > itens.size()) {
            System.out.println("Item inválido.");
            return null;
        }
        Item item = itens.remove(indice - 1);
        item.usar(alvo);
        return item;
    }

    public boolean estaVazio() { return itens.isEmpty(); }
}
