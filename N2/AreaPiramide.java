public class AreaPiramide {
    
    /**
     * Calcula a área de uma pirâmide quadrangular
     * @param aresta aresta da base da pirâmide
     * @param altura altura da pirâmide
     * @return área total da pirâmide
     */
    public static double calcularArea(double aresta, double altura) {
        // Área da base
        double areaBase = aresta * aresta;
        
        // Apótema lateral (altura da face triangular)
        double apotemaSemiBase = aresta / 2.0;
        double apotemLateral = Math.sqrt(altura * altura + apotemaSemiBase * apotemaSemiBase);
        
        // Área das 4 faces triangulares
        double areaLaterais = 4 * (aresta * apotemLateral / 2.0);
        
        // Área total
        return areaBase + areaLaterais;
    }
    
    public static void main(String[] args) {
        double aresta = 4.0;
        double altura = 6.0;
        double area = calcularArea(aresta, altura);
        
        System.out.println("=== CÁLCULO DE ÁREA DA PIRÂMIDE ===");
        System.out.println("Aresta da Base: " + aresta);
        System.out.println("Altura: " + altura);
        System.out.println("Área Total: " + area);
    }
}
