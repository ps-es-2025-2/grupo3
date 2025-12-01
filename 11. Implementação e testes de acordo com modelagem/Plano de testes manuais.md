# Plano de testes - Sistema de Teste Vocacional - Mind System

## Identificação do documento

Projeto: Mind System
Tecnologia: Java / JavaFX / BlueJ
Tipo de Teste: Manual / Funcional e Não Funcional

## Objetivo e escopo

O objetivo deste documento é validar as funcionalidades críticas do sistema, 
garantindo que alunos e psicólogos possam utilizar as ferramentas de questionários,
laudos, feedbacks e agendamentos conforme especificado nos requisitos.

O escopo inclui:
- Módulo de Autenticação (Login/Logout).
- Módulo de Psicólogo (Cadastro de questionários, geração de laudos).
- Módulo de Aluno (Respostas a questionários, visualização de laudos, agendamento).
- Verificação de Requisitos Não Funcionais (Usabilidade e Performance básica).

## Pré-requisitos

1. O projeto deve estar compilado e em execução (via BlueJ ou JAR).
2. Como o banco de dados é em memória (Mock), ao reiniciar a aplicação, 
   todos os dados criados (novos questionários/laudos) serão perdidos. 
   **Nota:** Testes sequenciais devem ser realizados na mesma sessão de execução.

## Casos de teste funcionais

# Ciclo de testes 1: Login (RF1, RNF5)

[CT-01] Login de Aluno com Sucesso
- Pré-condição: Aplicação aberta na tela de Login.
- Passo 1: Inserir usuário: "joao" (mock padrão).
- Passo 2: Inserir senha correta.
- Passo 3: Clicar no botão "Entrar".
> Resultado Esperado: Redirecionamento para o Dashboard do Aluno. Mensagem 
  "Bem-vindo, João da Silva" exibida no topo.

[CT-02] Login de Psicólogo com Sucesso
- Pré-condição: Aplicação aberta na tela de Login.
- Passo 1: Inserir usuário: "psi" (mock padrão).
- Passo 2: Inserir senha correta.
- Passo 3: Clicar no botão "Entrar".
> Resultado Esperado: Redirecionamento para o Dashboard do Psicólogo. Acesso aos
  botões "Escrever Novo Laudo" e "Cadastrar Questionários".

[CT-03] Falha de Login (Credenciais Inválidas)
- Passo 1: Inserir e-mail inexistente ou formato inválido.
- Passo 2: Inserir senha incorreta.
- Passo 3: Clicar em "Entrar".
> Resultado Esperado: Sistema permanece na tela de login. Exibe mensagem de erro
  em vermelho (ex: "Usuário ou senha inválidos").

[CT-04] Logout do Sistema
- Pré-condição: Usuário logado.
- Passo 1: Clicar no botão "Sair" ou "Logout" no menu principal.
> Resultado Esperado: Encerramento da sessão e retorno imediato à tela de Login.

# Ciclo de testes 2: Questionários (RF2, RF3, RNF6)

[CT-05] Cadastrar Novo Questionário (Perfil Psicólogo)
- Pré-condição: Logado como Psicólogo.
- Passo 1: Acessar menu "Cadastrar Questionários".
- Passo 2: Preencher "Título" (ex: "Ansiedade Escolar").
- Passo 3: Adicionar pergunta e opções (separadas por ponto e vírgula).
- Passo 4: Clicar em "Salvar".
> Resultado Esperado: Mensagem de "Questionário cadastrado com sucesso". O item
  deve ficar disponível imediatamente para os alunos.

[CT-06] Responder Questionário (Perfil Aluno)
- Pré-condição: Logado como Aluno; Existir questionário cadastrado.
- Passo 1: Clicar em "Responder Questionários".
- Passo 2: Selecionar um questionário na lista (ex: "Avaliação Bem-Estar").
- Passo 3: Selecionar uma opção para cada pergunta.
- Passo 4: Clicar em "Enviar Respostas".
> Resultado Esperado: Mensagem de sucesso ("Respostas enviadas"). O sistema deve
  registrar a resposta no repositório para avaliação posterior.

[CT-07] Validação de Campos Obrigatórios (Questionário)
- Passo 1: Abrir um questionário como aluno.
- Passo 2: Deixar uma ou mais perguntas sem resposta.
- Passo 3: Tentar clicar em "Enviar".
> Resultado Esperado: O sistema bloqueia o envio e exibe alerta: "Responda todas
  as perguntas".

# Ciclo de testes 3: Laudos e Feedback (RF4, RF5, RF7)

[CT-08] Gerar Laudo ou Feedback (Perfil Psicólogo)
- Pré-condição: Logado como Psicólogo.
- Passo 1: Acessar "Escrever Novo Laudo" ou "Avaliar Questionários".
- Passo 2: Selecionar o Aluno alvo ou a resposta pendente.
- Passo 3: Digitar o parecer no campo de texto.
- Passo 4: Clicar em "Salvar/Enviar".
> Resultado Esperado: Confirmação visual de salvamento. Log no console indicando
  "Gerando PDF" (simulação do RF5).

[CT-09] Visualizar Meus Laudos (Perfil Aluno)
- Pré-condição: Logado como Aluno (que recebeu o laudo do CT-08).
- Passo 1: No Dashboard, clicar em "Meus Laudos".
- Passo 2: Verificar a lista exibida.
> Resultado Esperado: O laudo recém-criado deve aparecer na lista com Data e
  Conteúdo corretos.
  
# Ciclo de testes 4: Agendamento e Consultas (RF6, RNF3)

[CT-10] Agendar Consulta (Perfil Aluno)
- Pré-condição: Logado como Aluno.
- Passo 1: Clicar em "Agendar Consulta".
- Passo 2: Selecionar Data no calendário e Horário no combobox.
- Passo 3: Clicar em "Confirmar Agendamento".
> Resultado Esperado: Mensagem "Agendado com sucesso".

[CT-11] Geração de Link para Consulta Virtual
- Passo 1: Após agendar (CT-10), verificar o feedback do sistema.
> Resultado Esperado: O sistema deve informar ou simular a geração de um link
  (Ex: Google Meet) associado àquela consulta.
  
## Casos de teste não funcionais 

[RNF-01] Usabilidade e Interface (Ref: RNF1)
- Critério: Navegar entre o Dashboard e as telas internas (Questionário, Laudos)
  e voltar.
> Aceite: O fluxo deve ser intuitivo, sempre havendo botão "Voltar" ou menu
  visível, sem deixar o usuário "preso" em uma tela.

[RNF-02] Desempenho (Ref: RNF4)
- Critério: Tempo de resposta ao salvar um questionário ou agendar consulta.
> Aceite: A ação deve ser concluída em menos de 2 segundos.

[RNF-03] Estabilidade (Ref: RNF3)
- Critério: Executar o fluxo completo: Login -> Responder Quest. -> Logout -> 
  Login (Psi) -> Avaliar -> Logout -> Login (Aluno) -> Ver Laudo.
> Aceite: O sistema não deve apresentar erros inesperados (Crash/Exceptions) 
  durante a troca de usuários e persistência de dados em memória.
