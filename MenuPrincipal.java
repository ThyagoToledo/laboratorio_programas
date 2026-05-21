import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu Principal interativo para executar todos os programas Java da pasta N2.
 * Permite selecionar e executar qualquer programa disponível.
 */
public class MenuPrincipal {

    private static final String PASTA_N2 = "N2";
    private static final String EXTENSAO_JAVA = ".java";
    private static final String EXTENSAO_CLASS = ".class";
    private static final String SEPARADOR = criarSeparador(60);
    private static final int OPCAO_SAIR = 0;

    private static List<String> programasDisponiveis;
    private static Scanner scanner;

    /**
     * Cria um separador de caracteres repetidos.
     */
    private static String criarSeparador(int tamanho) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append("=");
        }
        return sb.toString();
    }

    /**
     * Método principal que inicia a aplicação.
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        programasDisponiveis = new ArrayList<>();

        try {
            descobrirProgramas();
            exibirMenuPrincipal();
        } catch (IOException e) {
            exibirErro("Erro ao descobrir programas: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Descobre todos os arquivos Java na pasta N2.
     */
    private static void descobrirProgramas() throws IOException {
        File pastaN2 = new File(PASTA_N2);

        if (!pastaExiste(pastaN2)) {
            throw new IOException("Pasta N2 não encontrada no diretório atual");
        }

        File[] arquivos = pastaN2.listFiles((dir, name) -> name.endsWith(EXTENSAO_CLASS) && !name.contains("$"));

        if (arquivos == null || arquivos.length == 0) {
            throw new IOException("Nenhum arquivo compilado encontrado em N2");
        }

        for (File arquivo : arquivos) {
            String nomeClasse = arquivo.getName().replace(EXTENSAO_CLASS, "");
            programasDisponiveis.add(nomeClasse);
        }

        programasDisponiveis.sort(String::compareTo);
    }

    private static boolean pastaExiste(File pasta) {
        return pasta.exists() && pasta.isDirectory();
    }

    /**
     * Exibe o menu principal com todas as opções.
     */
    private static void exibirMenuPrincipal() {
        boolean continuar = true;

        while (continuar) {
            limparTela();
            exibirCabecalho();
            exibirOpcoes();

            int opcao = coletarOpcao();

            if (opcao == OPCAO_SAIR) {
                exibirMensagemSaida();
                continuar = false;
            } else if (opcao > 0 && opcao <= programasDisponiveis.size()) {
                executarPrograma(programasDisponiveis.get(opcao - 1));
            } else {
                exibirErro("Opção inválida! Digite um número válido.");
                pausar();
            }
        }
    }

    /**
     * Exibe o cabeçalho do menu.
     */
    private static void exibirCabecalho() {
        System.out.println(SEPARADOR);
        System.out.println("    LABORATÓRIO DE PROGRAMAÇÃO - MENU PRINCIPAL");
        System.out.println(SEPARADOR);
        System.out.println();
    }

    /**
     * Exibe todas as opções disponíveis.
     */
    private static void exibirOpcoes() {
        System.out.println("Programas Disponíveis:");
        System.out.println();

        for (int i = 0; i < programasDisponiveis.size(); i++) {
            String programa = programasDisponiveis.get(i);
            String descricao = obterDescricaoPrograma(programa);
            System.out.printf("[%2d] %-25s - %s%n", i + 1, programa, descricao);
        }

        System.out.println();
        System.out.printf("[%2d] Sair%n", OPCAO_SAIR);
        System.out.println();
    }

    /**
     * Retorna a descrição de cada programa.
     */
    private static String obterDescricaoPrograma(String nomePrograma) {
        if (nomePrograma.equals("AreaRetangulo")) {
            return "Calcula a área de um retângulo";
        } else if (nomePrograma.equals("AreaTriangulo")) {
            return "Calcula a área de um triângulo";
        } else if (nomePrograma.equals("AreaCirculo")) {
            return "Calcula a área de um círculo";
        } else if (nomePrograma.equals("AreaCaixa")) {
            return "Calcula a área de uma caixa";
        } else if (nomePrograma.equals("AreaPiramide")) {
            return "Calcula a área de uma pirâmide";
        } else if (nomePrograma.equals("AreaTubo")) {
            return "Calcula a área de um cilindro";
        } else if (nomePrograma.equals("AreaBola")) {
            return "Calcula a área de uma esfera";
        } else if (nomePrograma.equals("SimuladorDados")) {
            return "Simula lançamento de dados";
        } else if (nomePrograma.equals("LivroDeReceitas")) {
            return "Cria e salva receitas em arquivo";
        } else {
            return "Programa disponível";
        }
    }

    /**
     * Coleta a opção do usuário.
     */
    private static int coletarOpcao() {
        System.out.print("Digite a opção desejada: ");

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Executa o programa selecionado.
     */
    private static void executarPrograma(String nomePrograma) {
        limparTela();
        System.out.println(SEPARADOR);
        System.out.printf("Executando: %s%n", nomePrograma);
        System.out.println(SEPARADOR);
        System.out.println();

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp", PASTA_N2,
                    nomePrograma);
            pb.inheritIO();
            Process processo = pb.start();
            int codigoSaida = processo.waitFor();

            if (codigoSaida != 0) {
                exibirErro("O programa terminou com código de erro: " + codigoSaida);
            }
        } catch (IOException e) {
            exibirErro("Erro ao executar o programa: " + e.getMessage());
        } catch (InterruptedException e) {
            exibirErro("Execução interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        pausar();
    }

    /**
     * Exibe uma mensagem de erro formatada.
     */
    private static void exibirErro(String mensagem) {
        System.out.println();
        System.out.println("[ERRO] " + mensagem);
        System.out.println();
    }

    /**
     * Exibe mensagem de saída.
     */
    private static void exibirMensagemSaida() {
        limparTela();
        System.out.println(SEPARADOR);
        System.out.println("Obrigado por usar o Laboratório de Programação!");
        System.out.println("Até logo!");
        System.out.println(SEPARADOR);
    }

    /**
     * Pausa a execução aguardando o usuário pressionar Enter.
     */
    private static void pausar() {
        System.out.println();
        System.out.print("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }

    /**
     * Limpa a tela do console.
     */
    private static void limparTela() {
        try {
            String osName = System.getProperty("os.name").toLowerCase();

            if (osName.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // Se não conseguir limpar, apenas imprime quebras de linha
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
