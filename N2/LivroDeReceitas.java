import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroDeReceitas {
    
    private static class Ingrediente {
        String descricao;
        String quantidade;
        
        Ingrediente(String descricao, String quantidade) {
            this.descricao = descricao;
            this.quantidade = quantidade;
        }
    }
    
    private String nomeReceita;
    private List<Ingrediente> ingredientes;
    private List<String> instrucoes;
    
    public LivroDeReceitas() {
        this.ingredientes = new ArrayList<>();
        this.instrucoes = new ArrayList<>();
    }
    
    /**
     * Coleta o nome da receita
     */
    public void coletarNomeReceita(Scanner scanner) {
        System.out.print("Digite o nome da receita: ");
        this.nomeReceita = scanner.nextLine().trim();
    }
    
    /**
     * Coleta os ingredientes um a um
     */
    public void coletarIngredientes(Scanner scanner) {
        System.out.println("\nDigite os ingredientes (deixe descrição em branco para finalizar):");
        
        while (true) {
            System.out.print("Descrição do ingrediente: ");
            String descricao = scanner.nextLine().trim();
            
            if (descricao.isEmpty()) {
                break;
            }
            
            System.out.print("Quantidade: ");
            String quantidade = scanner.nextLine().trim();
            
            ingredientes.add(new Ingrediente(descricao, quantidade));
        }
    }
    
    /**
     * Coleta as instruções passo-a-passo
     */
    public void coletarInstrucoes(Scanner scanner) {
        System.out.println("\nDigite as instruções (deixe em branco para finalizar):");
        
        int passo = 1;
        while (true) {
            System.out.print("Passo " + passo + ": ");
            String instrucao = scanner.nextLine().trim();
            
            if (instrucao.isEmpty()) {
                break;
            }
            
            instrucoes.add(instrucao);
            passo++;
        }
    }
    
    /**
     * Salva a receita em um arquivo
     */
    public void salvarReceita() {
        String nomeArquivo = nomeReceita.replaceAll("\\s+", "_") + ".txt";
        
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            // Nome da receita
            writer.write(nomeReceita + "\n\n");
            
            // Ingredientes
            if (!ingredientes.isEmpty()) {
                for (int i = 0; i < ingredientes.size(); i++) {
                    Ingrediente ing = ingredientes.get(i);
                    writer.write((i + 1) + ". " + ing.descricao + " - " + ing.quantidade + "\n");
                }
                writer.write("\n");
            }
            
            // Instruções
            if (!instrucoes.isEmpty()) {
                for (int i = 0; i < instrucoes.size(); i++) {
                    writer.write("Passo " + (i + 1) + ": " + instrucoes.get(i) + "\n");
                }
            }
            
            System.out.println("\n✓ Receita salva em: " + nomeArquivo);
            
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
    
    /**
     * Exibe a receita no console
     */
    public void exibir() {
        System.out.println("\n=== " + nomeReceita + " ===\n");
        
        System.out.println("INGREDIENTES:");
        for (int i = 0; i < ingredientes.size(); i++) {
            Ingrediente ing = ingredientes.get(i);
            System.out.println((i + 1) + ". " + ing.descricao + " - " + ing.quantidade);
        }
        
        System.out.println("\nINSTRUÇÕES:");
        for (int i = 0; i < instrucoes.size(); i++) {
            System.out.println("Passo " + (i + 1) + ": " + instrucoes.get(i));
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroDeReceitas livro = new LivroDeReceitas();
        
        System.out.println("=== LIVRO DE RECEITAS ===");
        
        livro.coletarNomeReceita(scanner);
        livro.coletarIngredientes(scanner);
        livro.coletarInstrucoes(scanner);
        
        livro.exibir();
        livro.salvarReceita();
        
        System.out.println("\n✓ Ficar feliz!");
        
        scanner.close();
    }
}
