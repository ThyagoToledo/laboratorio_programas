# LABORATÓRIO DE PROGRAMAÇÃO

Atividades da faculdade, separadas por pastas

## 📋 Sumário de Atividades

### N2 - Exercícios de Lógica e Manipulação de Dados

#### 1️⃣ Cálculos Geométricos (Senai_LLP_Variaveis_Geometria)

Implementação de cálculos de área para diferentes formas geométricas:

- [AreaRetangulo.java](N2/AreaRetangulo.java) - Calcula a área de um retângulo
- [AreaTriangulo.java](N2/AreaTriangulo.java) - Calcula a área de um triângulo
- [AreaCirculo.java](N2/AreaCirculo.java) - Calcula a área de um círculo
- [AreaCaixa.java](N2/AreaCaixa.java) - Calcula a área de uma caixa (paralelepípedo)
- [AreaPiramide.java](N2/AreaPiramide.java) - Calcula a área de uma pirâmide quadrangular
- [AreaTubo.java](N2/AreaTubo.java) - Calcula a área de um cilindro/tubo
- [AreaBola.java](N2/AreaBola.java) - Calcula a área de uma esfera/bola

#### 2️⃣ Simulador de Dados (Senai_LLP_Dados)

- [SimuladorDados.java](N2/SimuladorDados.java) - Simula lançamento de um ou múltiplos dados com visualização gráfica

**Funcionalidades:**
- Gera números aleatórios entre 1 e 6 usando `Math.random()`
- Exibe o desenho visual do resultado do dado
- Calcula e exibe a soma total dos lançamentos
- Interface interativa com validação de entrada

#### 3️⃣ Livro de Receitas (Senai_LLP_File_LivroDeReceitas)

- [LivroDeReceitas.java](N2/LivroDeReceitas.java) - Aplicação para criar e armazenar receitas em arquivo

**Funcionalidades:**
- Captura nome da receita
- Coleta ingredientes (descrição e quantidade)
- Coleta instruções passo-a-passo
- Salva em arquivo de texto (.txt) com formatação estruturada
- Exibe a receita no console antes de salvar

---

## 🎯 Melhorias de Clean Code Implementadas

✅ Constantes nomeadas em vez de valores mágicos  
✅ Validações robustas de entrada  
✅ Métodos focados com responsabilidade única  
✅ Documentação Javadoc completa  
✅ Formatação com `printf()` para saída consistente  
✅ Tratamento apropriado de exceções  
✅ Uso de try-with-resources para gerenciamento de recursos  
✅ Encapsulamento com métodos privados  
✅ Nomes descritivos para variáveis e métodos

---

## 📝 Como Usar

### Compilar
```bash
javac N2/*.java
```

### Executar
```bash
# Cálculos geométricos
java -cp N2 AreaRetangulo
java -cp N2 AreaTriangulo
java -cp N2 AreaCirculo
java -cp N2 AreaCaixa
java -cp N2 AreaPiramide
java -cp N2 AreaTubo
java -cp N2 AreaBola

# Simulador de dados
java -cp N2 SimuladorDados

# Livro de receitas
java -cp N2 LivroDeReceitas
```

---

## 👤 Autor
ThyagoToledo

## 📅 Data
Maio de 2026
