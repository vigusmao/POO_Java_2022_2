package dominio;

import exception.AlunoInexistenteException;
import exception.AlunoJaExistenteException;

import java.util.HashMap;
import java.util.Map;

public class Turma {

    private final String codigo;
    private Professor prof;
    private Disciplina disciplina;

    private Map<Long, Aluno> alunoByDre;
    private Map<Long, Float> notaByDre;

    public Turma(String codigo,
                 Disciplina disciplina) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.alunoByDre = new HashMap<>();
    }

    public void incluirAluno(Aluno aluno) throws AlunoJaExistenteException {
        long dre = aluno.getDre();

        if (this.alunoByDre.containsKey(dre)) {
            throw new AlunoJaExistenteException();
        }

        this.alunoByDre.put(dre, aluno);
    }

    public float obterMediaTurma() {
        float soma = 0;
        for (Float nota : this.notaByDre.values()) {
            soma += nota;
        }
        return soma / this.notaByDre.size();
    }

    public int getContAlunos() {
        return alunoByDre.size();
    }

    public Aluno getAlunoComMaiorCra() {

        for (Aluno a : alunoByDre.values()) {
            System.out.println(a);

        }

        for (Long dre : alunoByDre.keySet()) {
            System.out.println(dre);
        }

        for (Map.Entry<Long, Aluno> parChaveValor : alunoByDre.entrySet()) {
            Long dre = parChaveValor.getKey();
            Aluno aluno = parChaveValor.getValue();

        }

        return null; // ToDO IMPLEMENT ME!
    }

    public void atribuirNotaFinal(long dre,
                                  float notaFinal) throws AlunoInexistenteException {

        Aluno aluno = this.alunoByDre.get(dre);

        if (aluno == null) {
            throw new AlunoInexistenteException();
        }

        aluno.lancarDisciplinaCursada(this.disciplina,
                notaFinal);

        this.notaByDre.put(dre, notaFinal);
    }
}
