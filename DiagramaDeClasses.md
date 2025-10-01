# Diagrama de Classes - Sistema de Teste Vocacional - Mind System

<img width="807" height="596" alt="image" src="https://github.com/user-attachments/assets/3a04d53c-7ed0-4184-be8f-f5faa1ba36f9" />

## Código PlantUML
```plantuml
@startuml
title Diagrama de Classes - Sistema de Teste Vocacional

class Usuario

class Aluno

class Psicologo

class Administrador

class Autenticacao

class API_Google

class Questionario

class Pergunta

class Resposta

class PesquisaFeedback

class Laudo

class Consulta

class GeradorPDF


Usuario <|-- Aluno
Usuario <|-- Psicologo
Usuario <|-- Administrador

Usuario ||--o{ Autenticacao : "possui"

Aluno ||--o{ Resposta : "responde"
Aluno ||--o{ Laudo : "visualiza"
Aluno ||--o{ Consulta : "agenda"
Aluno --o{ Questionario : "visualiza"
Aluno --o{ PesquisaFeedback : "responde"

Psicologo ||--o{ Laudo : "gera"
Psicologo ||--o{ Consulta : "realiza"

Administrador ||--o{ Questionario : "gerencia"
Administrador ||--o{ PesquisaFeedback : "cria"
Administrador ||--o{ Psicologo : "cadastra"

Pergunta --o{ Resposta : "recebe"

Consulta ||--|| API_Google
Laudo ||--|| GeradorPDF : "gera"

Questionario *-- Pergunta
PesquisaFeedback *-- Pergunta

@enduml
```

## Diagrama de Classes mais detalhado com métodos e atributos

<img width="1216" height="1462" alt="DiagramaClassesCompleto" src="https://github.com/user-attachments/assets/c04148fd-744e-4c72-a9b4-c6884595db56" />
(Versão protótipo - Sujeita a mudanças)

## Código PlantUML
```plantuml
@startuml
title Diagrama de Classes - Sistema de Teste Vocacional (Completo)

class Usuario {
    - id: Long
    - nome: String
    - email: String
    - senha: String
    - dataCadastro: Date
    - ativo: Boolean
    - consentimentoLGPD: Boolean
    + login(): Boolean
    + logout(): void
    + atualizarDados(): void
    + validarCredenciais(): Boolean
    + consentirDados(): void
    + acessarDadosPessoais(): Map
}

class Aluno {
    - cpf: String
    - dataNascimento: Date
    - escola: String
    - serie: String
    + responderQuestionario(): void
    + visualizarProgresso(): void
    + acessarLaudos(): void
    + agendarConsulta(): void
    + responderPesquisa(): void
}

class Psicologo {
    - crp: String
    - especialidade: String
    - experiencia: Integer
    + analisarAluno(): void
    + gerarLaudo(): void
    + agendarConsulta(): void
    + realizarConsulta(): void
    + responderPesquisa(): void
}

class Administrador {
    - nivelAcesso: String
    + cadastrarPsicologo(): void
    + gerenciarUsuarios(): void
    + cadastrarQuestionario(): void
    + gerenciarQuestionarios(): void
    + registrarPesquisa(): void
}

class Autenticacao {
    - token: String
    - dataExpiracao: Date
    - usuarioId: Long
    + validarCredenciais(): Boolean
    + gerarToken(): String
    + validarToken(): Boolean
    + realizarLogin(): String
    + realizarLoginSocial(): String
    + realizarCadastro(): Boolean
}

class API_Google {
    - clientId: String
    - clientSecret: String
    + autenticarGoogle(): Boolean
    + obterDadosUsuario(): Map
    + criarSessaoMeet(): String
    + gerarLinkMeet(): String
}

class Questionario {
    - id: Long
    - titulo: String
    - descricao: String
    - ativo: Boolean
    - dataCriacao: Date
    - perguntas: List<Pergunta>
    + adicionarPergunta(): void
    + removerPergunta(): void
    + ativarQuestionario(): void
    + desativarQuestionario(): void
    + calcularResultado(): Map
}

class Pergunta {
    - id: Long
    - enunciado: String
    - tipo: String
    - opcoes: List<String>
    - obrigatoria: Boolean
    - ordem: Integer
    + adicionarOpcaoResposta(): void
    + obterOpcoesResposta(): List<String>
}

class Resposta {
    - id: Long
    - valor: String
    - dataResposta: Date
    - perguntaId: Long
    - usuarioId: Long
    + salvarResposta(): void
    + calcularPontuacao(): Integer
    + validarResposta(): Boolean
}

class PesquisaFeedback {
    - id: Long
    - titulo: String
    - descricao: String
    - ativa: Boolean
    - dataInicio: Date
    - dataFim: Date
    - perguntas: List<Pergunta>
    + ativarPesquisa(): void
    + desativarPesquisa(): void
    + registrarResposta(): Boolean
    + obterRelatorio(): Map
}

class Laudo {
    - id: Long
    - dataGeracao: Date
    - conteudo: String
    - arquivoPDF: String
    - status: String
    - alunoId: Long
    - psicologoId: Long
    + gerarPDF(): void
    + enviarLaudo(): void
    + salvarLaudo(): Boolean
}

class Consulta {
    - id: Long
    - dataHora: DateTime
    - duracao: Integer
    - status: String
    - linkMeet: String
    - alunoId: Long
    - psicologoId: Long
    - observacoes: String
    + agendarConsulta(): void
    + cancelarConsulta(): void
    + iniciarConsulta(): void
    + gerarLinkGoogleMeet(): String
}

class GeradorPDF {
    - template: String
    - dados: Map
    - templatePath: String
    - outputPath: String
    + gerarPDF(): String
    + aplicarTemplate(): void
    + salvarArquivo(): void
    + gerarPDFLaudo(): Boolean
}


Usuario <|-- Aluno
Usuario <|-- Psicologo
Usuario <|-- Administrador

Usuario ||--o{ Autenticacao : "possui"

Aluno ||--o{ Resposta : "responde"
Aluno ||--o{ Laudo : "recebe"
Aluno ||--o{ Consulta : "agenda"
Aluno --o{ Questionario : "visualiza"
Aluno --o{ PesquisaFeedback : "responde"

Psicologo ||--o{ Laudo : "gera"
Psicologo ||--o{ Consulta : "realiza"

Administrador ||--o{ Questionario : "gerencia"
Administrador ||--o{ PesquisaFeedback : "cria"
Administrador ||--o{ Psicologo : "cadastra"

Pergunta --o{ Resposta : "recebe"

Consulta ||--|| API_Google : "utiliza"
Laudo ||--|| GeradorPDF : "gera"

Questionario *-- Pergunta
PesquisaFeedback *-- Pergunta

@enduml
```
