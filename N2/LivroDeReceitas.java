import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Aplicação interativa para criar e armazenar receitas em arquivo.
 * Permite adicionar ingredientes e instruções de forma estruturada.
 */
public class LivroDeReceitas {

    private static final String EXTENSAO_ARQUIVO = ".txt";
    private static final String SEPARADOR_PALAVRAS = "\\s+";
    private static final String SUBSTITUI_ESPACOS = "_";
    private static final int INDICE_PRIMEIRO = 1;

    /**
     * Classe interna para representar um ingrediente.
     */
    private static class Ingrediente {
        private final String descricao;
        private final String quantidade;

        Ingrediente(String descricao, String quantidade) {
            this.descricao = descricao;
            this.quantidade = quantidade;
        }

        String getDescricao() {
            return descricao;
        }

        String getQuantidade() {
            return quantidade;
        }
    }

    private String nomeReceita;
    private final List<Ingrediente> ingredientes;
    private final List<String> instrucoes;

    /**
     * Construtor que inicializa as listas.
     */
    public LivroDeReceitas() {
        this.ingredientes = new ArrayList<>();
        this.instrucoes = new ArrayList<>();
    }

    /**
     * Coleta o nome da receita do usuário.
     *
     * @param scanner leitor de entrada
     */
    public void coletarNomeReceita(Scanner scanner) {
        System.out.print("Digite o nome da receita: ");
        this.nomeReceita = scanner.nextLine().trim();
    }

    /**
     * Coleta os ingredientes um a um até que o usuário deixe em branco.
     *
     * @param scanner leitor de entrada
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
     * Coleta as instruções passo-a-passo até que o usuário deixe em branco.
     *
     * @param scanner leitor de entrada
     */
    public void coletarInstrucoes(Scanner scanner) {
        System.out.println("\nDigite as instruções (deixe em branco para finalizar):");

        int passo = INDICE_PRIMEIRO;
        while (true) {
            System.out.printf("Passo %d: ", passo);
            String instrucao = scanner.nextLine().trim();

            if (instrucao.isEmpty()) {
                break;
            }

            instrucoes.add(instrucao);
            passo++;
        }
    }

    /**
     * Salva a receita em um arquivo de texto.
     */
    public void salvarReceita() {
        String nomeArquivo = gerarNomeArquivo();

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            escreverNomeReceita(writer);
            escreverIngredientes(writer);
            escreverInstrucoes(writer);

            exibirMensagemSucesso(nomeArquivo);
        } catch (IOException e) {
            exibirErroAoSalvar(e);
        }
    }

    private String gerarNomeArquivo() {
        return nomeReceita.replaceAll(SEPARADOR_PALAVRAS, SUBSTITUI_ESPACOS) + EXTENSAO_ARQUIVO;
    }

    private void escreverNomeReceita(FileWriter writer) throws IOException {
        writer.write(nomeReceita + "\n\n");
    }

    private void escreverIngredientes(FileWriter writer) throws IOException {
        if (!ingredientes.isEmpty()) {
            for (int i = 0; i < ingredientes.size(); i++) {
                Ingrediente ing = ingredientes.get(i);
                writer.write(String.format("%d. %s - %s%n", i + INDICE_PRIMEIRO, ing.getDescricao(), ing.getQuantidade()));
            }
            writer.write("\n");
        }
    }

    private void escreverInstrucoes(FileWriter writer) throws IOException {
        if (!instrucoes.isEmpty()) {
            for (int i = 0; i < instrucoes.size(); i++) {
                writer.write(String.format("Passo %d: %s%n", i + INDICE_PRIMEIRO, instrucoes.get(i)));
            }
        }
    }

    private void exibirMensagemSucesso(String nomeArquivo) {
        System.out.println("\n✓ Receita salva em: " + nomeArquivo);
    }

    private void exibirErroAoSalvar(IOException e) {
        System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
    }

    /**
     * Exibe a receita formatada no console.
     */
    public void exibir() {
        System.out.printf("\n=== %s ===%n%n", nomeReceita);

        exibirIngredientes();
        exibirInstrucoes();
    }

    private void exibirIngredientes() {
        System.out.println("INGREDIENTES:");
        for (int i = 0; i < ingredientes.size(); i++) {
            Ingrediente ing = ingredientes.get(i);
            System.out.printf("%d. %s - %s%n", i + INDICE_PRIMEIRO, ing.getDescricao(), ing.getQuantidade());
        }
    }

    private void exibirInstrucoes() {
        System.out.println("\nINSTRUÇÕES:");
        for (int i = 0; i < instrucoes.size(); i++) {
            System.out.printf("Passo %d: %s%n", i + INDICE_PRIMEIRO, instrucoes.get(i));
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            exibirTitulo();
            LivroDeReceitas livro = new LivroDeReceitas();

            livro.coletarNomeReceita(scanner);
            livro.coletarIngredientes(scanner);
            livro.coletarInstrucoes(scanner);

            livro.exibir();
            livro.salvarReceita();

            exibirMensagemFinal();
        }
    }

    private static void exibirTitulo() {
        System.out.println("=== LIVRO DE RECEITAS ===");
    }

    private static void exibirMensagemFinal() {
        System.out.println("\n✓ Ficar feliz!");
    }
}
