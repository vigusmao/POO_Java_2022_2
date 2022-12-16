package test;

import exception.DevolucaoInvalidaException;
import exception.LimiteEmprestimosExcedidoException;
import exception.UsuarioNaoCadastradoException;
import model.Biblioteca;
import model.Livro;
import model.Pessoa;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BibliotecaTest {

    private Biblioteca biblioteca;

    private long cpfUsuario1;
    private Pessoa usuario;

    private long cpfUsuarioFantasma;
    private Pessoa usuarioFantasma;

    private Livro livroRaro;
    private Livro livroAbundante;
    private Livro livroInexistente;

    private Pessoa algumAutor;

    @Before
    public void setUp() {
        cpfUsuario1 = 1111;
        usuario = new Pessoa("Fulano", cpfUsuario1);

        cpfUsuarioFantasma= 9876;
        usuarioFantasma = new Pessoa("Usuário Fantasma", cpfUsuarioFantasma);

        algumAutor = new Pessoa("Fulano de Tal", 1234);

        Pessoa outroAutor = new Pessoa("Outro Cara", 4567);
        Pessoa autorDesconhecido = new Pessoa("Nunca Visto", 171);

        livroRaro = new Livro("Algum Livro", algumAutor, 1900, Livro.TipoDeLivro.LIVRO_DE_FICCAO);
        livroAbundante = new Livro("Outro livro", outroAutor, 1980, Livro.TipoDeLivro.LIVRO_DE_FICCAO);
        livroInexistente = new Livro("Nunca Adquirido", autorDesconhecido, 2000, Livro.TipoDeLivro.LIVRO_DIDATICO);

        biblioteca = new Biblioteca();

        biblioteca.cadastrarUsuario(usuario);

        biblioteca.adquirirLivro(livroRaro, 1);  // a biblioteca terá 1 unidade do livro raro
        biblioteca.adquirirLivro(livroAbundante, 5);  // a bibliotecá terá 5 unidades do livro abundante
    }

    @Test
    public void testeAdquirirNovoLivro() {
        Livro novoLivro = new Livro("Enciclopédia recém-adquirida", algumAutor, 2018, Livro.TipoDeLivro.ENCICLOPEDIA);

        // vamos adquirir 10 unidades de um novo livro para a nossa biblioteca
        biblioteca.adquirirLivro(novoLivro, 10);
        assertEquals("A aquisição de um livro deve atualizar a quantidade daquele livro na estante",
                10, biblioteca.getQuantidadeDeLivrosNasEstantes(novoLivro));
        assertEquals("A aquisição de um livro deve atualizar a quantidade TOTAL de livros na estante",
                16, biblioteca.getQuantidadeDeLivrosNasEstantes());  // note que 6 livros já foram adquiridos no setUp()
    }

    @Test
    public void testeAdquirirZeroOuMenosCopiasDeLivro() {
        // vamos testar o que acontece quando tentamos adquirir zero ou menos cópias de um livro
        biblioteca.adquirirLivro(livroAbundante, 0);
        biblioteca.adquirirLivro(livroAbundante, -7);
        assertEquals("A aquisição de zero ou menos cópias de um livro NÃO deve modificar sua quantidade na estante",
                5, biblioteca.getQuantidadeDeLivrosNasEstantes(livroAbundante));
        assertEquals("A aquisição de zero ou menos cópias de um livro NÃO deve modificar o total de livros na estante",
                6, biblioteca.getQuantidadeDeLivrosNasEstantes());
    }

    @Test
    public void testeConsultarQuantidadeUsandoOutraInstancia() {
        // vamos criar uma outra instância (objeto) para representar um livro que já existe na biblioteca
        Livro outraInstanciaDeLivroQueJaExiste = new Livro(
                livroAbundante.getTitulo(), livroAbundante.getAutor(),
                livroAbundante.getAnoDePublicacao(), livroAbundante.getTipo());

        assertEquals("A consulta de quantidade deve retornar corretamente mesmo quando o parâmetro é outra instância",
                5, biblioteca.getQuantidadeDeLivrosNasEstantes(outraInstanciaDeLivroQueJaExiste));
    }

    @Test
    public void testeGetQuantidadeDeLivrosNaEstanteParaLivroInexistente() {
        assertEquals("A quantidade na estante de um livro inexistente deve ser retornada como zero",
                0, biblioteca.getQuantidadeDeLivrosNasEstantes(livroInexistente));
    }

    @Test
    public void testeChavePrimariaUsuario() {
        Pessoa novaInstanciaDoMesmoUsuario = new Pessoa("Qualquer Nome", cpfUsuario1);
        assertEquals("Dois usuários com o mesmo CPF devem ser considerados iguais",
                novaInstanciaDoMesmoUsuario, usuario);
    }

    @Test
    public void testeGetUsuario() {
        assertEquals("Um usuário cadastrado deve ser encontrável a partir de seu CPF",
                usuario, biblioteca.getUsuario(cpfUsuario1));
    }

    @Test
    public void testeCadastrarNovoUsuario() {
        long cpfUsuario2 = 2222L;
        Pessoa usuario2 = new Pessoa("Beltrano", cpfUsuario2);
        biblioteca.cadastrarUsuario(usuario2);
        assertEquals("O cadastro de um novo usuario deve atualizar o total de usuários cadastrados",
                2, biblioteca.getTotalDeUsuariosCadastrados());
    }

    @Test
    public void testeCadastrarUsuarioJaCadastrado() {
        String novoNome = "Fulano de Tal";
        String novoEndereco = "Novo endereco";
        Pessoa usuarioRepetido = new Pessoa(novoNome, cpfUsuario1);
        usuarioRepetido.setEndereco(novoEndereco);
        biblioteca.cadastrarUsuario(usuarioRepetido);
        assertEquals("O cadastro de um usuario já cadastrado anteriormente não deve atualizar o total de usuários",
                1, biblioteca.getTotalDeUsuariosCadastrados());
        Pessoa usuarioRetornadoPelaBiblioteca = biblioteca.getUsuario(cpfUsuario1);
        assertEquals("O cadastro de um usuário já cadastrado deve atualizar seu nome",
                novoNome, usuarioRetornadoPelaBiblioteca.getNome());
        assertEquals("O cadastro de um usuário já cadastrado deve atualizar seu endereço",
                novoEndereco, usuarioRetornadoPelaBiblioteca.getEndereco());
    }

    @Test
    public void testeEmprestarEDevolverLivro()
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException, DevolucaoInvalidaException {
        assertTrue("A biblioteca deve poder emprestar livros (que estejam disponíveis!) para usuários que não tenham" +
                " excedido o limite de empréstimos", biblioteca.emprestarLivro(livroAbundante, usuario));
        assertEquals("O empréstimo de um livro deve incrementar a quantidade de livros devidos por aquele usuário",
                1, biblioteca.getQuantidadeDeLivrosDevidos(usuario));
        assertEquals("O empréstimo de um livro deve atualizar a quantidade daquele livro na estante",
                4, biblioteca.getQuantidadeDeLivrosNasEstantes(livroAbundante));

        biblioteca.receberDevolucaoLivro(livroAbundante, usuario);
        assertEquals("A devolução de um livro deve diminuir em uma unidade a quantidade devida por aquele usuário",
                0, biblioteca.getQuantidadeDeLivrosDevidos(usuario));
        assertEquals("A devolução de um livro deve atualizar a quantidade daquele livro na estante",
                5, biblioteca.getQuantidadeDeLivrosNasEstantes(livroAbundante));
    }

    @Test
    public void testeEmprestarLivroIndisponivel()
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {
        assertFalse("A tentativa de emprestar um livro com menos de " +
                        Biblioteca.MIN_COPIAS_PARA_PODER_EMPRESTAR +
                        " cópias na estante deve retornar false, sem lançar exceções",
                biblioteca.emprestarLivro(livroRaro, usuario));
    }

    @Test
    public void testeEmprestarLivroInexistente()
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {
        assertFalse("A tentativa de emprestar um livro não presente no acervo deve retornar false, sem lançar exceções",
                biblioteca.emprestarLivro(livroInexistente, usuario));
    }

    @Test
    public void testeEmprestarLivroParaUsuarioNaoCadastrado()
            throws LimiteEmprestimosExcedidoException {
        try {
            biblioteca.emprestarLivro(livroAbundante, usuarioFantasma);
            fail("A tentativa de empréstimo para usuário não cadastrado deve lançar uma exception.UsuarioNaoCadastradoException");
        } catch (UsuarioNaoCadastradoException e) {
            // ok, teste passou
        }
    }

    @Test
    public void testeEmprestarLivroParaUsuarioComMuitosLivrosDevidos()
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {

        int copiasRequeridasParaOTeste = Biblioteca.MAX_LIVROS_DEVIDOS_POR_USUARIO + Biblioteca.MIN_COPIAS_PARA_PODER_EMPRESTAR;

        /* adquire novas cópias do livroAbundante, garantindo que haverá cópias suficientes (para este teste)
           nas estantes da biblioteca */
        biblioteca.adquirirLivro(livroAbundante,
                copiasRequeridasParaOTeste - biblioteca.getQuantidadeDeLivrosNasEstantes(livroAbundante));

        // vamos fazer nosso usuário pegar emprestado o máximo possível de livros
        for (int i = 0; i < Biblioteca.MAX_LIVROS_DEVIDOS_POR_USUARIO; i++) {
            biblioteca.emprestarLivro(livroAbundante, usuario);
        }

        // agora vamos tentar pegar emprestado ainda mais um livro -- não deve ser permitido!
        try {
            biblioteca.emprestarLivro(livroAbundante, usuario);
            fail("Um mesmo usuario nao pode pegar emprestado mais do que " +
                    Biblioteca.MAX_LIVROS_DEVIDOS_POR_USUARIO +
                    " livros -- uma exception.LimiteEmprestimosExcedidoException deve ser lançada nesse caso");
        } catch (LimiteEmprestimosExcedidoException e) {
            // ok, teste passou
        }
    }

    @Test
    public void testeDevolucaoLivroNaoEmprestado() {
        try {
            biblioteca.receberDevolucaoLivro(livroRaro, usuario);
            fail("A tentativa de devolver um livro que não foi emprestado (àquele usuário) deve " +
                    "resultar em uma exception.DevolucaoInvalidaException");
        } catch (DevolucaoInvalidaException e) {
            // ok, teste passou
        }
    }

    @Test
    public void testeGetQuantidadeDeLivrosDevidosPorUsuarioNaoCadastrado() {
        assertEquals("Usuários desconhecidos nunca estão devendo livros, e o método deve simplesmente retornar zero, " +
                "sem lançar exceção", 0, biblioteca.getQuantidadeDeLivrosDevidos(usuarioFantasma));
    }

    @Test
    public void testeLivrosEmprestadosDeDuasBibliotecas() {
        // vamos criar outra biblioteca, cadastrar nosso usuério e adquirir algumas cópias daquele mesmo livro abundante
        Biblioteca segundaBiblioteca = new Biblioteca();
        segundaBiblioteca.cadastrarUsuario(usuario);
        segundaBiblioteca.adquirirLivro(livroAbundante, 5);

        // vamos agora fazer nosso usuário pegar emprestado o máximo de livros que ele puder em cada biblioteca
        try {
            for (int i = 1; i <= Biblioteca.MAX_LIVROS_DEVIDOS_POR_USUARIO; i++) {
                assertTrue(biblioteca.emprestarLivro(livroAbundante, usuario));
                assertTrue(segundaBiblioteca.emprestarLivro(livroAbundante, usuario));
            }
        } catch (Exception e) {
            fail("Nenhuma exceção deve ocorrer pois o usuário está corretamente cadastrado nas duas bibliotecas " +
                    "e não excedeu o limite em nenhuma biblioteca");
        }
    }

    @Test
    public void testeCriacaoNovaBiblioteca() {
        Biblioteca novaBiblioteca = new Biblioteca();

        assertEquals("Uma biblioteca deve ser criada sem livros nas estantes", 0,
                novaBiblioteca.getQuantidadeDeLivrosNasEstantes());
        assertEquals("Uma biblioteca deve ser criada sem usuários cadastrados", 0,
                novaBiblioteca.getTotalDeUsuariosCadastrados());
    }
}