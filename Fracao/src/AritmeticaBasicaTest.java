import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AritmeticaBasicaTest {

    @Test
    public void testarCalcularMaximoDivisorComum() {

        assertEquals(3, AritmeticaBasica.calcularMaximoDivisorComum(3, 9));
        assertEquals(5, AritmeticaBasica.calcularMaximoDivisorComum(40, 55));
        assertEquals(1, AritmeticaBasica.calcularMaximoDivisorComum(50, 21));
        assertEquals(1, AritmeticaBasica.calcularMaximoDivisorComum(5, 7));
        assertEquals(1, AritmeticaBasica.calcularMaximoDivisorComum(5, 1));
    }

    @Test
    public void testarCalcularMinimoMultiploComum() {

        assertEquals(9, AritmeticaBasica.calcularMMC(3, 9));
        assertEquals(200, AritmeticaBasica.calcularMMC(40, 50));
        assertEquals(0, AritmeticaBasica.calcularMMC(0, 55));

        assertEquals(9, AritmeticaBasica.calcularMinimoMultiploComum(3, 9));
        assertEquals(200, AritmeticaBasica.calcularMinimoMultiploComum(40, 50));
        assertEquals(0, AritmeticaBasica.calcularMinimoMultiploComum(0, 55));
    }

    @Test
    public void testarListaDePrimos() {

        List<Integer> listaDePrimos = AritmeticaBasica.obterPrimos(30);
        assertEquals(2, (int) listaDePrimos.get(0));
        assertEquals(3, (int) listaDePrimos.get(1));
        assertEquals(5, (int) listaDePrimos.get(2));
        assertEquals(7, (int) listaDePrimos.get(3));
        assertEquals(11, (int) listaDePrimos.get(4));
        assertEquals(13, (int) listaDePrimos.get(5));
        assertEquals(17, (int) listaDePrimos.get(6));
        assertEquals(19, (int) listaDePrimos.get(7));
        assertEquals(23, (int) listaDePrimos.get(8));
        assertEquals(29, (int) listaDePrimos.get(9));
    }

    @Test
    public void testarFatoracao() {
        Map<Integer ,Integer> fatores;

        fatores = AritmeticaBasica.fatorar(9);
        assertEquals(1, fatores.size());
        assertEquals(2, (int) fatores.get(3));
        assertEquals("3^2", AritmeticaBasica.obterFatoracaoAsString(9));

        fatores = AritmeticaBasica.fatorar(70);
        assertEquals(3, fatores.size());
        assertEquals(1, (int) fatores.get(2));
        assertEquals(1, (int) fatores.get(5));
        assertEquals(1, (int) fatores.get(7));
        assertEquals("2 . 5 . 7", AritmeticaBasica.obterFatoracaoAsString(70));

        fatores = AritmeticaBasica.fatorar(180);
        assertEquals(3, fatores.size());
        assertEquals(2, (int) fatores.get(2));
        assertEquals(2, (int) fatores.get(3));
        assertEquals(1, (int) fatores.get(5));
        assertEquals("2^2 . 3^2 . 5", AritmeticaBasica.obterFatoracaoAsString(180));

        fatores = AritmeticaBasica.fatorar(31);
        assertEquals(1, fatores.size());
        assertEquals(1, (int) fatores.get(31));
        assertEquals("31", AritmeticaBasica.obterFatoracaoAsString(31));
    }
}