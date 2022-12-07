package dominio;

public enum TipoDisciplina {

    GRADUACAO(5),
    POS_GRADUACAO(7);

    private float notaMinimaAprovacao;

    TipoDisciplina(float notaMinimaAprovacao) {
        this.notaMinimaAprovacao = notaMinimaAprovacao;
    }

    public float getNotaMinimaAprovacao() {
        return this.notaMinimaAprovacao;
    }
}
