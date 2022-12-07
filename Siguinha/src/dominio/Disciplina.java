package dominio;

public class Disciplina {

    private String codigo;
    private TipoDisciplina tipo;
    private String nome;
    private int creditos;

    public Disciplina(String nome, TipoDisciplina tipo, String codigo, int creditos) {
        this.nome = nome;
        this.tipo = tipo;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public int getCreditos() {
        return creditos;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }
}
