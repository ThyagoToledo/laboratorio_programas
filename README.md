# LABORATÓRIO DE PROGRAMAÇÃO

Atividades da faculdade, separadas por pastas
---

## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Clean Code](https://img.shields.io/badge/Clean%20Code-4CAF50?style=flat&logo=checkmark&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-003D82?style=flat&logo=target&logoColor=white)
![File I/O](https://img.shields.io/badge/File%20I/O-FF6B35?style=flat&logo=files&logoColor=white)
![Math](https://img.shields.io/badge/Math%20Algorithms-9C27B0?style=flat&logo=calculator&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white)

---
## � Sumário de Atividades

### [1] Cálculos Geométricos (Senai_LLP_Variaveis_Geometria)

Implementação de cálculos de área para diferentes formas geométricas:

- [AreaRetangulo.java](N2/AreaRetangulo.java) - Calcula a área de um retângulo
- [AreaTriangulo.java](N2/AreaTriangulo.java) - Calcula a área de um triângulo
- [AreaCirculo.java](N2/AreaCirculo.java) - Calcula a área de um círculo
- [AreaCaixa.java](N2/AreaCaixa.java) - Calcula a área de uma caixa (paralelepípedo)
- [AreaPiramide.java](N2/AreaPiramide.java) - Calcula a área de uma pirâmide quadrangular
- [AreaTubo.java](N2/AreaTubo.java) - Calcula a área de um cilindro/tubo
- [AreaBola.java](N2/AreaBola.java) - Calcula a área de uma esfera/bola

#### Funcionalidades:
- Validação robusta de entrada
- Cálculos matemáticos precisos
- Formatação de saída estruturada
- Tratamento de exceções

### [2] Simulador de Dados (Senai_LLP_Dados)

- [SimuladorDados.java](N2/SimuladorDados.java) - Simula lançamento de um ou múltiplos dados com visualização gráfica

#### Funcionalidades:
- Gera números aleatórios entre 1 e 6 usando `Math.random()`
- Exibe o desenho visual do resultado do dado
- Calcula e exibe a soma total dos lançamentos
- Interface interativa com validação de entrada

### [3] Livro de Receitas (Senai_LLP_File_LivroDeReceitas)

- [LivroDeReceitas.java](N2/LivroDeReceitas.java) - Aplicação para criar e armazenar receitas em arquivo

#### Funcionalidades:
- Captura nome da receita
- Coleta ingredientes (descrição e quantidade)
- Coleta instruções passo-a-passo
- Salva em arquivo de texto (.txt) com formatação estruturada
- Exibe a receita no console antes de salvar

---

---

## Menu Principal

[MenuPrincipal.java](MenuPrincipal.java) - Aplicação menu interativa para executar todos os programas

#### Funcionalidades:
- Descobre automaticamente todos os programas compilados na pasta N2
- Interface visual limpa e intuitiva
- Menu numerado com descrição de cada programa
- Executa programas sem necessidade de linha de comando
- Limpeza de tela entre execuções
- Navegação fácil entre programas

#### Como usar:
```bash
javac N2/*.java
javac MenuPrincipal.java
java MenuPrincipal
```

---

## Standards de Código

Constantes nomeadas em vez de valores mágicos  
Validações robustas de entrada  
Métodos focados com responsabilidade única  
Documentação Javadoc completa  
Formatação com `printf()` para saída consistente  
Tratamento apropriado de exceções  
Uso de try-with-resources para gerenciamento de recursos  
Encapsulamento com métodos privados  
Nomes descritivos para variáveis e métodos

---

## Como Usar

### Compilar
```bash
cd N2
javac *.java
```

### Executar com Menu Interativo (Recomendado)
```bash
cd N2
java MenuPrincipal
```

Este comando abre um menu interativo que permite selecionar e executar qualquer programa:
- Menu com descrição de cada programa
- Execução direta sem necessidade de comandos
- Interface limpa e profissional

### Executar Programas Individuais
```bash
cd N2

# Cálculos geométricos
java AreaRetangulo
java AreaTriangulo
java AreaCirculo
java AreaCaixa
java AreaPiramide
java AreaTubo
java AreaBola

# Simulador de dados
java SimuladorDados

# Livro de receitas
java LivroDeReceitas
```

---

## Informações

**Autor:** ThyagoToledo  
**Data:** Maio de 2026  
**Linguagem:** Java 8+
