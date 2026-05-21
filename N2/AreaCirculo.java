public class AreaCirculo {
    
    /**
     * Calcula a área de um círculo
     * @param raio raio do círculo
     * @return área do círculo
     */
    public static double calcularArea(double raio) {
        return Math.PI * raio * raio;
    }
    
    public static void main(String[] args) {
        double raio = 5.0;
        double area = calcularArea(raio);
        
        System.out.println("=== CÁLCULO DE ÁREA DO CÍRCULO ===");
        System.out.println("Raio: " + raio);
        System.out.println("Área: " + area);
    }
}
