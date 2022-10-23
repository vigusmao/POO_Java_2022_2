import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Principal {

    private static final int TAMANHO = 80_000;

    private static Random random;

    public static ArrayList<Integer> obterIntersecaoIngenuo(
            ArrayList<Integer> lista1,
            ArrayList<Integer> lista2) {

        ArrayList<Integer> intersecao = new ArrayList<>();

        for (Integer elementoLista1 : lista1) {
            for (Integer elementoLista2 : lista2) {
                if (elementoLista2.equals(elementoLista1)) {
                    intersecao.add(elementoLista1);
                }
            }
        }

        return intersecao;
    }

    public static ArrayList<Integer> obterIntersecaoBombado(
            ArrayList<Integer> lista1,
            ArrayList<Integer> lista2) {

        ArrayList<Integer> intersecao = new ArrayList<>();

        HashSet<Integer> conjunto = new HashSet<>(lista2.size());

        for (Integer elementoLista2 : lista2) {
            conjunto.add(elementoLista2);
        }

        for (Integer elementoLista1 : lista1) {
            if (conjunto.contains(elementoLista1)) {
                intersecao.add(elementoLista1);
            }
        }

        return intersecao;
    }

    private static ArrayList<Integer> construirListaAleatoria(
            int tamanho) {

        ArrayList<Integer> lista = new ArrayList<>(tamanho);

        int ultimoIncluido = 0;
        for (int i = 0; i < tamanho; i++) {
            int passo = random.nextInt(10) + 1;
            int numero = ultimoIncluido + passo;
            lista.add(numero);
            ultimoIncluido = numero;
        }

        return lista;
    }


    public static void main(String[] args) {
        random = new Random();

        ArrayList<Integer> lista1 =
                construirListaAleatoria(TAMANHO);
        ArrayList<Integer> lista2 =
                construirListaAleatoria(TAMANHO);

//        System.out.println(lista1);
//        System.out.println(lista2);

        System.out.println("\nIngênuo...");
        long inicio = System.currentTimeMillis();
        ArrayList<Integer> intersecao = obterIntersecaoIngenuo(
                lista1, lista2);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nTamanho da interseção = %d",
                intersecao.size());
        System.out.printf("\nDuração: %.3f segundos",
                duracao / 1000f);

        System.out.println("\nBombado...");
        inicio = System.currentTimeMillis();
        intersecao = obterIntersecaoBombado(lista1, lista2);
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nTamanho da interseção = %d",
                intersecao.size());
        System.out.printf("\nDuração: %.3f segundos",
                duracao / 1000f);
    }

}
