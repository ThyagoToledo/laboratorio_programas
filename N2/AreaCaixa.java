public class AreaCaixa {
    
    /**
     * Calcula a área de uma caixa (superfície total)
     * @param comprimento comprimento da caixa
     * @param largura largura da caixa
     * @param altura altura da caixa
     * @return área total da caixa
     */
    public static double calcularArea(double comprimento, double largura, double altura) {
        // Área = 2(ab + ac + bc)
        return 2 * (comprimento * largura + comprimento * altura + largura * altura);
    }
    
    public static void main(String[] args) {
        double comprimento = 5.0;
        double largura = 3.0;
        double altura = 4.0;
        double area = calcularArea(comprimento, largura, altura);
        
        System.out.println("=== CÁLCULO DE ÁREA DA CAIXA ===");
        System.out.println("Comprimento: " + comprimento);
        System.out.println("Largura: " + largura);
        System.out.println("Altura: " + altura);
        System.out.println("Área Total: " + area);
    }
}
