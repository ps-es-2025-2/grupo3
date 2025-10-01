# Documento de Visão - Mind System

## Introdução

O **Mind System** é um sistema de apoio psicológico e vocacional com o objetivo de auxiliar estudantes do ensino médio na escolha de suas carreiras. O projeto tem um viés psicológico, visando reduzir a evasão escolar e o estresse na vida dos alunos, através de **questionários, relatórios, consultas virtuais e acompanhamento com psicólogos**.

Além da orientação vocacional, o sistema contempla **gestão de usuários, pesquisas de feedback e conformidade com a LGPD**, garantindo privacidade e segurança dos dados.

---

## Análise de Contexto

### Descrição do Problema

Jovens no ensino médio enfrentam altos níveis de estresse e indecisão devido à escolha profissional. A ausência de ferramentas adequadas de orientação e acompanhamento psicológico intensifica esse cenário, aumentando os índices de evasão escolar e insatisfação futura com a carreira escolhida.

### Partes Afetadas

* **Estudantes**: enfrentam estresse e incerteza sobre o futuro.
* **Psicólogos**: lidam com a demanda por orientação individualizada e precisam de ferramentas para organizar atendimentos.
* **Instituições de ensino**: impactadas pelos altos índices de evasão e queda no desempenho dos alunos.

### Impacto

* **Pessoal**: melhora da saúde mental e da segurança nas escolhas de carreira dos estudantes.
* **Educacional**: redução da evasão no ensino superior.
* **Social**: diminuição de profissionais desmotivados e pouco produtivos.

### Solução de Sucesso

* Questionários e relatórios que promovam o autoconhecimento.
* Acompanhamento individualizado com psicólogos, incluindo consultas virtuais e geração de laudos.
* Suporte a múltiplos perfis de usuário (Aluno, Psicólogo, Administrador).
* Conformidade com a **LGPD** e integração com o **Google Meet**.

---

## Partes Interessadas

| Unidade                   | Representada Por            | Envolvimento                                                                            |
| ------------------------- | --------------------------- | --------------------------------------------------------------------------------------- |
| Equipe de Desenvolvimento | Time técnico                | Define arquitetura, implementa funcionalidades e assegura segurança.                    |
| Psicólogos                | Profissionais de Psicologia | Realizam consultas, analisam alunos e geram laudos.                                     |
| Estudantes                | Alunos do Ensino Médio      | Usuários finais, respondem questionários, recebem laudos e participam de consultas.     |
| Administração             | Administrador               | Gerencia usuários, psicólogos e questionários, além de registrar pesquisas de feedback. |

---

## Usuários

1. **Aluno**

   * **Descrição**: Estudante que busca orientação de carreira.
   * **Responsabilidades**: Responder questionários, visualizar progresso, acessar laudos, agendar e participar de consultas, responder pesquisas de feedback.

2. **Psicólogo**

   * **Descrição**: Profissional de psicologia que acompanha alunos.
   * **Responsabilidades**: Agendar e realizar consultas virtuais, analisar alunos, gerar laudos em PDF, acessar registros e responder pesquisas de feedback.

3. **Administrador**

   * **Descrição**: Usuário responsável pela gestão do sistema.
   * **Responsabilidades**: Cadastrar e gerenciar usuários e psicólogos, criar e gerenciar questionários, registrar pesquisas de feedback.

---

## Objetivos do Negócio

| Objetivo                          | Descrição                                                         |
| --------------------------------- | ----------------------------------------------------------------- |
| Reduzir a evasão escolar          | Orientar os alunos em escolhas conscientes de carreira.           |
| Melhorar a saúde mental           | Apoiar o equilíbrio emocional dos estudantes com psicólogos.      |
| Centralizar orientação vocacional | Disponibilizar uma plataforma digital acessível e integrada.      |
| Agregar valor para instituições   | Disponibilizar dados analíticos de perfil e progresso dos alunos. |

---

## Visão Geral do Produto

### Perspectiva

O produto será uma **aplicação web progressiva (PWA)**, acessível em múltiplos dispositivos.
Integrações externas: **API Google Meet** (consultas virtuais).
Segurança: **LGPD** como base para consentimento e controle de dados.

### Características Chave

| Característica                 | Descrição                                                                                   | Prioridade |
| ------------------------------ | ------------------------------------------------------------------------------------------- | ---------- |
| **Autenticação Segura**        | Cadastro, login, login social (Gmail), atualização de dados e consentimento LGPD.           | 1          |
| **Gestão de Questionários**    | Visualizar, responder e acompanhar progresso; cadastro e gerenciamento por administradores. | 1          |
| **Acompanhamento Psicológico** | Consultas virtuais (Google Meet), geração e acesso a laudos PDF, agendamento de consultas.  | 1          |
| **Administração**              | Cadastro de psicólogos, gerenciamento de usuários e questionários.                          | 2          |
| **Feedback e Pesquisa**        | Registro de pesquisas pelo administrador e resposta de feedback por alunos e psicólogos.    | 3          |
| **LGPD**                       | Consentimento e controle de acesso a dados pessoais.                                        | 1          |
| **Segurança Avançada**         | Proteção contra bots e ataques DDoS.                                                        | 2          |

---

## Requisitos Funcionais

| ID  | Requisito Funcional                                                                                         | Casos de Uso Relacionados                                                                                                  |
| --- | ----------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| RF1 | O sistema deve permitir cadastro, autenticação (credenciais e login social) e gerenciamento de usuários.    | Realizar Cadastro, Realizar Login, Login Social (Gmail), Atualizar Dados Pessoais, Cadastrar Psicólogo, Gerenciar Usuários |
| RF2 | O sistema deve disponibilizar questionários para alunos, permitindo visualização, resposta e gerenciamento. | Visualizar Questionários, Responder Questionário, Visualizar Progresso, Cadastrar Questionário, Gerenciar Questionários    |
| RF3 | O sistema deve permitir ao aluno acompanhar seu progresso.                                                  | Visualizar Progresso                                                                                                       |
| RF4 | O sistema deve disponibilizar laudos psicológicos para os alunos.                                           | Acessar Laudos                                                                                                             |
| RF5 | O sistema deve permitir que psicólogos gerem laudos em PDF.                                                 | Gerar Laudo PDF                                                                                                            |
| RF6 | O sistema deve permitir o agendamento e realização de consultas virtuais.                                   | Agendar Consulta, Realizar Consulta Virtual                                                                                |
| RF7 | O sistema deve permitir a coleta de feedback por meio de pesquisas.                                         | Responder Pesquisa, Registrar Pesquisa Feedback                                                                            |
| RF8 | O sistema deve garantir o consentimento do usuário segundo a LGPD.                                          | Consentir Dados, Acessar Dados Pessoais                                                                                    |

---

## Requisitos Não Funcionais

| ID   | Requisito Não Funcional                                                                           | Casos de Uso Relacionados                                                               |
| ---- | ------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| RNF1 | O sistema deve apresentar interface intuitiva e fácil de usar.                                    | Todos os casos de uso de interação direta (ex.: Responder Questionário, Acessar Laudos) |
| RNF2 | O sistema deve ser acessível em diferentes dispositivos (PWA).                                    | Todos os casos de uso                                                                   |
| RNF3 | O sistema deve garantir disponibilidade e estabilidade para consultas online e geração de laudos. | Realizar Consulta Virtual, Agendar Consulta, Gerar Laudo PDF                            |
| RNF4 | O sistema deve carregar rapidamente, com respostas em tempo real.                                 | Questionários, Consultas, Dashboard                                                     |
| RNF5 | O sistema deve implementar autenticação segura e gestão confiável de usuários.                    | Realizar Login, Realizar Cadastro, Gerenciar Usuários                                   |
| RNF6 | O sistema deve permitir expansão para novos questionários, pesquisas e relatórios.                | Cadastrar Questionário, Gerenciar Questionários, Registrar Pesquisa Feedback            |

---

## Matriz de Rastreabilidade (RF ↔ Casos de Uso)

| Caso de Uso                 | RFs Relacionados |
| --------------------------- | ---------------- |
| Realizar Cadastro           | RF1, RF8         |
| Realizar Login              | RF1              |
| Login Social (Gmail)        | RF1              |
| Atualizar Dados Pessoais    | RF1              |
| Visualizar Questionários    | RF2              |
| Responder Questionário      | RF2              |
| Visualizar Progresso        | RF2, RF3         |
| Cadastrar Questionário      | RF2              |
| Gerenciar Questionários     | RF2              |
| Cadastrar Psicólogo         | RF1              |
| Gerenciar Usuários          | RF1              |
| Responder Pesquisa          | RF7              |
| Registrar Pesquisa Feedback | RF7              |
| Acessar Laudos              | RF4              |
| Gerar Laudo PDF             | RF5              |
| Agendar Consulta            | RF6              |
| Realizar Consulta Virtual   | RF6              |
