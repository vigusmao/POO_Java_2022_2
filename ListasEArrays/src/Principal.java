import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

//        int[] numeros = new int[10];

        ArrayList<Integer> numeros = new ArrayList<>();


        for (int i = 0; i < 50; i++) {
            numeros.add(i*i);
        }

        System.out.println("Tudo bem!");

        System.out.println(numeros.get(13));

    }



}
