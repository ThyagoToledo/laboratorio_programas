/**
 * Calcula a área de figuras geométricas tridimensionais do tipo bola (esfera).
 * Implementa o cálculo: 4πr²
 */
public class AreaBola {

    private static final double RAIO_PADRAO = 5.0;
    private static final int MULTIPLICADOR = 4;

    /**
     * Calcula a área total de uma esfera/bola.
     *
     * @param raio raio da esfera (deve ser positivo)
     * @return área total da esfera
     * @throws IllegalArgumentException se raio for menor ou igual a zero
     */
    public static double calcularArea(double raio) {
        validarRaio(raio);
        return MULTIPLICADOR * Math.PI * raio * raio;
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
        System.out.println("=== CÁLCULO DE ÁREA DA BOLA (ESFERA) ===");
        System.out.printf("Raio: %.2f%n", raio);
        System.out.printf("Área Total: %.2f%n", area);
    }
}
