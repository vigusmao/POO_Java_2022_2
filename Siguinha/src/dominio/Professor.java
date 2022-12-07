package dominio;

public class Professor extends Pessoa {

    private final long matricula;
    private Departamento departamento;

    public Professor(String nome,
                     long cpf,
                     long matricula,
                     Departamento departamento) {
        super(nome, cpf);
        this.matricula = matricula;
        this.departamento = departamento;
    }
}
