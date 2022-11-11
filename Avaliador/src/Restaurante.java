public class Restaurante extends Estabelecimento {

    private String tipo;

    public Restaurante(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getTipo(){
        return this.tipo;
    }
}
