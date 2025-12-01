# Documento de Visão - Mind System

## Equipe
| Aluno | GitHub | Cargo |
|-------------|-------------|-------------|
|Gustavo Rodrigues Ribeiro | GustavooRibas | Arquiteto de Software (AS) e Desenvolvedor Backend (DB)
|Murillo Gordo de Andrade | murilloandrade | Testador (TT)
|Felipe Alves Leão de Araújo| FelipeAlvesLeao | Analista de Requisitos (AR) e Desenvolvedor Frontend (DF)

## Introdução

O Mind System é um sistema de orientação vocacional e acompanhamento psicológico voltado para estudantes do ensino médio. Ele surge como resposta à crescente necessidade de ferramentas que auxiliem jovens em um dos momentos mais desafiadores da vida escolar: a escolha de uma carreira profissional.

Além de oferecer testes vocacionais estruturados, o sistema integra funcionalidades como acompanhamento com psicólogos, relatórios de progresso, consultas virtuais e geração de laudos profissionais. Essa combinação promove não apenas a orientação de carreira, mas também o cuidado com a saúde mental dos alunos, reduzindo a ansiedade e o risco de evasão escolar.

O software foi concebido como uma plataforma digital acessível, intuitiva e segura, pautada pela Lei Geral de Proteção de Dados (LGPD). Dessa forma, busca-se democratizar o acesso à orientação vocacional de qualidade, tornando-a escalável e adaptada às necessidades contemporâneas.

---

## Análise de Contexto

### Descrição do Problema

Estudantes do ensino médio, especialmente no último ano, enfrentam pressão acadêmica e social* para definir sua trajetória profissional. Essa decisão precoce, quando tomada sem autoconhecimento e sem informações adequadas, leva a:

* altos níveis de estresse e ansiedade;
* escolhas de carreira inconsistentes com as aptidões pessoais;
* desistências e evasão em cursos superiores;
* frustrações pessoais e profissionais.

Hoje, faltam soluções integradas que combinem apoio vocacional, acompanhamento psicológico e tecnologia acessível. Muitas instituições ainda utilizam métodos manuais e pouco interativos, dificultando a escala e o engajamento dos alunos.

### Partes Afetadas

* **Estudantes**: principais impactados pela indecisão, ansiedade e falta de informações.
* **Psicólogos**: carecem de ferramentas digitais que organizem testes, consultas e laudos.
* **Instituições de ensino**: sofrem com índices elevados de evasão, perda de capital humano e desperdício de investimentos educacionais.
* **Famílias**: acompanham a pressão emocional dos jovens e muitas vezes não sabem como apoiá-los.

### Impacto

* **Indivíduo**: maior clareza nas escolhas, redução do estresse e fortalecimento do autoconhecimento.
* **Educação**: queda nos índices de evasão e maior engajamento acadêmico.
* **Sociedade**: desenvolvimento de profissionais mais motivados, produtivos e alinhados às demandas do mercado.

### Solução de Sucesso

Uma solução eficaz deve:

* Oferecer testes vocacionais estruturados e interativos com questionários e relatórios que promovam o autoconhecimento;
* Proporcionar consultas online com psicólogos, permitindo o acompanhamento individualizado com psicólogos, incluindo consultas virtuais e geração de laudos;
* Permitir visualização clara do progresso do aluno;
* Disponibilizar laudos técnicos em PDF;
* Suporte a múltiplos perfis de usuário (Aluno, Psicólogo, Administrador).
* Ser acessível (PWA) e segura (LGPD, autenticação robusta);
* Apoiar a gestão institucional, fornecendo dados e relatórios úteis para escolas e psicólogos.

---

## Partes Interessadas

| Unidade                    | Representada Por                            | Envolvimento no Projeto                                                                                                         |
| -------------------------- | ------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| Equipe de Desenvolvimento  | Desenvolvedores, arquitetos e QA            | Definem a arquitetura, implementam funcionalidades, realizam testes e garantem segurança.                                       |
| Psicólogos                 | Profissionais de psicologia                 | Acompanham os estudantes, aplicam metodologias vocacionais, geram laudos e realizam consultas.                                  |
| Estudantes                 | Alunos do Ensino Médio                     | Usuários finais que utilizam a plataforma para se autoconhecer, responder questionários e acessar orientação profissional.      |
| Equipe de Administração    | Administradores do sistema                  | Responsáveis por cadastrar psicólogos, gerenciar questionários, registrar pesquisas de feedback e monitorar a saúde do sistema. |
| Instituições de Ensino     | Escolas, faculdades e centros de orientação | Parceiros que podem adotar o sistema como ferramenta institucional para reduzir evasão e apoiar estudantes.                     |
| Famílias                   | Pais e responsáveis                         | Interessados indiretos nos resultados, já que acompanham o impacto emocional e as decisões de carreira dos estudantes.          |

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

| Objetivo                                    | Descrição                                                                            |
| ------------------------------------------- | ------------------------------------------------------------------------------------ |
| **Reduzir a evasão escolar**                | Apoiar escolhas conscientes de carreira, diminuindo desistências no ensino superior. |
| **Promover saúde mental**                   | Fornecer suporte psicológico para reduzir estresse e ansiedade.                      |
| **Ampliar acesso à orientação vocacional**  | Disponibilizar uma plataforma digital inclusiva e escalável.                         |
| **Fornecer valor agregado às instituições** | Oferecer dados estratégicos sobre perfis de alunos, evolução e riscos de evasão.     |
| **Garantir segurança e confiabilidade**     | Manter conformidade com a LGPD e aplicar boas práticas de cibersegurança.            |
| **Estimular inovação pedagógica**           | Integrar psicologia, educação e tecnologia em um único ecossistema digital.          |

---

## Visão Geral do Produto

### Perspectiva

O Mind System é uma plataforma digital de orientação vocacional e acompanhamento psicológico que combina:

* **Aplicação web progressiva (PWA)**, acessível em múltiplos dispositivos;
* **Integração com APIs externas**, como Google Meet para consultas virtuais;
* **Conformidade com LGPD**, incluindo consentimento de uso de dados pessoais;
* **Arquitetura escalável**, preparada para evolução com novos recursos e perfis de usuário.

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
