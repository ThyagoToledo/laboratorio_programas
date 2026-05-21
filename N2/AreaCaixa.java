/**
 * Calcula a área de figuras geométricas tridimensionais do tipo caixa (paralelepípedo).
 * Implementa o cálculo: 2(ab + ac + bc) onde a, b, c são as dimensões
 */
public class AreaCaixa {

    private static final double COMPRIMENTO_PADRAO = 5.0;
    private static final double LARGURA_PADRAO = 3.0;
    private static final double ALTURA_PADRAO = 4.0;
    private static final int MULTIPLICADOR = 2;

    /**
     * Calcula a área total de uma caixa (paralelepípedo).
     *
     * @param comprimento comprimento da caixa (deve ser positivo)
     * @param largura     largura da caixa (deve ser positiva)
     * @param altura      altura da caixa (deve ser positiva)
     * @return área total da caixa
     * @throws IllegalArgumentException se alguma dimensão for menor ou igual a zero
     */
    public static double calcularArea(double comprimento, double largura, double altura) {
        validarDimensoes(comprimento, largura, altura);
        return MULTIPLICADOR * (comprimento * largura + comprimento * altura + largura * altura);
    }

    private static void validarDimensoes(double comprimento, double largura, double altura) {
        if (comprimento <= 0 || largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Todas as dimensões devem ser maiores que zero");
        }
    }

    public static void main(String[] args) {
        exibirCalculo(COMPRIMENTO_PADRAO, LARGURA_PADRAO, ALTURA_PADRAO);
    }

    private static void exibirCalculo(double comprimento, double largura, double altura) {
        double area = calcularArea(comprimento, largura, altura);
        System.out.println("=== CÁLCULO DE ÁREA DA CAIXA ===");
        System.out.printf("Comprimento: %.2f%n", comprimento);
        System.out.printf("Largura: %.2f%n", largura);
        System.out.printf("Altura: %.2f%n", altura);
        System.out.printf("Área Total: %.2f%n", area);
    }
}
