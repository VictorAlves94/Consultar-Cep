API REST desenvolvida em Spring Boot para cadastro de pessoas e consulta de endereços através de CEP utilizando uma API externa (ViaCEP).
A aplicação armazena dados em MySQL e retorna informações completas de endereço a partir do CEP informado.


🚀 Tecnologias Utilizadas


Java

Spring Boot

Spring Data JPA

MySQL

Maven

API ViaCEP

Jackson (JSON)


📂 Estrutura do Projeto


src/main/java
 └── com.apiexterna.consumindo.uma.api.externa.via.cep
     ├── dto
     │    └── CepDto
     ├── entity
     │    └── Pessoa
     ├── repository
     │    └── PessoaRepository
     ├── service
     │    └── PessoaService
     └── resource
          └── PessoaResource

          
          
⚙️ Configuração do Banco de Dados


Arquivo application.properties

spring.jpa.database=MYSQL
spring.datasource.url=jdbc:mysql://localhost/testcep?createDatabaseIfNotExist=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

spring.jackson.deserialization.fail-on-unknown-properties=true
spring.jackson.date-format=yyyy-MM-dd
🗄 Estrutura da Tabela
CREATE TABLE pessoa(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(15) NOT NULL,
cep VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Exemplo de inserção:

INSERT INTO pessoa(nome,cpf,cep)
VALUES ("victor", "04996072105", "71800000");


🔗 Endpoints da API
Criar Pessoa

POST

/pessoa

Exemplo de JSON:

{
 "nome": "Victor",
 "cpf": "04996072105",
 "cep": "71800000"
}
Buscar Pessoa por ID

GET

/pessoa/{id}
Atualizar Pessoa

PUT

/pessoa/{id}
Consultar CEP

GET

/pessoa/cep/{cep}

Exemplo:

/pessoa/cep/71800000

Retorna dados do endereço obtidos pela API externa.



▶️ Como Executar o Projeto

Clone o repositório

git clone URL_DO_REPOSITORIO

Acesse a pasta do projeto

cd nome-do-projeto

Execute a aplicação

mvn spring-boot:run

A API iniciará em:

http://localhost:8080


📌 Funcionalidades

Cadastro de pessoas

Consulta de pessoa por ID

Atualização de dados

Consulta de endereço por CEP

Integração com API externa

Persistência em banco MySQL
