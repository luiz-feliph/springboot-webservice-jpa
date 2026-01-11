# SpringBoot Webservice (JPA)

![Java](https://img.shields.io/badge/Java-21-ED8B00)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F)
![JPA](https://img.shields.io/badge/JPA-Hibernate-blue)
![Status](https://img.shields.io/badge/Project-Learning-informational)


A simple Spring Boot REST API built for learning and practice, demonstrating how to use Spring Data JPA and Hibernate to implement CRUD operations following common backend patterns.

## Table of Contents

- [About](#about)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Clone](#clone)
  - [Configuration](#configuration)
  - [Build & Run](#build--run)
- [API Examples](#api-examples)
- [Contact](#contact)

## About

This project is a Spring Boot REST API built to practice designing and implementing backend services with JPA and Hibernate. It exposes CRUD endpoints over a small domain model and demonstrates how entity relationships, composite keys, and layered architecture are handled in a typical RESTful application. The API is designed to reflect real-world patterns while remaining simple enough to support experimentation and learning.

## Features

- Spring Boot REST API
- Spring Data JPA repositories
- Hibernate as JPA provider
- H2 in-memory database for local development
- Profiles-friendly configuration to switch to PostgreSQL / MySQL
- Example controllers, DTOs, and basic validation

## Technologies

- Java 21 (SDK 21.0.8)
- Spring Boot (Web, Data JPA)
- Hibernate (JPA implementation)
- Maven
- H2 (in-memory) by default; compatible with PostgreSQL, MySQL, etc.

## Getting Started

### Prerequisites

- Java JDK 21
- Maven 3.6+
- Git

### Clone

```bash
git clone https://github.com/luiz-feliph/springboot-webservice-jpa.git
cd springboot-webservice-jpa
```

### Configuration

The project uses an in-memory H2 database for tests.
This configuration lives in `src/main/resources/application-test.properties`
and is activated when the `test` Spring profile is enabled.

The `src/main/resources/application.properties` file is intentionally minimal
and can be extended to configure a different database (e.g. PostgreSQL)
for local or production use.


Example `application.properties` for local H2:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

Example configuration for PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
spring.datasource.username=youruser
spring.datasource.password=yourpassword
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
```

### Build & Run

With Maven:

```bash
# build
mvn clean package

# run with Spring Boot plugin
mvn spring-boot:run
```

The application starts on http://localhost:8080 by default.

## API Examples

The API exposes RESTful endpoints organized by resource, following the pattern:
```bash 
http://localhost:8080/{resource}
```
Each resource represents a domain entity and supports standard CRUD operations.

Available resources include `users, orders, products, and categories`.

Example: Users resource (`/users`)

- GET /users — list all users
- GET /users/{id} — get user by id
- POST /users — create a new user
- PUT /users/{id} — update a user
- DELETE /users/{id} — delete a user

Example curl requests:

```bash
# List
curl -s http://localhost:8080/users

# Create
curl -X POST -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@example.com"}' \
  http://localhost:8080/users
```

## Database & Data Access

- Entity classes typically live under `src/main/java/com/luizfelipe/webservice/entities`.
- Repositories extend `org.springframework.data.jpa.repository.JpaRepository` and can be found under `src/main/java/com/luizfelipe/webservice/repositories`.

To inspect the H2 database when running locally, access the H2 console (if enabled) at:
http://localhost:8080/h2-console
JDBC URL (example): `jdbc:h2:mem:testdb`


## Contact

GitHub: [luiz-feliph](https://github.com/luiz-feliph)  
LinkedIn: [Luiz Felipe Santos](https://www.linkedin.com/in/luizfelipesm/)