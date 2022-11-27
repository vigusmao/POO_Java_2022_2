import java.util.List;

public class TurnoLotadoException extends Exception {

    List<Compromisso> compromissos;

    public TurnoLotadoException(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }

    public List<Compromisso> getCompromissos() {
        return this.compromissos;
    }
}
