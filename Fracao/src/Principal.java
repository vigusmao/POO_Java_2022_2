public class Principal {

    public static void main(String[] args) {

        Fracao x, y;

        x = new Fracao(1, 2);
        y = new Fracao(2, 3);

        y.copyFrom(x);

        System.out.println(x);
        System.out.println(y);





    }
}
