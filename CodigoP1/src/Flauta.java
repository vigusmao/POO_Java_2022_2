public class Flauta extends Instrumento {
    // assuma que existe aqui o MÍNIMO DE CÓDIGO para Flauta compilar sem erros

    public Flauta(String marca) {
        super(marca, "flauta doce");
    }

    @Override
    public int getVolumeMaximo() {
        return 30;
    }
}
