public class AreaBola {
    
    /**
     * Calcula a área de uma bola (esfera)
     * @param raio raio da bola
     * @return área total da bola
     */
    public static double calcularArea(double raio) {
        // Área = 4πr²
        return 4 * Math.PI * raio * raio;
    }
    
    public static void main(String[] args) {
        double raio = 5.0;
        double area = calcularArea(raio);
        
        System.out.println("=== CÁLCULO DE ÁREA DA BOLA (ESFERA) ===");
        System.out.println("Raio: " + raio);
        System.out.println("Área Total: " + area);
    }
}
