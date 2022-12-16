package model;

import exception.DevolucaoInvalidaException;
import exception.LimiteEmprestimosExcedidoException;
import exception.UsuarioNaoCadastradoException;

import java.util.Map;
import java.util.*;

public class Biblioteca {

    public static final int MIN_COPIAS_PARA_PODER_EMPRESTAR = 2;
    public static final int MAX_LIVROS_DEVIDOS_POR_USUARIO = 3;

    private Map<Long, Pessoa> usuarioByCpf;  // mapa para guardar todos os usuários cadastrados (por cpf)

    private int totalLivrosNasEstantes;  // contador para o total de livros nas estantes da biblioteca

    public Biblioteca(){
        this.usuarioByCpf = new HashMap<>();
    }

    /**
     * Cadastra um novo usuário, caso não exista;
     * se já existir, atualiza seus dados, sobrescrevendo nome e endereço no objeto
     * que já existia com aquele CPF.
     *
     * @param usuario A Pessoa a ser cadastrada/atualizada como usuária desta biblioteca.
     */
    public void cadastrarUsuario(Pessoa usuario) {
        long cpf = usuario.getCpf();
        Pessoa usuarioExistente = this.usuarioByCpf.get(cpf);

        if (usuarioExistente == null) {
            // o usuário informado é novo; vamos cadastrá-lo
            // ToDo IMPLEMENT ME!!

        } else {
            // o usuário informado já existia; vamos atualizá-lo
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEndereco(usuario.getEndereco());
        }
    }

    public Pessoa getUsuario(long cpf){
        return null;  // ToDo IMPLEMENT ME!!
    }

    public int getTotalDeUsuariosCadastrados(){
        return 0;  // ToDo IMPLEMENT ME!!
    }

    /**
     * Efetua a aquisição de certo número de cópias de um livro.
     *
     * @param livro O livro que desejamos adquirir.
     * @param quantidade A quantidade desejada, que será adquirida e acrescentada à quantidade já existente
     *                   daquele livro na biblioteca (se o livro já existir na biblioteca)
     */
    public void adquirirLivro(Livro livro, int quantidade) {
        // ToDo IMPLEMENT ME!!
        // Dica: adicione um Map quantidadeByLivro como atributo de Biblioteca.
    }

    /**
     * Efetua o empréstimo de uma unidade do livro informado para o usuário informado, reduzindo em uma unidade
     * a quantidade daquele livro nas estantes da biblioteca.
     *
     * @param livro O livro que se deseja tomar emprestado
     * @param usuario O usuário que deseja pegar emprestado o livro
     *
     * @return true, se o empréstimo for bem sucedido; false, caso a biblioteca não tenha em suas estantes
     *         a quantidade mínima do livro desejado para que ele possa ser emprestado
     *         (vide model.Biblioteca.MIN_COPIAS_PARA_PODER_EMPRESTAR)
     *
     * @throws UsuarioNaoCadastradoException se o usuário não for cadastrado nesta biblioteca
     * @throws LimiteEmprestimosExcedidoException se o usuário já está ultrapassou o número máximo permitido de
     *                                            livros emprestados nesta biblioteca para cada usuário
     */
    public boolean emprestarLivro(Livro livro, Pessoa usuario)
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {
        return false;  // ToDo IMPLEMENT ME!!
    }

    /**
     * Recebe de volta um livro que estava emprestado.
     *
     * @param livro O livro que o usuário está devolvendo
     * @param usuario O usuário que devolve o livro
     *
     * @throws DevolucaoInvalidaException caso o livro em questão não exista
     *                                    ou o livro não esteja emprestado para o usuário informado
     */
    public void receberDevolucaoLivro(Livro livro, Pessoa usuario) throws DevolucaoInvalidaException {
        // ToDo IMPLEMENT ME!!
    }

    public int getQuantidadeDeLivrosDevidos(Pessoa usuario) {
        return 0;  // ToDo IMPLEMENT ME!!
    }

    public int getQuantidadeDeLivrosNasEstantes() {
        // ****** NÃO MODIFIQUE ESSE MÉTODO! ******
        return totalLivrosNasEstantes;
    }

    public int getQuantidadeDeLivrosNasEstantes(Livro livro) {
        return 0;  // ToDo IMPLEMENT ME!!
    }
}