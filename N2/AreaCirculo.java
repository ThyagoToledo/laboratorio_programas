/**
 * Calcula a área de figuras geométricas do tipo círculo.
 * Implementa o cálculo: π × raio²
 */
public class AreaCirculo {

    private static final double RAIO_PADRAO = 5.0;

    /**
     * Calcula a área de um círculo.
     *
     * @param raio raio do círculo (deve ser positivo)
     * @return área do círculo
     * @throws IllegalArgumentException se raio for menor ou igual a zero
     */
    public static double calcularArea(double raio) {
        validarRaio(raio);
        return Math.PI * raio * raio;
    }

    private static void validarRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("Raio deve ser maior que zero");
        }
    }

    public static void main(String[] args) {
        exibirCalculo(RAIO_PADRAO);
    }

    private static void exibirCalculo(double raio) {
        double area = calcularArea(raio);
        System.out.println("=== CÁLCULO DE ÁREA DO CÍRCULO ===");
        System.out.printf("Raio: %.2f%n", raio);
        System.out.printf("Área: %.2f%n", area);
    }
}
