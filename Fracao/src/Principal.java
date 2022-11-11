import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nNumerador: ");
        int numerador = sc.nextInt();
        System.out.println("\nDenominador: ");
        int denominador = sc.nextInt();

        Fracao x;

        x = new Fracao(numerador, denominador);

        System.out.println(x);
    }
}
