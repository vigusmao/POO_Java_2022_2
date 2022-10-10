public class Carro extends Veiculo {

    public void abastecer() {
        System.out.println("Abastecendo o carro...");
    }

    public void desligar() {
        System.out.println("Desligando o motor");
    }

    @Override
    public void andar(float velocidadeEmKmh) {
        System.out.println(
                "Dirigindo a " +
                        velocidadeEmKmh + " km/h");

    }



}
