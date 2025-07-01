
# RabbitMQ Context

Este projeto é uma aplicação simples que aplica o contexto de menssageria RabbitMQ juntamente com MongoDB. A aplicação é respopnsável por realizar ações no banco e disparar nos logs as menssagens do que esta sendo feito seguindo os princípios do RabbitMQ.

## Funcionalidades

- **API**: Cria uma API com metodos HTTP.
- **Menssageria RabbitMQ**: Gerencia nos logs da aplicação as ações realizadas.
- **Armazenamento**: Cria uma instacia do banco MongoDB para realizar ações que disparam menssagens.

## Tecnologias Utilizadas

| Tecnologia       | Descrição                                     |
|------------------|-----------------------------------------------|
| Spring Boot      | Framework principal da aplicação              |
| JPA              | Persistência de dados                         |
| MongoDB          | Banco de dados relacional                     |
| RabbitMQ         | Menssageria da API que registra ações via log |

## Instruções de Execução

### 1. **Clonar o Repositório**
Primeiro, clone o repositório para o seu ambiente local:
   ```bash
   git clone https://github.com/seu-usuario/RabbitMQ-Context.git
   ```

### 2. **Configuração do Projeto**
- **Banco de Dados**: O projeto usa o banco de dados **MongoDB**, sendo necessário a adição da dependencia no `pom.xml`.
  ```xml
    <dependency>
      <groupId>org.mongodb</groupId>
      <artifactId>mongodb-driver-sync</artifactId>
      <version>YOUR_VERSION</version>
    </dependency>
   ```

- **Configuração do Spring Boot**: As configurações para acesso ao banco estão definidas em **`application.properties`**. A configuração do banco de dados deve ser editada conforme os dados do seu banco.
  ```properties
    spring.application.name=api
  
    spring.dat.mongodb.authentications-database=admin
    spring.dat.mongodb.auto-index-creation=true
    spring.dat.mongodb.host=localhost
    spring.dat.mongodb.port=27017
    spring.dat.mongodb.database=seu_database
    spring.dat.mongodb.username=seu_usuario
    spring.dat.mongodb.password=sua_senha
  ```

- **Configuração do container Docker**: As configurações de container do MongoDB e do RabbitMQ estão definidas em **`docker-compose.yml`**. A configuração do docker deve ser editada conforme os dados do seu container.
  ```yml
  services:
    mongodb:
      image: mongo
      ports:
        - 27017:27017
      environment:
        - MONGO_INITDB_ROOT_USERNAME=admin
        - MONGO_INITDB_ROOT_PASSWORD=123

    rabbitmq:
      image: rabbitmq:3.13-management
      ports:
        - 15672:15672
        - 5672:5672

  ```

### 3. **Executar a Aplicação**
Se você estiver usando **Maven**, execute o seguinte comando para rodar a aplicação:
   ```bash
   mvn spring-boot:run
   ```

Ou, se estiver utilizando **IntelliJ** ou **Eclipse**, basta clicar em **Run** para iniciar o servidor.
