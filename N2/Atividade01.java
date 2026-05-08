// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Atividade01 {
    public Atividade01() {
    }

    public static void main(String[] var0) {
        if (var0.length == 0) {
            System.out.println("Por favor, forneça um texto como argumento.");
            System.out.println("Exemplo: java Atividade01 \"Este é um texto de teste.\"");
        } else {
            String var1 = String.join(" ", var0);
            int var2 = 0;
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            String var6 = var1.toLowerCase();

            for (int var7 = 0; var7 < var6.length(); ++var7) {
                char var8 = var6.charAt(var7);
                if (var8 == 'a' || var8 == 'e' || var8 == 'i' || var8 == 'o' || var8 == 'u') {
                    ++var3;
                }
            }

            String[] var14 = var1.split("\\s+");

            for (String var11 : var14) {
                String var12 = var11.replaceAll("[^a-zA-ZÀ-ÿ]", "");
                if (!var12.isEmpty()) {
                    ++var2;
                    int var13 = var12.length();
                    if (var13 % 2 == 0) {
                        ++var4;
                    } else {
                        ++var5;
                    }
                }
            }

            System.out.println("--- Resultados da Análise ---");
            System.out.println("Texto: " + var1);
            System.out.println("Quantidade de palavras: " + var2);
            System.out.println("Quantidade de vogais (sem acentos): " + var3);
            System.out.println("Palavras com qtd. de letras pares: " + var4);
            System.out.println("Palavras com qtd. de letras ímpares: " + var5);
        }
    }
}
