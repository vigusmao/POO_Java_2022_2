import java.util.*;

public class AritmeticaBasica {

    private static List<Integer> primos = null;

    /**
     *
     * @param x um inteiro positivo
     * @param y um inteiro positivo
     * @return o mdc
     */
    public static int calcularMaximoDivisorComum(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new RuntimeException("Os parâmetros precisam ser positivos.");
        }

        int resto = x % y;
        while (resto != 0) {
            x = y;
            y = resto;
            resto = x % y;
        }
        return y;
    }

    /**
     *
     * @param x um inteiro não-negativo
     * @param y um inteiro não-negativo
     * @return o mmc
     */
    public static int calcularMMC(int x, int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("Os parâmetros precisam ser não-negativos.");
        }
        if (x == 0 || y == 0) {
            return 0;
        }
        return x * y / calcularMaximoDivisorComum(x, y);
    }

    /**
     *
     * @param x um inteiro não-negativo
     * @param y um inteiro não-negativo
     * @return o mmc
     */
    public static int calcularMinimoMultiploComum(int x, int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("Os parâmetros precisam ser não-negativos.");
        }
        if (x == 0 || y == 0) {
            return 0;
        }

        Map<Integer, Integer> expoenteByFatorPrimoDeX = fatorar(x);
        Map<Integer, Integer> expoenteByFatorPrimoDeY = fatorar(y);

        int resultado = 1;

        // o MMC é o produto dos fatores comuns e não comuns dos dois números,
        // cada qual com o MAIOR expoente com o qual ele aparece

        Set<Integer> todosOsFatores = new HashSet<>();
        todosOsFatores.addAll(expoenteByFatorPrimoDeX.keySet());
        todosOsFatores.addAll(expoenteByFatorPrimoDeY.keySet());
        for (int fator : todosOsFatores) {
            int expoente = Math.max(
                    expoenteByFatorPrimoDeX.getOrDefault(fator, 0),
                    expoenteByFatorPrimoDeY.getOrDefault(fator, 0));
            resultado *= Math.pow(fator, expoente);
        }

        return resultado;
    }

    public static Map<Integer, Integer> fatorar(int x) {

        verificarListaPrimos(x);

        Map<Integer, Integer> expoenteByFatorPrimo = new HashMap<>();

        int indicePrimo = 0;
        int primo = 2;

        while (primo <= x) {
            if (x % primo == 0) {
                x /= primo;  // divido o número pelo fator encontrado
                int expoenteExistente = expoenteByFatorPrimo.getOrDefault(primo, 0);
                expoenteByFatorPrimo.put(primo, expoenteExistente + 1);

                if (x == 1) {
                    break;
                }

            } else {
               indicePrimo++;
               primo = primos.get(indicePrimo);
            }
        }

        return expoenteByFatorPrimo;
    }

    public static String obterFatoracaoAsString(int x) {
        Map<Integer, Integer> expoenteByFator = fatorar(x);

        List<Integer> fatores = new ArrayList<>();
        fatores.addAll(expoenteByFator.keySet());
        Collections.sort(fatores);

        StringBuilder sb = new StringBuilder();

        for (int fator : fatores) {
            int expoente = expoenteByFator.get(fator);
            sb.append(fator);
            if (expoente != 1) {
                sb.append("^").append(expoente);
            }
            sb.append(" . ");
        }

        String resultado = sb.substring(0, sb.length() - 3);

        return resultado;
    }

    public static List<Integer> obterPrimos(int limite) {
        verificarListaPrimos(limite);
        return primos;
    }

    private static void verificarListaPrimos(int limite) {
        if (primos == null) {  // lazy instantiation
            primos = new ArrayList<>();
        }

        primos.clear();  // ToDo OPTIMIZE ME!!!! (não precisa recriar tudo!)

        boolean[] candidatos = new boolean[limite + 1];  // true := não é primo; false (primo, ou não olhei ainda)

        int primo = 3;

        while (primo <= Math.sqrt(limite)) {
            for (int i = primo * 2; i <= limite; i += primo) {
                candidatos[i] = true;  // risca do crivo de Eratóstenes
            }

            // pega o próximo primo, isto é, o próximo "não-riscado" no crivo
            primo++;
            while(candidatos[primo]) {
                primo++;  // encontrei o próximo "não-riscado"
            }
        }

        primos.add(2);  // adiciona o único primo par
        for (int i = 3; i <= limite; i += 2) {  // itera pelos ímpares para ver quem é primo
            if (!candidatos[i]) {
                primos.add(i);
            }
        }
    }

    public static boolean extrairSinal(double numero) {
        return numero >= 0;
    }
}
