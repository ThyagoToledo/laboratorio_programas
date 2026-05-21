/**
 * Calcula a área de figuras geométricas tridimensionais do tipo tubo (cilindro).
 * Implementa o cálculo: 2πr² + 2πrh (duas bases + área lateral)
 */
public class AreaTubo {

    private static final double RAIO_PADRAO = 3.0;
    private static final double ALTURA_PADRAO = 8.0;
    private static final int MULTIPLICADOR = 2;

    /**
     * Calcula a área total de um cilindro/tubo.
     *
     * @param raio   raio do cilindro (deve ser positivo)
     * @param altura altura do cilindro (deve ser positiva)
     * @return área total do cilindro
     * @throws IllegalArgumentException se raio ou altura forem menores ou iguais a zero
     */
    public static double calcularArea(double raio, double altura) {
        validarDimensoes(raio, altura);
        double areaBase = MULTIPLICADOR * Math.PI * raio * raio;
        double areaLateral = MULTIPLICADOR * Math.PI * raio * altura;
        return areaBase + areaLateral;
    }

    private static void validarDimensoes(double raio, double altura) {
        if (raio <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Raio e altura devem ser maiores que zero");
        }
    }

    public static void main(String[] args) {
        exibirCalculo(RAIO_PADRAO, ALTURA_PADRAO);
    }

    private static void exibirCalculo(double raio, double altura) {
        double area = calcularArea(raio, altura);
        System.out.println("=== CÁLCULO DE ÁREA DO TUBO (CILINDRO) ===");
        System.out.printf("Raio: %.2f%n", raio);
        System.out.printf("Altura: %.2f%n", altura);
        System.out.printf("Área Total: %.2f%n", area);
    }
}
