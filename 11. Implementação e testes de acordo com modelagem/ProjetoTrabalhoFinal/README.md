**AUTOR:** Gustavo Rodrigues Ribeiro - RA: 202003570 \
**DISCIPLINA:** Projeto de Software \
**DATA:** 31/08/2025

<br>

# Aplicação CRUD de Ativos Digitais com JavaFX

Esta é uma aplicação de desktop que demonstra como realizar operações de CRUD (Create, Read, Update, Delete) em uma entidade `AtivoDigital`. A interface gráfica foi construída com JavaFX e segue um fluxo de trabalho de negócio robusto, com estados definidos para inserção e edição de dados. A camada de persistência utiliza ORMLite e SQLite.

## Tecnologias Utilizadas

- **Java**
- **JavaFX**
- **ORMLite** (ORM)
- **SQLite** (Banco de Dados)
- **SLF4J** (Logging)
- **BlueJ** (IDE)
- **Scene Builder** (Para design da UI)

## Pré-requisitos

1.  **JDK 11 ou superior** instalado.
2.  **JavaFX SDK** baixado e descompactado em um local conhecido. (Ex: `C:\javafx-sdk-21.0.6`)
3.  **BlueJ** (versão recente, 5.5.0+) instalado.
4.  **Scene Builder** instalado.

## Configuração no BlueJ

Siga estes passos **cuidadosamente** para executar o projeto.

### 1. Crie o Projeto e Estrutura de Pastas

-   Crie um novo projeto no BlueJ (ex: `ProjetoJavaFX_PS`).
-   Dentro da pasta do projeto criada no seu computador, crie uma pasta chamada `lib`.
-   Copie os 5 arquivos JAR necessários para dentro desta pasta `lib`:
    -   `ormlite-core-x.x.jar`
    -   `ormlite-jdbc-x.x.jar`
    -   `slf4j-api-x.x.x.jar`
    -   `slf4j-simple-x.x.x.jar`
    -   `sqlite-jdbc-x.x.x.jar`

### 2. Configure as Bibliotecas

-   Abra o BlueJ.
-   Vá em **Tools -> Preferences -> Libraries**. Clique em **Add File...** e adicione os 5 arquivos JAR que estão na sua pasta `lib`.
-   Tenha certeza de que o 'JavaFX' está ativo em seu 'BlueJ'.

## Execução

-   **OBS:** Caso tenha copiado o diretório com o projeto "ProjetoJavaFX_PS", basta abrir o projeto no BlueJ e ir direto para o 'Passo 4'. Caso contrário, execute todos os passos a seguir.

1.  **Crie os Pacotes:** Com o projeto aberto no BlueJ, clique com o botão direito e crie os três pacotes: `model`, `view` e `controller`.
2.  **Crie as Classes:** Crie cada classe Java e o arquivo FXML dentro de seus respectivos pacotes, copiando e colando o código-fonte fornecido na atividade.
3.  **Compile:** Clique no botão "Compile" no BlueJ. Se todas as configurações estiverem corretas, o projeto compilará sem erros.
4.  **Execute:** Clique com o botão direito na classe `view.AppView` e selecione o método `void main(String[] args)`. A interface gráfica da aplicação deve aparecer.

-   **OBS 2:** Caso já tenha executado o projeto uma vez e queira executá-lo novamente, antes, reinicie a VM do BlueJ.

## Estrutura do Projeto

-   **`model`**: Contém as classes da entidade (`AtivoDigital`), o repositório (`AtivoDigitalRepository`) e a classe de conexão (`Database`), além do enum (`TipoAtivo`).
-   **`view`**:
    -   `app.fxml`: Arquivo XML que define a estrutura da interface gráfica.
    -   `AppView.java`: Classe principal que estende `Application` e inicia a aplicação JavaFX.
    -   `AtivoDigitalView.java`: Uma classe "ViewModel" que facilita o binding com a `TableView`.
-   **`controller`**:
    -   `AppController.java`: Controla toda a lógica da interface, gerenciando uma máquina de estados (`Acao`) para controlar o fluxo de interação do usuário.
