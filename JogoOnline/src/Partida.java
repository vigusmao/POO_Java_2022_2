public class Partida {

    public static final int RESULTADO_EMPATE = 0;
    public static final int RESULTADO_VITORIA_JOGADOR_1 = 1;
    public static final int RESULTADO_VITORIA_JOGADOR_2 = 2;

    private final Jogador jogador1;
    private final Jogador jogador2;

    /* 1, se vitória do jogador 1;
       2, se vitória do jogador 2;
       0, se empate
     */
    private int resultado;

    public Partida(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;

        jogador1.registrarPartidaEncerrada(this);
        jogador2.registrarPartidaEncerrada(this);
    }
}
