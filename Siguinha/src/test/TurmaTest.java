package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurmaTest {

    Turma minhaTurma;

    @Before
    public void setUp() {
        minhaTurma = new Turma();
    }

    @Test
    public void testarIncluirAluno() {
        Aluno cadu = new Aluno(111, "Cadu");
        minhaTurma.incluirAluno(cadu);
        Assert.assertEquals(1, minhaTurma.getContAlunos());

        Aluno eduarda = new Aluno(222, "Eduarda");
        minhaTurma.incluirAluno(eduarda);
        Assert.assertEquals(2, minhaTurma.getContAlunos());
    }

    @Test
    public void testarIncluirOMesmoAlunoRepetidamente() {
        Aluno cadu = new Aluno(111, "Cadu");
        minhaTurma.incluirAluno(cadu);
        minhaTurma.incluirAluno(cadu);
        minhaTurma.incluirAluno(cadu);
        minhaTurma.incluirAluno(cadu);
        minhaTurma.incluirAluno(cadu);
        minhaTurma.incluirAluno(cadu);
        Assert.assertEquals(1, minhaTurma.getContAlunos());
    }

}