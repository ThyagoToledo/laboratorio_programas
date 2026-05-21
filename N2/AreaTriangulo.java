public class AreaTriangulo {
    
    /**
     * Calcula a área de um triângulo
     * @param base base do triângulo
     * @param altura altura do triângulo
     * @return área do triângulo
     */
    public static double calcularArea(double base, double altura) {
        return (base * altura) / 2.0;
    }
    
    public static void main(String[] args) {
        double base = 6.0;
        double altura = 4.0;
        double area = calcularArea(base, altura);
        
        System.out.println("=== CÁLCULO DE ÁREA DO TRIÂNGULO ===");
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + area);
    }
}
