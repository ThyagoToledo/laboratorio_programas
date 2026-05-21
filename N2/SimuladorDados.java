import java.util.Scanner;

/**
 * Simulador de dados que gera números aleatórios de 1 a 6.
 * Permite lançar um ou múltiplos dados com visualização gráfica.
 */
public class SimuladorDados {

    private static final String[] FACE_DADOS = {
            " -----\n|     |\n|  •  |\n|     |\n -----", // 1
            " -----\n|  •  |\n|     |\n|  •  |\n -----", // 2
            " -----\n|  •  |\n|  •  |\n|  •  |\n -----", // 3
            " -----\n| • • |\n|     |\n| • • |\n -----", // 4
            " -----\n| • • |\n|  •  |\n| • • |\n -----", // 5
            " -----\n| • • |\n| • • |\n| • • |\n -----" // 6
    };

    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 6;
    private static final int QUANTIDADE_PADRAO = 1;

    /**
     * Simula o lançamento de um único dado.
     *
     * @return número aleatório entre 1 e 6
     */
    private static int lancarDado() {
        return (int) (Math.random() * VALOR_MAXIMO) + VALOR_MINIMO;
    }

    /**
     * Exibe a visualização do dado correspondente ao número.
     *
     * @param numero número do dado (1-6)
     * @throws IllegalArgumentException se número não estiver entre 1 e 6
     */
    private static void exibirDado(int numero) {
        validarNumero(numero);
        System.out.println(FACE_DADOS[numero - VALOR_MINIMO]);
    }

    private static void validarNumero(int numero) {
        if (numero < VALOR_MINIMO || numero > VALOR_MAXIMO) {
            throw new IllegalArgumentException("Número deve estar entre 1 e 6");
        }
    }

    /**
     * Simula múltiplos lançamentos de dados e exibe resultados.
     *
     * @param quantidade quantidade de dados a lançar (deve ser positiva)
     * @throws IllegalArgumentException se quantidade for menor ou igual a zero
     */
    private static void executarSimulacao(int quantidade) {
        validarQuantidade(quantidade);
        exibirCabecalho(quantidade);

        int soma = 0;
        for (int i = VALOR_MINIMO; i <= quantidade; i++) {
            int resultado = lancarDado();
            soma += resultado;
            exibirResultado(i, resultado);
        }

        exibirSoma(soma);
    }

    private static void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
    }

    private static void exibirCabecalho(int quantidade) {
        System.out.println("\n=== SIMULADOR DE DADOS ===");
        System.out.printf("Lançando %d dado(s)...%n%n", quantidade);
    }

    private static void exibirResultado(int indiceDado, int valor) {
        System.out.printf("Dado %d - Resultado: %d%n", indiceDado, valor);
        exibirDado(valor);
        System.out.println();
    }

    private static void exibirSoma(int soma) {
        System.out.printf("Soma total: %d%n", soma);
    }

    /**
     * Coleta entrada do usuário com validação.
     *
     * @param scanner leitor de entrada
     * @return quantidade de dados a lançar
     */
    private static int coletarQuantidadeComValidacao(Scanner scanner) {
        System.out.print("Quantos dados deseja lançar? (deixe em branco para 1): ");
        String entrada = scanner.nextLine().trim();

        if (entrada.isEmpty()) {
            return QUANTIDADE_PADRAO;
        }

        try {
            int quantidade = Integer.parseInt(entrada);
            validarQuantidade(quantidade);
            return quantidade;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada deve ser um número inteiro válido");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            exibirTitulo();
            int quantidade = coletarQuantidadeComValidacao(scanner);
            executarSimulacao(quantidade);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void exibirTitulo() {
        System.out.println("=== SIMULADOR DE DADOS ===");
    }
}
