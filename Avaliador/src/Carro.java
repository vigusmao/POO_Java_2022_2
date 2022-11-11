public class Carro implements Avaliavel {

    private int contAvaliacoesRecebidas;

    public Carro() {
        this.contAvaliacoesRecebidas = 0;
    }

    @Override
    public void receberAvaliacao(Avaliador avaliador, int nota) {
        contAvaliacoesRecebidas++;
    }
}
