import java.util.ArrayList;
import java.util.List;

public class JogoOnline {

    public static final int PONTO_VITORIA = 3;
    public static final int PONTO_DERROTA = 0;
    public static final int PONTO_EMPATE = 1;

    public static final int SCORE_INICIAL = 1000;

    private List<Jogador> jogadores;

    public JogoOnline() {
        jogadores = new ArrayList<>();
    }

    private Jogador encontrarJogador(String username) {
        for (Jogador j : this.jogadores) {
            if (j.getUsername().equals(username)) {
                return j;
            }
        }
        return null;
    }

    public Jogador cadastrarJogador(String username,
                                    String senha) {
        Jogador jogador = encontrarJogador(username);
        if (jogador != null) {
            throw new RuntimeException("Jogador já existe!!!");
            // ToDo trocar para checked exception -- não é bug do sistema!
        }

        jogador = new Jogador(username, senha);
        this.jogadores.add(jogador);

        return jogador;
    }

    public void login(String username, String senha) {
        Jogador jogador = encontrarJogador(username);
        if (jogador == null) {
            // ToDo lançar exceção!
            return;  // jogador não-cadastrado!
        }

        if (jogador.getSenha().equals(senha)) {
            jogador.setOnline(true);
        }  // ToDo lançar exceção!
    }

    public void logout(String username) {
        Jogador jogador = encontrarJogador(username);
        if (jogador == null) {
            return;  // jogador não-cadastrado!
        }

        jogador.setOnline(false);
    }

    public Partida iniciarPartida(Jogador jogador1,
                                  Jogador jogador2) {
        if (!jogador1.isOnline() ||
                jogador1.isJogando() ||
                !jogador2.isOnline() ||
                jogador2.isJogando()) {
            return null;  // ToDo lançar exceção com o motivo!
        }

        Partida novaPartida = new Partida(jogador1, jogador2);

        jogador1.registrarPartidaIniciada(novaPartida);
        jogador2.registrarPartidaIniciada(novaPartida);

        return novaPartida;
    }

    // ToDo escrever o javadoc desse método
    public Jogador escolherAdversario(Jogador solicitante) {
        for (Jogador j : this.jogadores) {
            if (!j.equals(solicitante) &&
                    j.isOnline() &&
                    !j.isJogando()) {
                return j;
            }
        }
        return null;
    }

    public void encerrarPartida(Partida partida,
                                int resultado) {
        // ToDO lançar exceção se partida já concluída
        // ToDo escrever unit test para isso
        partida.setResultado(resultado);
    }
}
