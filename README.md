# 🔐 API de Autenticação com JWT - Spring Boot

API REST desenvolvida com Java e Spring Boot, com foco em autenticação e autorização utilizando JWT (JSON Web Token). O projeto implementa controle de acesso por perfis (USER e ADMIN), criptografia de senha e documentação interativa com Swagger.

---

## 🚀 Funcionalidades

* Cadastro de usuários
* Login com geração de token JWT
* Criptografia de senha com BCrypt
* Proteção de rotas com autenticação
* Controle de acesso por perfil (USER / ADMIN)
* Documentação interativa com Swagger
* Banco de dados em memória (H2)

---

## 🧠 Regras de acesso

| Endpoint           | Acesso       |
| ------------------ | ------------ |
| POST /users        | Público      |
| POST /auth/login   | Público      |
| GET /users         | USER e ADMIN |
| DELETE /users/{id} | Apenas ADMIN |

---

## 🛠️ Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Security
* JWT (java-jwt)
* H2 Database
* Swagger (OpenAPI)
* Maven

---

## 🔐 Como funciona a autenticação

1. O usuário realiza login com email e senha
2. A API valida as credenciais
3. Um token JWT é gerado
4. O token deve ser enviado nas requisições protegidas via header:

```
Authorization: Bearer SEU_TOKEN
```

5. O sistema valida o token e libera o acesso conforme o perfil do usuário

---

## ▶️ Como rodar o projeto

### Pré-requisitos

* Java 17+
* Maven

---

### Executar

```bash
mvn spring-boot:run
```

---

## 🌐 Acessos

* Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

* Console do H2:

```
http://localhost:8080/h2-console
```

### Configuração do H2:

* JDBC URL: `jdbc:h2:mem:testdb`
* User: `sa`
* Password: (vazio)

---

## 🧪 Exemplos de uso

### 📌 Criar usuário

```json
{
  "nome": "Admin",
  "email": "admin@email.com",
  "senha": "123456",
  "role": "ADMIN"
}
```

---

### 🔑 Login

```json
{
  "email": "admin@email.com",
  "senha": "123456"
}
```

---

## 📦 Estrutura do projeto

```
controller/
service/
repository/
entity/
dto/
security/
config/
```

---

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido com foco em aprendizado e prática de conceitos essenciais de backend, como:

* autenticação e autorização
* segurança em APIs
* organização em camadas
* boas práticas com Spring Boot

---

## 📌 Possíveis melhorias

* Tratamento global de exceções
* Integração com banco de dados real (PostgreSQL)
* Deploy em ambiente cloud
* Testes automatizados

---

## 👩‍💻 Autora

Desenvolvido por Camille da Veiga
