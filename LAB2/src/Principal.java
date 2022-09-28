public class Principal {

    public static void main(String[] args) {

        Produto tshirt = new Produto(111, "Camisa de algodão");
        Produto bluesuedeshoes = new Produto(222, "Sapato");

        tshirt.setPreco(35.2f);
        bluesuedeshoes.setPreco(80);

        Carrinho meuCarrinho = new Carrinho();
        meuCarrinho.adicionarProduto(tshirt, 2);
        meuCarrinho.adicionarProduto(bluesuedeshoes, 1);

        System.out.println(meuCarrinho.toString());
    }
}
