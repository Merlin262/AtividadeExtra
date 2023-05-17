import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();

        while (true) {
            System.out.println("Bem-vindo ao Restaurante!\n");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Fazer Pedido");
            System.out.println("2 - Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                scanner.nextLine();

                cardapio.exibir();

                Pedido pedido = new Pedido();

                while (true) {
                    System.out.println("Digite o número do item que deseja adicionar ao pedido (ou 0 para finalizar o pedido):");
                    int numeroItem = scanner.nextInt();

                    if (numeroItem == 0) {
                        break;
                    }

                    ItemCardapio item = cardapio.getItem(numeroItem);

                    if (item != null) {
                        pedido.adicionarItem(item);
                        System.out.println("Item adicionado ao pedido: " + item.getNome() + " - R$" + item.getPreco());
                    } else {
                        System.out.println("Item não encontrado no cardápio.");
                    }
                }

                double taxaServico = pedido.calcularTaxaServico(0.1);
                double valorTotal = pedido.calcularValorTotal(taxaServico);

                System.out.println("\nNota Fiscal:");
                System.out.println("Itens do pedido:");

                for (ItemPedido item : pedido.getItens()) {
                    System.out.println(item.getNome() + " - R$" + item.getPreco());
                }

                System.out.println("Taxa de serviço(10%): R$" + taxaServico);
                System.out.println("Valor total: R$" + valorTotal);
                System.out.println("\nDigite o valor recebido:");
                double valorRecebido = scanner.nextDouble();

                double troco = valorRecebido - valorTotal;

                System.out.println("Troco: R$" + troco);

            } else if (opcao == 2) {
                System.out.println("Obrigado por utilizar o nosso sistema!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
