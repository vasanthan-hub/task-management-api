# 🚀 Task Management API (Spring Boot)

## 📌 Overview

A RESTful API built using Spring Boot to manage tasks with CRUD operations.

---

## ✨ Features

* Create tasks
* Update tasks
* Delete tasks
* Search tasks
* Exception handling
* Swagger API documentation

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## ▶️ Run Locally

```bash
mvnw.cmd spring-boot:run
```

---

## 🔐 Configuration

Copy example config:

```bash
cp src/main/resources/application-example.properties src/main/resources/application-dev.properties
```

Update values before running.

---

## 📡 API Endpoints

| Method | Endpoint    |
| ------ | ----------- |
| GET    | /tasks      |
| POST   | /tasks      |
| PUT    | /tasks/{id} |
| DELETE | /tasks/{id} |

---

## 📄 Swagger UI

```
http://localhost:8080/swagger-ui.html
```

---

## 👨‍💻 Author

Vasanthan
