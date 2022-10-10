public abstract class Veiculo extends Object {

    private int numeroDeRodas;

    private int maxPassageiros;

    private int anoFabricacao;

    private String modelo;

    public Veiculo() {
        this("Desconhecido");
    }

    public Veiculo(String modelo) {
        this(modelo, 4);
    }

    public Veiculo(String modelo, int numeroDeRodas) {
        this.modelo = modelo;
        this.numeroDeRodas = numeroDeRodas;
    }

    public int getNumeroDeRodas() {
        return numeroDeRodas;
    }

    public void setNumeroDeRodas(int numeroDeRodas) {
        this.numeroDeRodas = numeroDeRodas;
    }

    public abstract void andar(float velocidadeEmKmh);

    @Override
    public String toString() {
        return String.format(
                "%s (%d rodas)",
                this.modelo, this.numeroDeRodas);
    }

}
