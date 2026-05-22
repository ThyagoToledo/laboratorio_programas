@echo off
REM Configura a codificacao do console para UTF-8
chcp 65001 >nul

REM Define o diretorio atual do script como o diretorio de trabalho
cd /d "%~dp0"

echo ============================================================
echo      INICIALIZANDO LABORATORIO DE PROGRAMACAO
echo ============================================================
echo.

REM 1. Verificar se o comando 'java' esta disponivel
where java >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERRO] Java nao foi encontrado no seu computador!
    echo.
    echo Para executar este programa, voce precisa ter o Java instalado.
    echo.
    echo Recomendacoes de download:
    echo - Adoptium Temurin [Recomendado]: https://adoptium.net/
    echo - Oracle JDK: https://www.oracle.com/java/technologies/downloads/
    echo.
    echo Instale o Java, reinicie o prompt de comando ou computador e tente novamente.
    goto PAUSE_EXIT
)

REM 2. Verificar se o comando 'javac' esta disponivel para compilar
where javac >nul 2>nul
if %errorlevel% equ 0 (
    echo [INFO] Compilador Java encontrado. Compilando o projeto...
    javac -encoding UTF-8 MenuPrincipal.java N2\*.java
    if %errorlevel% neq 0 (
        echo [ERRO] Falha na compilacao do codigo! Verifique se ha erros no seu codigo Java.
        goto PAUSE_EXIT
    )
    echo [INFO] Compilacao concluida com sucesso!
    echo.
) else (
    echo [AVISO] Compilador 'javac' nao encontrado - apenas JRE instalado.
    rem Verificar se o MenuPrincipal.class ja existe para poder rodar direto
    if not exist "MenuPrincipal.class" (
        echo [ERRO] Arquivos compilados .class nao encontrados e nao foi possivel compilar.
        echo.
        echo Para compilar e rodar o projeto do zero, voce precisa do JDK - Java Development Kit.
        echo Baixe em: https://adoptium.net/ ou https://www.oracle.com/java/technologies/downloads/
        goto PAUSE_EXIT
    )
    echo [INFO] Usando arquivos pre-compilados .class existentes.
    echo.
)

REM 3. Executar o MenuPrincipal
echo [INFO] Iniciando o Menu Principal...
echo.
java -cp . MenuPrincipal
goto END

:PAUSE_EXIT
echo.
echo Pressione qualquer tecla para sair...
pause >nul

:END
