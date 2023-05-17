import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemPedido> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(new ItemPedido(item.getNome(), item.getPreco()));
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public double calcularTaxaServico(double taxa) {
        double valorTotal = calcularValorTotal(0);
        return valorTotal * taxa;
    }

    public double calcularValorTotal(double taxaServico) {
        double valorTotal = 0;

        for (ItemPedido item : itens) {
            valorTotal += item.getPreco();
        }

        return valorTotal + taxaServico;
    }
}
