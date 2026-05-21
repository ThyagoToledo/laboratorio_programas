import java.util.Scanner;

public class SimuladorDados {
    
    private static final String[] FACE_DADOS = {
        " -----\n|     |\n|  •  |\n|     |\n -----",  // 1
        " -----\n|  •  |\n|     |\n|  •  |\n -----",  // 2
        " -----\n|  •  |\n|  •  |\n|  •  |\n -----",  // 3
        " -----\n| • • |\n|     |\n| • • |\n -----",  // 4
        " -----\n| • • |\n|  •  |\n| • • |\n -----",  // 5
        " -----\n| • • |\n| • • |\n| • • |\n -----"   // 6
    };
    
    /**
     * Simula o lançamento de um dado
     * @return número de 1 a 6
     */
    public static int lancarDado() {
        return (int) (Math.random() * 6) + 1;
    }
    
    /**
     * Exibe o desenho do dado
     * @param numero número do dado (1-6)
     */
    public static void exibirDado(int numero) {
        System.out.println(FACE_DADOS[numero - 1]);
    }
    
    /**
     * Simula múltiplos lançamentos de dados
     * @param quantidade quantidade de dados a lançar
     */
    public static void lancarDados(int quantidade) {
        System.out.println("\n=== SIMULADOR DE DADOS ===");
        System.out.println("Lançando " + quantidade + " dado(s)...\n");
        
        int soma = 0;
        for (int i = 1; i <= quantidade; i++) {
            int resultado = lancarDado();
            soma += resultado;
            
            System.out.println("Dado " + i + " - Resultado: " + resultado);
            exibirDado(resultado);
            System.out.println();
        }
        
        System.out.println("Soma total: " + soma);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SIMULADOR DE DADOS ===");
        System.out.print("Quantos dados deseja lançar? (deixe em branco para 1): ");
        
        String entrada = scanner.nextLine().trim();
        int quantidade = entrada.isEmpty() ? 1 : Integer.parseInt(entrada);
        
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que 0!");
            scanner.close();
            return;
        }
        
        lancarDados(quantidade);
        
        scanner.close();
    }
}
