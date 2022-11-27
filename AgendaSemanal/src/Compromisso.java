public class Compromisso {

    private final Dia dia;
    private final Turno turno;
    private String descricao;

    public Compromisso(Dia dia, Turno turno, String descricao) {
        this.dia = dia;
        this.turno = turno;
        this.descricao = descricao;
    }

    public Dia getDia() {
        return dia;
    }

    public Turno getTurno() {
        return turno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
