import java.util.Random;

public class Avaliador<T extends Avaliavel> {

    private String nome;

    private static Random random = new Random();

    public Avaliador(String nome) {
        this.nome = nome;
    }

    public void avaliar(T avaliavel) {
        int nota = random.nextInt(10) + 1;
        avaliavel.receberAvaliacao(this, nota);
    }

    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
        Avaliador<Avaliavel> guiaGenerico = new Avaliador("Guia");
        Hotel rioHotel = new Hotel();
        Carro calhambeque = new Carro();

        guiaGenerico.avaliar(rioHotel);
        guiaGenerico.avaliar(calhambeque);


        Avaliador<Carro> guiaQuatroRodas = new Avaliador<>("Quatro Rodas");
//        guiaQuatroRodas.avaliar(rioHotel);
        guiaQuatroRodas.avaliar(calhambeque);



    }
}
