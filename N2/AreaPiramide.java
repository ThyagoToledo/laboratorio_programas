/**
 * Calcula a área de figuras geométricas tridimensionais do tipo pirâmide quadrangular.
 * Implementa o cálculo considerando a base quadrada e 4 faces triangulares.
 */
public class AreaPiramide {

    private static final double ARESTA_PADRAO = 4.0;
    private static final double ALTURA_PADRAO = 6.0;
    private static final int NUMERO_FACES = 4;
    private static final double DIVISOR_APOTEMA = 2.0;

    /**
     * Calcula a área total de uma pirâmide quadrangular.
     *
     * @param aresta aresta da base da pirâmide (deve ser positiva)
     * @param altura altura da pirâmide (deve ser positiva)
     * @return área total da pirâmide
     * @throws IllegalArgumentException se aresta ou altura forem menores ou iguais a zero
     */
    public static double calcularArea(double aresta, double altura) {
        validarDimensoes(aresta, altura);
        double areaBase = calcularAreaBase(aresta);
        double areaLaterais = calcularAreaLaterais(aresta, altura);
        return areaBase + areaLaterais;
    }

    private static void validarDimensoes(double aresta, double altura) {
        if (aresta <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Aresta e altura devem ser maiores que zero");
        }
    }

    private static double calcularAreaBase(double aresta) {
        return aresta * aresta;
    }

    private static double calcularAreaLaterais(double aresta, double altura) {
        double semiAresta = aresta / DIVISOR_APOTEMA;
        double apotemLateral = Math.sqrt(altura * altura + semiAresta * semiAresta);
        return NUMERO_FACES * (aresta * apotemLateral / DIVISOR_APOTEMA);
    }

    public static void main(String[] args) {
        exibirCalculo(ARESTA_PADRAO, ALTURA_PADRAO);
    }

    private static void exibirCalculo(double aresta, double altura) {
        double area = calcularArea(aresta, altura);
        System.out.println("=== CÁLCULO DE ÁREA DA PIRÂMIDE ===");
        System.out.printf("Aresta da Base: %.2f%n", aresta);
        System.out.printf("Altura: %.2f%n", altura);
        System.out.printf("Área Total: %.2f%n", area);
    }
}
