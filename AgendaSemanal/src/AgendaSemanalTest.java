import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AgendaSemanalTest {

    private AgendaSemanal agenda;

    @Before
    public void setUp(){
        agenda = new AgendaSemanal();
    }

    @Test
    public void testarMarcacao() throws TurnoLotadoException {
        agenda.marcarCompromisso(
                Dia.QUA,
                Turno.NOITE,
                "Estudar");

        //vamos agora recuperar os compromissos
        // de quarta à noite

        List<Compromisso> compromissos =
                agenda.recuperarCompromissos(
                Dia.QUA,
                Turno.NOITE);

        // pegamos o primeiro compromisso da lista

        Compromisso compromissoRecuperado =
                compromissos.get(0);

        assertEquals(Dia.QUA, compromissoRecuperado.getDia());
        assertEquals(Turno.NOITE, compromissoRecuperado.getTurno());
        assertEquals("Estudar", compromissoRecuperado.getDescricao());

        agenda.marcarCompromisso(
                Dia.QUA,
                Turno.NOITE,
                "Pagar contas");

        compromissos =
                agenda.recuperarCompromissos(
                        Dia.QUA,
                        Turno.NOITE);

        assertEquals(2, compromissos.size());
    }

    @Test
    public void testarMarcacaoTurnoLotado() throws TurnoLotadoException {
        agenda.marcarCompromisso(
                Dia.QUA,
                Turno.NOITE,
                "Estudar");

        agenda.marcarCompromisso(
                Dia.QUA,
                Turno.NOITE,
                "Tomar Banho");

        // agora vou exceder a lotação: quero ver a exceção!!!
        try {
            agenda.marcarCompromisso(
                    Dia.QUA,
                    Turno.NOITE,
                    "Pagar Contas");

            fail("Uma exceção deve ser lançada se " +
                    "excedermos o max do turno");

        } catch (TurnoLotadoException e) {
            // ok!!! era esperado!!!
        }
    }

    @Test
    public void testarObterTurnoMaisCheio() throws TurnoLotadoException {
        agenda.marcarCompromisso(
                Dia.QUA,
                Turno.NOITE,
                "Estudar");

        agenda.marcarCompromisso(
                Dia.QUI,
                Turno.MANHA,
                "Correr");

        agenda.marcarCompromisso(
                Dia.SEX,
                Turno.NOITE,
                "Sair");

        Turno turnoMaisCheio = agenda.obterTurnoMaisCheio();

        assertEquals(Turno.NOITE, turnoMaisCheio);
    }
}