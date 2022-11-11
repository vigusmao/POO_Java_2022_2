import java.util.ArrayList;

public abstract class Estabelecimento implements Avaliavel {

    private String nome;

    private ArrayList<AvaliacaoRecebida> avaliacoes;

    public String getTipo() {
        return getClass().getName();
    }

    public void receberAvaliacao(Avaliador avaliador,
                                 int nota) {
        AvaliacaoRecebida novaAvaliacao =
                new AvaliacaoRecebida(avaliador, nota);
        avaliacoes.add(novaAvaliacao);
    }

    public float getMediaAvaliacoes() {
        int somatorioNotas = 0;
        for (AvaliacaoRecebida a : avaliacoes) {
            somatorioNotas += a.nota;
        }
        return somatorioNotas / (float) avaliacoes.size();
    }

    public int getAvaliacaoMaisRecente() {
        return avaliacoes.get(avaliacoes.size() - 1).nota;
    }

    public String getNomeMelhorAvaliador() {
        int maiorNotaAteOMomento = Integer.MIN_VALUE;
        String nomeMelhorAvaliador = null;

        for (AvaliacaoRecebida a : avaliacoes) {
            if (a.nota > maiorNotaAteOMomento) {
                maiorNotaAteOMomento = a.nota;
                nomeMelhorAvaliador = a.avaliador.getNome();
            }
        }

        return nomeMelhorAvaliador;
    }

    // inner class
    private class AvaliacaoRecebida {
        Avaliador avaliador;
        int nota;

        public AvaliacaoRecebida(
                Avaliador avaliador, int nota) {
            this.avaliador = avaliador;
            this.nota = nota;
        }
    }
}
