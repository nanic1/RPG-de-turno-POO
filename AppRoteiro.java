import dominio.*;

public class AppRoteiro {

    public static void main(String[] args) {
        // criacao de personagens
        Jogador jogador = new Jogador("Herói");
        Guerreiro guerreiro = new Guerreiro("Radagon");
        Mago mago = new Mago("Logan");
        Arqueiro arqueiro = new Arqueiro("Gough");

        // inimigo
        Inimigo goblin = new Inimigo("Goblin", 80, 10);

        // criando pots
        Item pocao = new Item("Poção Pequena", "Restaura 20 HP", 20);
        Item elixir = new Item("Elixir", "Restaura 50 HP", 50);

        String nomePocao = pocao.getNome();
        String descPocao = pocao.getDescricao();

        String nomeElixir = elixir.getNome();
        String descElixir = elixir.getDescricao();

        // criando inventario para podermos armazenar os itens
        Inventario inv = new Inventario();
        inv.adicionar(pocao);
        inv.adicionar(elixir);

        // mago será o saco de pancada para nossos testes kkkkkkkk
        goblin.atacar(mago);
        goblin.atacar(mago);
        mago.mostrarStatus();
        inv.usar(1, mago);
        mago.mostrarStatus();
        goblin.atacar(mago);
        goblin.atacar(mago);
        goblin.atacar(mago);
        mago.mostrarStatus();
        inv.usar(2, mago);
        mago.mostrarStatus();

        // criando habilidades para os protagonistas
        Habilidade golpeDuplo = new Habilidade("Golpe Duplo", TipoHabilidade.ATAQUE, 12);
        Habilidade bolaDeFogo = new Habilidade("Bola de Fogo", TipoHabilidade.ATAQUE, 15);
        Habilidade chuvaDeFlechas = new Habilidade("Chuva de Flechas", TipoHabilidade.ATAQUE, 13);

        // atribuindo as habilidade
        guerreiro.adicionarHabilidade(golpeDuplo);
        mago.adicionarHabilidade(bolaDeFogo);
        arqueiro.adicionarHabilidade(chuvaDeFlechas);

        // acoes de teste em combate
        guerreiro.atacar(goblin);
        goblin.mostrarStatus();
        goblin.atacar(guerreiro);
        guerreiro.mostrarStatus();
        guerreiro.usarHabilidade(golpeDuplo, goblin);
        goblin.mostrarStatus();
        mago.atacar(goblin);
        goblin.mostrarStatus();
        goblin.atacar(mago);
        mago.mostrarStatus();
        mago.usarHabilidade(bolaDeFogo, goblin);
        goblin.mostrarStatus();
        arqueiro.atacar(goblin);
        goblin.mostrarStatus();
        goblin.atacar(arqueiro);
        arqueiro.mostrarStatus();
        arqueiro.usarHabilidade(chuvaDeFlechas, goblin);
        goblin.mostrarStatus();
    }
}
