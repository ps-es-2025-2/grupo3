# Documento de Visão - Mind System

## Introdução

O software é um sistema de teste vocacional com o objetivo de auxiliar estudantes do ensino médio na escolha de suas carreiras. O projeto tem um viés psicológico, visando reduzir a evasão escolar e o estresse na vida dos alunos, através de questionários, relatórios e a interação com psicólogos.

---

## Análise de Contexto

### Descrição do Problema

Jovens no último ano do ensino médio frequentemente enfrentam altos níveis de estresse e distúrbios emocionais devido à pressão para a escolha profissional. Essa pressão, somada à falta de autoconhecimento e de informações sobre as carreiras, contribui para altos índices de evasão no ensino superior. Atualmente, muitos jovens não têm acesso a ferramentas de orientação vocacional de qualidade ou acompanhamento profissional, tornando o processo de decisão ainda mais difícil e incerto.

### Partes Afetadas

Os **estudantes** são as principais partes afetadas, sofrendo com a indecisão e a pressão. Psicólogos e instituições de ensino também são afetados, pois lidam com os desafios emocionais e o problema da evasão.

### Impacto

O problema tem um impacto direto na saúde mental e na qualidade de vida dos estudantes. Para a sociedade, os altos índices de evasão representam uma perda de potencial e um desperdício de recursos educacionais. Além disso, a falta de orientação pode levar a escolhas de carreira insatisfatórias, resultando em profissionais desmotivados e menos produtivos.

### Solução de Sucesso

Uma solução de sucesso deve oferecer aos estudantes ferramentas para o autoconhecimento, como questionários detalhados, e informações precisas sobre as profissões. A possibilidade de acompanhamento com psicólogos e a geração de laudos também são cruciais. O sistema deve ser fácil de usar, acessível em diversas plataformas e, acima de tudo, seguro e confiável para proteger os dados sensíveis dos usuários.

---

## Partes Interessadas

### Partes Interessadas

| Unidade | Representada Por | Envolvimento Com O Projeto |
|---|---|---|
| Equipe de Desenvolvimento | Membros do time | Desenvolvem o sistema, definem a arquitetura, implementam funcionalidades e garantem a segurança. |
| Psicólogos | Profissionais de psicologia | Utilizam o sistema para acompanhar os estudantes, analisar resultados de testes e fornecer orientação. |
| Estudantes do Ensino Médio | Alunos | Usuários finais que utilizam a plataforma para fazer os testes e receber orientações. |
| Equipe de Administração| Administrador | Cadastra Psicólogos, registra questionário de feedback e cadastra os questionários |

### Usuários

1.
| Tipo de Usuário | Aluno |
|---|---|
| Representante | Estudante do Ensino Médio |
| Descrição | Estudante que busca orientação para a escolha de sua futura carreira. |
| Responsabilidades | Responder questionários, agendar sessões com psicólogos e acompanhar seu progresso. |

2.
| Tipo de Usuário | Psicólogo |
|---|---|
| Representante | Profissional de Psicologia |
| Descrição | Profissional responsável por analisar os resultados dos testes e auxiliar o estudante em sua jornada de autoconhecimento. |
| Responsabilidades | Acessar resultados, criar laudos, gerar PDFs e realizar sessões de aconselhamento. |

3.
| Tipo de Usuário | Administrador |
|---|---|
| Representante | Equipe do Produto |
| Descrição | Usuário responsável pela gestão do sistema, incluindo a criação de questionários e a análise de dados. |
| Responsabilidades | Gerenciar conteúdos, coletar feedbacks e garantir o funcionamento correto do sistema. |

---

## Objetivos do Negócio

| Objetivo do Negócio | Descrição |
|---|---|
| Redução da Evasão | Ajudar estudantes a fazerem escolhas mais conscientes, diminuindo a taxa de evasão no ensino superior. |
| Melhoria da Saúde Mental | Fornecer uma ferramenta de apoio para diminuir o estresse e a ansiedade relacionados à escolha profissional. |
| Escala de Conhecimento | Centralizar a oferta de orientação vocacional, tornando-a acessível a um público mais amplo. |
| Valor Agregado | Coletar dados para futuras análises de perfis comportamentais e oferecer insights sobre o mercado de trabalho. |

---

## Visão Geral do Produto

### Perspectiva do Produto

O produto é uma aplicação web progressiva (PWA), o que significa que se comporta como um aplicativo nativo, mas pode ser acessado diretamente do navegador em qualquer dispositivo (desktop, tablet, celular), sem a necessidade de instalação. Ele se conecta a APIs externas, como a do **Google Meet** para as sessões com psicólogos. O sistema deve seguir rigorosamente as diretrizes da **LGPD** para garantir a privacidade e a segurança dos dados dos usuários.

### Características chaves do produto

| Característica-chave | Descrição | Prioridade |
|---|---|---|
| Cadastro e Autenticação | Registro de diferentes perfis de usuário (Aluno, Psicólogo, Administrador) e login seguro. | 1 |
| Questionários Vocacionais | Sistema de questionários com perguntas de diferentes áreas para o aluno responder. | 1 |
| Dashboard do Aluno | Visualização do progresso nas atividades e do resultado dos testes. | 2 |
| Acompanhamento por Psicólogo | Acesso do Psicólogo aos resultados do Aluno e ao seu progresso. | 1 |
| Geração de Laudos | Psicólogos podem gerar laudos de avaliação em formato PDF. | 2 |
| Integração com Google Meet | Criação de salas virtuais para sessões entre Aluno e Psicólogo. | 1 |
| Coleta de Feedback | Questionários de pesquisa para a equipe de desenvolvimento. | 3 |
| Proteção de Dados (LGPD) | Implementação de medidas de segurança e transparência no tratamento de dados. | 1 |
| Segurança (reCAPTCHA e DDoS) | Medidas de segurança digital para proteger o sistema contra bots e ataques. | 2 |

---

### Requisitos Não Funcionais

| Tipo | Descrição | Prioridade |
|---|---|---|
| Usabilidade | A interface deve ser intuitiva e fácil de usar para todos os tipos de usuário, especialmente os estudantes, que devem conseguir navegar sem dificuldades. | 1 |
| Acessibilidade | O sistema deve ser acessível para diferentes dispositivos (PWA) e para usuários com possíveis limitações. | 2 |
| Confiabilidade | O sistema deve estar sempre disponível, garantindo a realização dos testes e a comunicação entre usuários. | 1 |
| Desempenho | O sistema deve carregar rapidamente e ser responsivo, sem lentidão, garantindo uma boa experiência de usuário. | 1 |
| Segurança | Por lidar com dados sensíveis, a segurança é uma prioridade máxima. Autenticação, proteção contra ataques (DDoS, bots) e conformidade com a LGPD são essenciais. | 1 |
| Escalabilidade | O sistema deve ser projetado para permitir a expansão futura, como a adição de novos perfis de teste ou a coleta de dados para pesquisa. | 2 |
