import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dia1 {

    public static void main(String[] args) throws FileNotFoundException {


        File inputFile = new File("dia1.txt");
        Scanner sc = new Scanner(inputFile);

        int maxCont = 0;
        int cont = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() == 0) {
                if (cont > maxCont) {
                    maxCont = cont;
                }
                cont = 0;
            } else {
                cont += Integer.parseInt(line);
            }
        }

        System.out.println(maxCont);
    }
}
