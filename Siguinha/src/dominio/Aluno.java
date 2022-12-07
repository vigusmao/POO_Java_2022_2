package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Aluno extends Pessoa {

    private static Calendar calendar = Calendar.getInstance();

    private final long dre;
    private float cra;
    private int creditos;

    private List<ItemHistorico> historico;

    public Aluno(String nome, long cpf, long dre) {
        super(nome, cpf);
        this.dre = dre;
        this.historico = new ArrayList<>();
    }

    public long getDre() {
        return dre;
    }

    public float getCra() {
        return cra;
    }

    public void lancarDisciplinaCursada(
            Disciplina disciplina, float mediaFinal) {

        ItemHistorico novoItem = new ItemHistorico(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) <= 6 ? 1 : 2,
                disciplina, mediaFinal);

        historico.add(novoItem);

        if (mediaFinal >= disciplina.getTipo().getNotaMinimaAprovacao()) {
            // aprovado!

            int novosCreditos = disciplina.getCreditos();

            float somaPonderada =
                    this.cra * this.creditos +
                    mediaFinal * novosCreditos;

            this.creditos += novosCreditos;
            this.cra = somaPonderada / this.creditos;
        }
    }

    @Override
    public String toString() {
        return "dominio.Aluno{" +
                "nome='" + nome + '\'' +
                ", dre=" + dre +
                ", cra=" + cra +
                '}';
    }

    private class ItemHistorico {
        int ano;
        int semestre;
        Disciplina disciplina;
        float mediaFinal;

        public ItemHistorico(int ano,
                             int semestre,
                             Disciplina disciplina,
                             float mediaFinal) {
            this.ano = ano;
            this.semestre = semestre;
            this.disciplina = disciplina;
            this.mediaFinal = mediaFinal;
        }
    }
}
