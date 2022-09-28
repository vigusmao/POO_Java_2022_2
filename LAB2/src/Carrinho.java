import java.util.ArrayList;

public class Carrinho {

    private ArrayList<ItemCarrinho> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto,
                                 int quant) {
        ItemCarrinho novoItem = new ItemCarrinho(produto, quant);
        itens.add(novoItem);

    }

    public float getPrecoTotal() {
        float total = 0;

        for (ItemCarrinho item : itens) {
            total += item.getPrecoItem();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Conteúdo do carrinho:\n\n");

        for (ItemCarrinho item : itens) {
            sb.append(item.getProduto().getDescricao());
            sb.append(" (")
                    .append(item.getQuantidade())
                    .append(" unidade");
            if (item.getQuantidade() > 1) {
                sb.append("s");
            }
            sb.append(") -- R$");
            sb.append(String.format("%.2f", item.getPrecoItem()));
            sb.append("\n");
        }

        sb.append("\nPreço total: R$");
        sb.append(String.format("%.2f", getPrecoTotal()));

        return sb.toString();
    }
}
