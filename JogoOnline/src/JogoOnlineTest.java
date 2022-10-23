import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogoOnlineTest {

    private JogoOnline jogo;
    private Jogador joao;
    private Jogador maria;

    @Before
    public void setUp() {
        jogo = new JogoOnline();
        joao = jogo.cadastrarJogador("Joao", "111");
        maria = jogo.cadastrarJogador("Maria", "222");
        jogo.login("Joao", "111");
        jogo.login("Maria", "222");
    }

    @Test
    public void testarLoginParaSenhaCorreta() {
        assertTrue(
                "O login deve mudar o estado online do jogador para true",
                joao.isOnline());
    }

    @Test
    public void testarLoginParaSenhaIncorreta() {
        jogo.logout("Joao");
        jogo.login("Joao", "2367453");
        assertFalse(
                "O login deve mudar o estado online do jogador para true",
                joao.isOnline());
    }

    @Test
    public void testarLogout() {
        jogo.logout("Joao");
        assertFalse(
                "O logout deve mudar o estado online do jogador para false",
                joao.isOnline());

    }

    @Test
    public void testarIniciarPartida() {

        Partida partida = jogo.iniciarPartida(
                joao, maria);

        assertEquals(joao, partida.getJogador1());
        assertEquals(maria, partida.getJogador2());

        assertTrue(joao.isJogando());
        assertTrue(maria.isJogando());
    }

    @Test
    public void testarEncerrarPartidaEmpate() {
        Partida partida = jogo.iniciarPartida(joao, maria);

        jogo.encerrarPartida(partida, Partida.RESULTADO_EMPATE);

        assertEquals("A pontuação do jogador deve ser atualizada após um empate",
                JogoOnline.SCORE_INICIAL + JogoOnline.PONTO_EMPATE,
                joao.getScoreAcumulado());
        assertEquals("A pontuação do jogador deve ser atualizada após um empate",
                JogoOnline.SCORE_INICIAL + JogoOnline.PONTO_EMPATE,
                maria.getScoreAcumulado());
    }

    @Test
    public void testarEncerrarPartidaComVitoriaJogador1() {
        Partida partida = jogo.iniciarPartida(joao, maria);

        jogo.encerrarPartida(partida, Partida.RESULTADO_VITORIA_JOGADOR_1);

        assertEquals("A pontuação do jogador deve ser atualizada após uma vitória",
                JogoOnline.SCORE_INICIAL + JogoOnline.PONTO_VITORIA,
                joao.getScoreAcumulado());
        assertEquals("A pontuação do jogador deve ser atualizada após uma derrota",
                JogoOnline.SCORE_INICIAL + JogoOnline.PONTO_DERROTA,
                maria.getScoreAcumulado());
    }

    @Test
    public void testarEncerrarPartidaComVitoriaJogador2() {
        Partida partida = jogo.iniciarPartida(joao, maria);

        jogo.encerrarPartida(partida, Partida.RESULTADO_VITORIA_JOGADOR_2);

        assertEquals("A pontuação do jogador deve ser atualizada após uma derrota",
                JogoOnline.SCORE_INICIAL + JogoOnline.PONTO_DERROTA,
                joao.getScoreAcumulado());
        assertEquals("A pontuação do jogador deve ser atualizada após uma vitória",
                JogoOnline.SCORE_INICIAL + JogoOnline.PONTO_VITORIA,
                maria.getScoreAcumulado());
    }

    @Test
    public void testarEscolherAdversario() {
        Jogador adversario = jogo.escolherAdversario(joao);
        assertEquals(maria, adversario);
    }

    @Test
    public void testarEscolherAdversarioSemAdversarioDisponivel() {
        jogo.logout("Maria");

        Jogador adversario = jogo.escolherAdversario(joao);
        assertNull(adversario);
    }

}
