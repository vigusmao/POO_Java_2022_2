import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jogador {

    private final String username;
    private String senha;
    private int scoreAcumulado;
    private ArrayList<Partida> partidasConcluidas;
    private boolean online;
    private boolean jogando;

    public Jogador(String username, String senha) {
        this.username = username;
        this.senha = senha;
        this.scoreAcumulado = JogoOnline.SCORE_INICIAL;
        this.online = false;
        this.jogando = false;
        this.partidasConcluidas = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getScoreAcumulado() {
        return scoreAcumulado;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public void registrarPartidaIniciada(Partida partida) {
        this.jogando = true;
    }

    public void registrarPartidaEncerrada(Partida partida) {

        this.partidasConcluidas.add(partida);
        this.jogando = false;

        int resultado = partida.getResultado();

        if (resultado == Partida.RESULTADO_EMPATE) {
            // empate
            this.scoreAcumulado += JogoOnline.PONTO_EMPATE;  // empate

        } else if (resultado == Partida.RESULTADO_VITORIA_JOGADOR_1 &&
                partida.getJogador1().equals(this) ||
            resultado == Partida.RESULTADO_VITORIA_JOGADOR_2 &&
                partida.getJogador2().equals(this)) {
            // vitória
            this.scoreAcumulado += JogoOnline.PONTO_VITORIA;

        } else {
            // derrota
            this.scoreAcumulado += JogoOnline.PONTO_DERROTA;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(username, jogador.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
