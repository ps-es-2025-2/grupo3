# Descrição de Casos de Uso - Sistema de Teste Vocacional - Mind System

## Caso de Uso: Realizar Cadastro

**Escopo:**  
Autenticação  

**Propósito:**  
Permitir que novos usuários (Aluno, Psicólogo, Administrador) criem uma conta no sistema.  

**Ator:**  
Usuário (Aluno, Psicólogo ou Administrador)  

**Pré-condições:**  
- O usuário deve fornecer dados pessoais válidos.  
- O consentimento de uso de dados (LGPD) deve ser aceito.  

**Pós-condições:**  
- O cadastro é registrado no banco de dados.  
- O usuário pode realizar login posteriormente.  

### Fluxo de Eventos Normal  
1. O usuário acessa a página de cadastro.  
2. O sistema solicita dados pessoais obrigatórios.  
3. O usuário consente com o uso dos dados (LGPD).  
4. O sistema valida os dados e registra o novo usuário.  
5. O cadastro é confirmado e o usuário recebe uma notificação de sucesso.  

### Fluxo de Eventos de Exceção  
- Dados inválidos: O sistema informa ao usuário que há inconsistências e pede correção.  
- Falha de conexão: O sistema não consegue salvar os dados e informa erro temporário.  

**Requisitos Relacionados:**  
RF1, RF8  
RNF1, RNF5

**Classes:**  
Usuario, Autenticacao

---

## Caso de Uso: Realizar Login

**Escopo:**  
Autenticação  

**Propósito:**  
Permitir que o usuário acesse o sistema com suas credenciais.  

**Ator:**  
Usuário  

**Pré-condições:**  
- O usuário deve estar previamente cadastrado.  

**Pós-condições:**  
- O sistema valida as credenciais e libera acesso ao perfil correspondente.  

### Fluxo de Eventos Normal  
1. O usuário insere e-mail e senha.  
2. O sistema chama o caso de uso **Validar Credenciais**.  
3. As credenciais são verificadas e o acesso concedido.  

### Fluxo de Eventos de Exceção  
- Credenciais inválidas: O sistema informa erro de login.  
- Múltiplas tentativas incorretas: O sistema bloqueia temporariamente o acesso.  

**Requisitos Relacionados:**  
RF1  
RNF5

**Classes:**  
Usuario, Autenticacao

---

## Caso de Uso: Login Social (Gmail)

**Escopo:**  
Autenticação  

**Propósito:**  
Permitir login com conta Google.  

**Ator:**  
Usuário  

**Pré-condições:**  
- O usuário deve possuir conta ativa no Google.  

**Pós-condições:**  
- O sistema autentica via API do Google e cria/atualiza sessão no sistema.  

### Fluxo de Eventos Normal  
1. O usuário seleciona a opção de login com Gmail.  
2. O sistema redireciona para a API do Google.  
3. O Google valida as credenciais.  
4. O sistema cria sessão e concede acesso.  

### Fluxo de Eventos de Exceção  
- Falha de autenticação no Google: O sistema exibe mensagem de erro.  
- Usuário não autorizou permissões: O login é cancelado.  

**Requisitos Relacionados:**  
RF1  
RNF1, RNF5

**Classes:**  
Usuario, Autenticacao, API_Google  

---

## Caso de Uso: Atualizar Dados Pessoais

**Escopo:**  
Autenticação  

**Propósito:**  
Permitir que o usuário atualize suas informações pessoais no sistema.  

**Ator:**  
Usuário  

**Pré-condições:**  
- O usuário deve estar autenticado.  

**Pós-condições:**  
- Os dados pessoais são atualizados no banco de dados.  

### Fluxo de Eventos Normal  
1. O usuário acessa a página de edição de dados.  
2. O sistema exibe os dados atuais.  
3. O usuário atualiza os dados desejados.  
4. O sistema valida e salva as alterações.  

### Fluxo de Eventos de Exceção  
- Dados inválidos: O sistema informa inconsistências.  
- Falha na atualização: O sistema não salva as alterações e exibe mensagem de erro.  

**Requisitos Relacionados:**  
RF1, RF8  
RNF1

**Classes:**  
Usuario, Autenticacao  

---

## Caso de Uso: Visualizar Questionários

**Escopo:**  
Gestão de Questionários  

**Propósito:**  
Permitir que o aluno visualize os questionários disponíveis.  

**Ator:**  
Aluno  

**Pré-condições:**  
- O aluno deve estar autenticado.  

**Pós-condições:**  
- O sistema exibe lista de questionários disponíveis.  

### Fluxo de Eventos Normal  
1. O aluno acessa a seção de questionários.  
2. O sistema apresenta os questionários cadastrados pelo administrador.  

### Fluxo de Eventos de Exceção  
- Nenhum questionário disponível: O sistema informa a ausência de questionários.  

**Requisitos Relacionados:**  
RF2  
RNF1

**Classes:**  
Questionario, Usuario  

---

## Caso de Uso: Responder Questionário

**Escopo:**  
Gestão de Questionários  

**Propósito:**  
Permitir que o aluno responda a questionários disponíveis.  

**Ator:**  
Aluno  

**Pré-condições:**  
- O aluno deve estar autenticado.  
- Deve existir questionário disponível.  

**Pós-condições:**  
- As respostas são salvas e associadas ao aluno.  

### Fluxo de Eventos Normal  
1. O aluno escolhe um questionário.  
2. O sistema apresenta as perguntas.  
3. O aluno responde às questões.  
4. O sistema salva as respostas.  

### Fluxo de Eventos de Exceção  
- Erro no salvamento: O sistema não consegue armazenar as respostas.  

**Requisitos Relacionados:**  
RF2  
RNF1 

**Classes:**  
Questionario, Resposta, Usuario  

---

## Caso de Uso: Visualizar Progresso

**Escopo:**  
Gestão de Questionários  

**Propósito:**  
Permitir que o aluno acompanhe seu progresso nos questionários.  

**Ator:**  
Aluno  

**Pré-condições:**  
- O aluno deve ter respondido pelo menos um questionário.  

**Pós-condições:**  
- O sistema exibe relatórios de progresso.  

### Fluxo de Eventos Normal  
1. O aluno acessa a seção de progresso.  
2. O sistema calcula e apresenta os resultados parciais.  

### Fluxo de Eventos de Exceção  
- Sem dados suficientes: O sistema informa que não há progresso a exibir.  

**Requisitos Relacionados:**  
RF3  
RNF1

**Classes:**  
Usuario, Questionario, Resposta  

---

## Caso de Uso: Cadastrar Questionário

**Escopo:**  
Gestão de Questionários  

**Propósito:**  
Permitir que o administrador cadastre novos questionários.  

**Ator:**  
Administrador  

**Pré-condições:**  
- O administrador deve estar autenticado.  

**Pós-condições:**  
- O novo questionário fica disponível para os alunos.  

### Fluxo de Eventos Normal  
1. O administrador acessa a seção de cadastro de questionários.  
2. O sistema solicita informações (título, perguntas, opções de resposta).  
3. O administrador confirma o cadastro.  
4. O questionário é salvo e publicado.  

### Fluxo de Eventos de Exceção  
- Erro no cadastro: O sistema não consegue salvar o questionário.  

**Requisitos Relacionados:**  
RF2  
RNF6  

**Classes:**  
Questionario, Administrador  

---


## Caso de Uso: Gerenciar Questionários

**Escopo:**  
Gestão de Questionários  

**Propósito:**  
Permitir que o administrador edite ou exclua questionários.  

**Ator:**  
Administrador  

**Pré-condições:**  
- O administrador deve estar autenticado.  

**Pós-condições:**  
- As alterações são aplicadas ao banco de dados.  

### Fluxo de Eventos Normal  
1. O administrador seleciona um questionário.  
2. O sistema exibe opções de edição ou exclusão.  
3. O administrador realiza as alterações.  
4. O sistema salva as mudanças.  

### Fluxo de Eventos de Exceção  
- Erro na atualização: O sistema não salva as mudanças.  

**Requisitos Relacionados:**  
RF2   
RNF6

**Classes:**  
Questionario, Administrador  

---

## Caso de Uso: Cadastrar Psicólogo

**Escopo:**  
Administração  

**Propósito:**  
Permitir que o administrador cadastre psicólogos no sistema.  

**Ator:**  
Administrador  

**Pré-condições:**  
- O administrador deve estar autenticado.  

**Pós-condições:**  
- O psicólogo pode acessar o sistema.  

### Fluxo de Eventos Normal  
1. O administrador insere dados do psicólogo.  
2. O sistema salva o novo cadastro.  

### Fluxo de Eventos de Exceção  
- Erro no cadastro: O sistema não salva os dados.  

**Requisitos Relacionados:**  
RF1  
RNF5 

**Classes:**  
Administrador, Psicologo, Usuario  

---

## Caso de Uso: Gerenciar Usuários

**Escopo:**  
Administração  

**Propósito:**  
Permitir que o administrador gerencie perfis de usuários.  

**Ator:**  
Administrador  

**Pré-condições:**  
- O administrador deve estar autenticado.  

**Pós-condições:**  
- Alterações em perfis de usuários são aplicadas.  

### Fluxo de Eventos Normal  
1. O administrador seleciona usuário.  
2. O sistema exibe informações de perfil.  
3. O administrador pode editar ou excluir.  

### Fluxo de Eventos de Exceção  
- Erro na atualização: O sistema não salva as alterações.  

**Requisitos Relacionados:**  
RF1  
RNF5

**Classes:**  
Administrador, Usuario  

---

## Caso de Uso: Responder Pesquisa

**Escopo:**  
Feedback e Pesquisa  

**Propósito:**  
Permitir que alunos e psicólogos respondam pesquisas de feedback.  

**Ator:**  
Aluno, Psicólogo  

**Pré-condições:**  
- Deve existir pesquisa ativa.  

**Pós-condições:**  
- As respostas são registradas no sistema.  

### Fluxo de Eventos Normal  
1. O usuário seleciona pesquisa disponível.  
2. O sistema apresenta perguntas.  
3. O usuário responde.  
4. O sistema salva as respostas.  

### Fluxo de Eventos de Exceção  
- Erro no salvamento: O sistema não salva as respostas.  

**Requisitos Relacionados:**  
RF7  
RNF1

**Classes:**  
PesquisaFeedback, Resposta  

---

## Caso de Uso: Registrar Pesquisa Feedback

**Escopo:**  
Feedback e Pesquisa  

**Propósito:**  
Permitir que o administrador registre pesquisas de feedback.  

**Ator:**  
Administrador  

**Pré-condições:**  
- O administrador deve estar autenticado.  

**Pós-condições:**  
- A pesquisa é disponibilizada para usuários.  

### Fluxo de Eventos Normal  
1. O administrador cadastra a pesquisa.  
2. O sistema disponibiliza a pesquisa.  

### Fluxo de Eventos de Exceção  
- Erro no cadastro: O sistema não salva a pesquisa.  

**Requisitos Relacionados:**  
RF7  
RNF6 

**Classes:**  
PesquisaFeedback, Administrador  

---

## Caso de Uso: Acessar Laudos

**Escopo:**  
Acompanhamento Psicológico  

**Propósito:**  
Permitir que o aluno acesse seus laudos gerados.  

**Ator:**  
Aluno  

**Pré-condições:**  
- O psicólogo deve ter gerado um laudo.  

**Pós-condições:**  
- O aluno pode visualizar ou baixar o laudo.  

### Fluxo de Eventos Normal  
1. O aluno acessa a seção de laudos.  
2. O sistema exibe os documentos disponíveis.  

### Fluxo de Eventos de Exceção  
- Nenhum laudo disponível: O sistema informa que não há laudos para o aluno.  

**Requisitos Relacionados:**  
RF4  
RNF1  

**Classes:**  
Laudo, Usuario  

---

## Caso de Uso: Realizar Consulta Virtual

**Escopo:**  
Acompanhamento Psicológico  

**Propósito:**  
Permitir que aluno e psicólogo realizem consultas online.  

**Ator:**  
Aluno, Psicólogo  

**Pré-condições:**  
- A consulta deve estar agendada.  

**Pós-condições:**  
- A consulta é realizada na sala virtual.  

### Fluxo de Eventos Normal  
1. O usuário acessa a sala no horário marcado.  
2. O sistema integra com Google Meet.  
3. A consulta é realizada.  

### Fluxo de Eventos de Exceção  
- Falha na conexão: A consulta não é iniciada corretamente.  

**Requisitos Relacionados:**  
RF6  
RNF3  

**Classes:**  
Consulta, Usuario, API_Google  

---

## Caso de Uso: Agendar Consulta

**Escopo:**  
Acompanhamento Psicológico  

**Propósito:**  
Permitir que aluno ou psicólogo agendem consultas.  

**Ator:**  
Aluno, Psicólogo  

**Pré-condições:**  
- Usuário deve estar autenticado.  

**Pós-condições:**  
- A consulta é registrada no calendário.  

### Fluxo de Eventos Normal  
1. O usuário acessa a agenda.  
2. O sistema exibe horários disponíveis.  
3. O usuário seleciona um horário.  
4. O sistema salva a consulta.  

### Fluxo de Eventos de Exceção  
- Conflito de agenda: O sistema informa que o horário está ocupado.  

**Requisitos Relacionados:**  
RF6  
RNF3  

**Classes:**  
Consulta, Usuario  

---

## Caso de Uso: Gerar Laudo PDF

**Escopo:**  
Acompanhamento Psicológico  

**Propósito:**  
Permitir que o psicólogo gere um laudo em formato PDF.  

**Ator:**  
Psicólogo  

**Pré-condições:**  
- O psicólogo deve ter analisado o aluno.  

**Pós-condições:**  
- Um laudo em PDF é gerado e salvo.  

### Fluxo de Eventos Normal  
1. O psicólogo acessa a função de gerar laudo.  
2. O sistema compila os resultados e gera PDF.  

### Fluxo de Eventos de Exceção  
- Erro na geração do PDF: O sistema não consegue gerar o arquivo.  

**Requisitos Relacionados:**  
RF5  
RNF3  

**Classes:**  
Psicologo, Laudo, GeradorPDF  
