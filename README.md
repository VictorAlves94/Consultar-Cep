📍 API de Consulta de CEP com Cadastro de Pessoa

Esta é uma API desenvolvida com Spring Boot que consome a API pública do ViaCEP para buscar informações de endereço a partir de um CEP e salvar os dados associados a uma pessoa no banco de dados.

O projeto demonstra o consumo de API externa, integração com banco de dados usando Spring Data JPA, e criação de endpoints RESTful.

🚀 Tecnologias utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Banco de dados (H2 / MySQL dependendo da configuração)

API externa ViaCEP

Maven

Git e GitHub

📡 API Externa utilizada

A aplicação consome dados da API pública:

https://viacep.com.br

Exemplo de requisição:

https://viacep.com.br/ws/01001000/json/
📦 Funcionalidades

✔ Cadastrar pessoa
✔ Buscar endereço automaticamente pelo CEP
✔ Buscar pessoa por ID
✔ Listar todas as pessoas
✔ Atualizar dados da pessoa
✔ Deletar pessoa
✔ Validação de CPF duplicado
✔ Tratamento de exceções

🗂 Estrutura do projeto
src
 ├── controller
 │    └── PessoaController
 │
 ├── service
 │    └── PessoaService
 │
 ├── repository
 │    └── PessoaRepository
 │
 ├── entity
 │    └── Pessoa
 │
 ├── dto
 │
 └── exception
🔎 Exemplo de Endpoint
Buscar pessoa por ID
GET /pessoas/{id}

Exemplo de resposta:

{
  "id": 1,
  "nome": "João Silva",
  "cpf": "12345678900",
  "cep": "01001000",
  "logradouro": "Praça da Sé",
  "cidade": "São Paulo",
  "estado": "SP"
}
⚙️ Como rodar o projeto
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git
2️⃣ Entrar na pasta
cd nome-do-projeto
3️⃣ Rodar o projeto

Se estiver usando Maven:

./mvnw spring-boot:run

ou rodar diretamente pela sua IDE (IntelliJ ou Eclipse).

🧠 Conceitos aplicados

Consumo de API externa

Arquitetura em camadas

REST API

Spring Data JPA

Tratamento de exceções

Validação de dados

Integração com banco de dados
