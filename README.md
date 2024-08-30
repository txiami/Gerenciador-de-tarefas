# Gerenciador de Tarefas

Este é um projeto de uma API RESTful desenvolvida com Spring Boot para gerenciar tarefas. A aplicação utiliza um banco de dados H2 em memória e é configurada para rodar com Java 21.

## Pré-requisitos

- [Java 21](https://jdk.java.net/21/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou ide de sua preferência com o maven
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)

## Como iniciar o projeto no IntelliJ IDEA

### 1. Clone o repositório

Abra o terminal do IntelliJ IDEA e execute:

```bash
git clone https://github.com/seu-usuario/gerenciador-tarefas.git
cd gerenciador-tarefas

```
### 2. Importar o projeto no IntelliJ IDEA
No IntelliJ IDEA, selecione File > Open.
Navegue até o diretório onde você clonou o repositório e selecione a pasta do projeto.
Clique em OK e o IntelliJ IDEA irá reconhecer o projeto como um projeto Maven e importar as dependências automaticamente.
### 3. Configuração do ambiente
O projeto já está configurado para usar um banco de dados H2 em memória, sem necessidade de configuração adicional. No arquivo application.properties, as propriedades são:

```bash
spring.application.name=gerenciador-tarefas
spring.datasource.url=jdbc:h2:mem:tarefasdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```
### 4. Compilando e rodando a aplicação
No IntelliJ IDEA, abra o arquivo GerenciadorTarefasApplication.java localizado em src/main/java/com/api/gerenciadortarefas/.
Clique com o botão direito no arquivo e selecione Run 'GerenciadorTarefasApplication'.
Isso irá iniciar o servidor embutido do Spring Boot (Tomcat) na porta 8080 por padrão.
### 5. Acessando o H2 Console
Para acessar o console do banco de dados H2, use a URL abaixo após iniciar a aplicação:


http://localhost:8080/h2-console

As configurações padrão para acesso são:

JDBC URL: jdbc:h2:mem:tarefasdb

User Name: sa

Password: (deixe em branco)

### 6. Testando a API
Após iniciar a aplicação, você pode testar os endpoints usando ferramentas como Postman ou cURL.

Exemplos de endpoints disponíveis:

GET http://localhost:8080/tarefas - Retorna todas as tarefas

GET http://localhost:8080/tarefas/{id} - Retorna uma tarefa específica por ID

POST http://localhost:8080/tarefas - Cria uma nova tarefa

```bash
{
    "titulo": "teste",
    "descricao": "teste"
}
```

PUT http://localhost:8080/tarefas/{id} - Atualiza uma tarefa existente

```bash
{
    "titulo": "teste",
    "descricao": "teste"
}
```
DELETE http://localhost:8080/tarefas/{id} - Deleta uma tarefa existente
