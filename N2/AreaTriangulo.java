/**
 * Calcula a área de figuras geométricas do tipo triângulo.
 * Implementa o cálculo: (base × altura) / 2
 */
public class AreaTriangulo {

    private static final double BASE_PADRAO = 6.0;
    private static final double ALTURA_PADRAO = 4.0;
    private static final double DIVISOR = 2.0;

    /**
     * Calcula a área de um triângulo.
     *
     * @param base   base do triângulo (deve ser positiva)
     * @param altura altura do triângulo (deve ser positiva)
     * @return área do triângulo
     * @throws IllegalArgumentException se base ou altura forem menores ou iguais a
     *                                  zero
     */
    public static double calcularArea(double base, double altura) {
        validarDimensoes(base, altura);
        return (base * altura) / DIVISOR;
    }

    private static void validarDimensoes(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser maiores que zero");
        }
    }

    public static void main(String[] args) {
        exibirCalculo(BASE_PADRAO, ALTURA_PADRAO);
    }

    private static void exibirCalculo(double base, double altura) {
        double area = calcularArea(base, altura);
        System.out.println("=== CÁLCULO DE ÁREA DO TRIÂNGULO ===");
        System.out.printf("Base: %.2f%n", base);
        System.out.printf("Altura: %.2f%n", altura);
        System.out.printf("Área: %.2f%n", area);
    }
}
