/**
 * Calcula a área de figuras geométricas do tipo retângulo.
 * Implementa o cálculo simples: largura × altura
 */
public class AreaRetangulo {

    private static final double LARGURA_PADRAO = 5.0;
    private static final double ALTURA_PADRAO = 3.0;

    /**
     * Calcula a área de um retângulo.
     *
     * @param largura largura do retângulo (deve ser positiva)
     * @param altura  altura do retângulo (deve ser positiva)
     * @return área do retângulo
     * @throws IllegalArgumentException se largura ou altura forem menores ou iguais
     *                                  a zero
     */
    public static double calcularArea(double largura, double altura) {
        validarDimensoes(largura, altura);
        return largura * altura;
    }

    private static void validarDimensoes(double largura, double altura) {
        if (largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Largura e altura devem ser maiores que zero");
        }
    }

    public static void main(String[] args) {
        exibirCalculo(LARGURA_PADRAO, ALTURA_PADRAO);
    }

    private static void exibirCalculo(double largura, double altura) {
        double area = calcularArea(largura, altura);
        System.out.println("=== CÁLCULO DE ÁREA DO RETÂNGULO ===");
        System.out.printf("Largura: %.2f%n", largura);
        System.out.printf("Altura: %.2f%n", altura);
        System.out.printf("Área: %.2f%n", area);
    }
}
