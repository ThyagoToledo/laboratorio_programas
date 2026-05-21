public class AreaRetangulo {
    
    /**
     * Calcula a área de um retângulo
     * @param largura largura do retângulo
     * @param altura altura do retângulo
     * @return área do retângulo
     */
    public static double calcularArea(double largura, double altura) {
        return largura * altura;
    }
    
    public static void main(String[] args) {
        double largura = 5.0;
        double altura = 3.0;
        double area = calcularArea(largura, altura);
        
        System.out.println("=== CÁLCULO DE ÁREA DO RETÂNGULO ===");
        System.out.println("Largura: " + largura);
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + area);
    }
}
