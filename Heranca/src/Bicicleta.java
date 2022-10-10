public class Bicicleta extends Veiculo {

    private boolean comRodinhas;

    public Bicicleta(String marca, boolean comRodinhas) {
        super("Bicicleta da marca " + marca, 2);
        this.comRodinhas = comRodinhas;
    }

    @Override
    public void andar(float velocidadeEmKmh) {
        System.out.println(
                "Pedalando a " +
                        velocidadeEmKmh + " km/h");
    }

}
