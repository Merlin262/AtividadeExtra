import java.util.ArrayList;

public class Cardapio {
    private ArrayList<ItemCardapio> itens;

    public Cardapio() {
        itens = new ArrayList<>();
        itens.add(new ItemCardapio("Hamburguer", 10.0));
        itens.add(new ItemCardapio("Batata frita", 5.0));
        itens.add(new ItemCardapio("Refrigerante", 3.0));
    }

    public void exibir() {
        System.out.println("\nCardápio:");

        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + itens.get(i).getNome() + " - R$" + itens.get(i).getPreco());
        }
    }

    public ItemCardapio getItem(int numeroItem) {
        if (numeroItem > 0 && numeroItem <= itens.size()) {
            return itens.get(numeroItem - 1);
        }
        return null;
    }
}