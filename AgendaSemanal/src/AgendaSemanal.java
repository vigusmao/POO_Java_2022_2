import java.util.*;

public class AgendaSemanal {

    Map<DiaETurno, List<Compromisso>> compromissosPorDiaETurno;

    public AgendaSemanal() {
        compromissosPorDiaETurno = new HashMap<>();
    }

    public void marcarCompromisso(Dia dia,
                                  Turno turno,
                                  String descricao) throws TurnoLotadoException {

        DiaETurno dt = new DiaETurno(dia, turno);

        List<Compromisso> compromissos =
                compromissosPorDiaETurno.get(dt);

        if (compromissos != null &&
                compromissos.size() >= turno.getMaxCompromissos()) {
            throw new TurnoLotadoException(compromissos);
        }

        if (compromissos == null) {
            compromissos = new ArrayList<>();
            compromissosPorDiaETurno.put(dt, compromissos);
        }

        Compromisso novoCompromisso = new Compromisso(
                dia, turno, descricao);

        compromissos.add(novoCompromisso);
    }

    public List<Compromisso> recuperarCompromissos(
            Dia dia, Turno turno) {

        DiaETurno dt = new DiaETurno(dia, turno);
        return compromissosPorDiaETurno.get(dt);
    }

    public Turno obterTurnoMaisCheio() {
        final int quantTurnos = Turno.values().length;
        int contadores[] = new int[quantTurnos];

        for (List<Compromisso> lista : compromissosPorDiaETurno.values()) {
            if (lista != null) {
                for (Compromisso c : lista) {
                    Turno turno = c.getTurno();
                    int indice = turno.ordinal();
                    contadores[indice]++;
                }
            }
        }

        int maior = -1;
        Turno turnoMaisCheio = null;
        for (int i = 0; i < quantTurnos; i++) {
            if (contadores[i] > maior) {
                maior = contadores[i];
                turnoMaisCheio = Turno.values()[i];
            }
        }

        return turnoMaisCheio;
    }

    private class DiaETurno {
        Dia dia;
        Turno turno;

        DiaETurno(Dia d, Turno t) {
            dia = d;
            turno = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DiaETurno diaETurno = (DiaETurno) o;
            return dia == diaETurno.dia &&
                    turno == diaETurno.turno;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dia, turno);
        }
    }
}
