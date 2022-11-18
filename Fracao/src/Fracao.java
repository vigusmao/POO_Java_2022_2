import org.junit.Test;

import java.util.Objects;

public class Fracao {

    private int numerador;
    private int denominador;
    private boolean sinal;

    /**
     * Cria uma fração. O sinal da fração será inferido a partir dos sinais
     * do numerador e denominador.
     *
     * Obs.: Caso a fração seja igual a zero, o denominador será sempre
     *       armazenado como 1.
     *
     * @param numerador um inteiro qualquer
     * @param denominador um inteiro diferente de zero
     */
    public Fracao(int numerador, int denominador) {
        this(Math.abs(numerador),
                Math.abs(denominador),
                numerador * denominador >= 0);
    }

    /**
     * Cria uma fração. O sinal da fração é informado explicitamente.
     *
     * Obs.: Caso a fração seja igual a zero, o denominador será sempre
     *       armazenado como 1.
     *
     * @param numerador um inteiro qualquer não-negativo
     * @param denominador um inteiro positivo
     * @param sinal true, se positiva (ou zero); false, se negativa
     *
     * @throws IllegalArgumentException para numeradores ou denominadores inválidos
     */
    public Fracao(int numerador, int denominador, boolean sinal) {
        if (numerador < 0) {
            throw new IllegalArgumentException("O numerador precisa ser não-negativo");
        }
        if (denominador <= 0) {
            throw new IllegalArgumentException("O denominador precisa ser positivo");
        }

        this.numerador = numerador;
        this.denominador = numerador == 0 ? 1 : denominador;
        this.sinal = numerador == 0 || sinal;
    }

    /**
     * Retorna o (valor absoluto do) numerador da fração
     *
     * @return um inteiro não-negativo
     */
    public int getNumerador() {
        return numerador;  // ToDo IMPLEMENT ME!
    }

    /**
     * Retorna o (valor absoluto do) denominador da fração
     *
     * @return um inteiro positivo
     */
    public int getDenominador() {
        return denominador;  // ToDo IMPLEMENT ME!
    }

    /**
     * Retorna um boolean indicando o sinal da fração
     *
     * @return true, se a fração for não-negativa; false, se for negativa
     */
    public boolean getSinal() {
        return sinal;  // ToDo IMPLEMENT ME!
    }

    public double getValorNumerico() {
        double valor = numerador / (double) denominador;
        if (!sinal) {
            valor *= -1;
        }
        return valor;
    }

    /**
     * Retorna uma Fracao que seja equivalente à fração original e irredutível
     * (numerador e denominador primos entre si).
     *
     * @return um outro objeto Fracao, caso esta fracao não seja irredutível;
     *         ou esta própria fração (this), caso ela própria já seja irredutível
     */
    public Fracao getFracaoIrredutivel() {

        if (numerador == 0) {
            return this;
        }

        int mdc = AritmeticaBasica.calcularMaximoDivisorComum(
                numerador, denominador);

        Fracao fracaoIrredutivel = new Fracao(
                this.numerador / mdc,
                this.denominador / mdc,
                this.sinal);

        return fracaoIrredutivel;
    }

    /**
     * Efetua uma adição.
     *
     * @param outra o segundo operando da adição (o primeiro é esta própria fração)
     *
     * @return uma TERCEIRA fração, criada agora, com o resultado da operação
     */
    public Fracao somar(Fracao outra) {
        return null;  // ToDo IMPLEMENT ME!
    }

    public Fracao somar(int numero) {
        return null;  // ToDo IMPLEMENT ME!
    }

    /**
     * Efetua uma multiplicação.
     *
     * @param outra o segundo operando da multiplicação (o primeiro é esta própria fração)
     *
     * @return uma TERCEIRA fração, criada agora, com o resultado da operação
     */
    public Fracao multiplicar(Fracao outra) {
        return null;  // ToDo IMPLEMENT ME!
    }

    public Fracao multiplicar(int numero) {   // sobrecarga (overload) de método: tem o mesmo nome e assinatura diferente
        return null;  // ToDo IMPLEMENT ME!
    }

    /**
     * Modifica, possivelmente, o numerador e o denominador desta fração,
     * tornando-a irredutível (e equivalente à fração original)
     */
    public void simplificar() {
        if (this.numerador == 0) {
            return;  // não há o que simplificar aqui!
        }

        int mdc = AritmeticaBasica.calcularMaximoDivisorComum(
                this.numerador, this.denominador);

        this.numerador /= mdc;
        this.denominador /= mdc;
    }

    private String getSinalAsString() {
        return this.sinal ? "" : "-";
    }

    @Override
    public String toString() {
        if (denominador == 1 || numerador == 0) {
            return getSinalAsString() + numerador;
        }

        return String.format("%s%d/%d",
                getSinalAsString(),
                this.numerador,
                this.denominador);
    }

    public void copyFrom(Fracao outra) {
        this.numerador = outra.getNumerador();
        this.denominador = outra.getDenominador();
        this.sinal = outra.getSinal();
    }
}
