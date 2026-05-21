public class AreaTubo {
    
    /**
     * Calcula a área de um tubo (cilindro)
     * @param raio raio do tubo
     * @param altura altura do tubo
     * @return área total do tubo
     */
    public static double calcularArea(double raio, double altura) {
        // Área = 2πr² + 2πrh (duas bases + área lateral)
        return 2 * Math.PI * raio * raio + 2 * Math.PI * raio * altura;
    }
    
    public static void main(String[] args) {
        double raio = 3.0;
        double altura = 8.0;
        double area = calcularArea(raio, altura);
        
        System.out.println("=== CÁLCULO DE ÁREA DO TUBO (CILINDRO) ===");
        System.out.println("Raio: " + raio);
        System.out.println("Altura: " + altura);
        System.out.println("Área Total: " + area);
    }
}
