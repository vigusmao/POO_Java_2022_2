package model;

public class Livro {

    public enum TipoDeLivro {
        LIVRO_DIDATICO,
        LIVRO_DE_FICCAO,
        LIVRO_DE_NAO_FICCAO,
        ENCICLOPEDIA
    }

    private final String titulo;
    private final Pessoa autor;
    private final int anoDePublicacao;
    private final TipoDeLivro tipo;

    public Livro(String titulo, Pessoa autor, int anoDePublicacao, TipoDeLivro tipo){
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public TipoDeLivro getTipo() {
        return tipo;
    }

    public String toString() {
        switch (this.tipo) {
            case LIVRO_DIDATICO:
                return String.format("Livro texto %s", this.titulo);
            case ENCICLOPEDIA:
                return String.format("Enciclopédia %s", this.titulo);
            case LIVRO_DE_FICCAO:
            case LIVRO_DE_NAO_FICCAO:
            default:
                return String.format("Livro %s, de %s (%d)", this.titulo, this.autor.getNome(), this.anoDePublicacao);
        }
    }

    @Override
    public int hashCode() {
        int result = titulo.hashCode();
        result = 31 * result + autor.hashCode();
        result = 31 * result + tipo.hashCode();
        return result;
    }
}