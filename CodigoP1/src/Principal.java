import java.util.ArrayList;

public class Principal {

    public static Instrumento escolherInstrumento(boolean instrumentoDeCordas) {
        return instrumentoDeCordas ?
                new Guitarra("Gibson", "Les Paul") :  // assuma construtor ok
                new Flauta("Yamaha");                 // idem
    }

    public static void main(String[] args) {
        Instrumento gibson1 = escolherInstrumento(true);  // linha 1
        //Guitarra gibson2 = escolherInstrumento(true);  // linha 2
        Instrumento whatever = escolherInstrumento(false);  // linha 3
        Guitarra fender = new Guitarra("Fender", "Strato");  // linha 4
        gibson1.setVolume(75);  // linha 5
//        gibson1.trocarAsCordas();  // linha 6
        gibson1.testar();  // linha 7
//        whatever.trocarAsCordas();  // linha 8
        whatever.testar();  // linha 9
        fender.trocarAsCordas();  // linha 10
        fender.testar();  // linha 11



        Flauta[] flautas = new Flauta[10];
        flautas[0] = new Flauta("Yamaha");
        flautas[1] = new Flauta("Hering");


    }

    public static int contarGuitarras(
            ArrayList<Guitarra> guitarras) {

        int contador = 0;

        for (Guitarra g : guitarras) {
            if (g.precisaTrocarAsCordas()) {
                contador++;
            }
        }

        return contador;
    }
}
