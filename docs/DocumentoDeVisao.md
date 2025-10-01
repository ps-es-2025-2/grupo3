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

## Requisitos Não Funcionais

| Tipo           | Descrição                                                   | Prioridade |
| -------------- | ----------------------------------------------------------- | ---------- |
| Usabilidade    | Interface intuitiva para estudantes e psicólogos.           | 1          |
| Acessibilidade | Disponível em desktop, tablet e mobile.                     | 2          |
| Confiabilidade | Alta disponibilidade para consultas e testes.               | 1          |
| Desempenho     | Resposta rápida na navegação e carregamento.                | 1          |
| Segurança      | Conformidade LGPD, autenticação forte e proteção digital.   | 1          |
| Escalabilidade | Permitir evolução para novos perfis de testes e relatórios. | 2          |
