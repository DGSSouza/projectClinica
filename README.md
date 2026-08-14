# Medical Clinic API

A RESTful backend application for managing patients, doctors, and medical appointments, built with **Java** and **Spring Boot**.

The project was developed to demonstrate backend development concepts such as REST APIs, data persistence with JPA, validation, business rules, and automated testing.

---

## About the Project

The **Medical Clinic API** provides a backend solution for managing the main operations of a medical clinic.

The API currently supports:

* Patient management
* Doctor management
* Appointment scheduling
* Appointment filtering
* Appointment status management
* Data validation
* Persistence using an in-memory H2 database

The project uses an **in-memory database**, making it easy to run locally without requiring any external database configuration.

---

## Technologies

| Technology            | Purpose                         |
| --------------------- | ------------------------------- |
| **Java 21**           | Main programming language       |
| **Spring Boot 4.1.0** | Backend framework               |
| **Spring Web MVC**    | REST API development            |
| **Spring Data JPA**   | Data persistence                |
| **Spring Validation** | Request and data validation     |
| **H2 Database**       | In-memory database              |
| **Lombok**            | Boilerplate code reduction      |
| **Maven**             | Dependency and build management |
| **JUnit**             | Automated testing               |

---

## Features

### Patients

* Create patients
* Search patients
* Update patient information
* Delete patients

### Doctors

* Create doctors
* Search doctors
* Update doctor information
* Delete doctors

### Appointments

* Schedule appointments
* Search appointments
* Filter appointments by period
* Filter appointments by patient
* Update appointment status

---

## Project Structure

```text
programa/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/clinicamedica/programa/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── ProgramaApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/clinicamedica/programa/
│
└── README.md
```

### Architecture

The application follows a layered architecture:

* **Controller** — Handles HTTP requests and API endpoints.
* **Service** — Contains business rules and application logic.
* **Repository** — Responsible for data access through Spring Data JPA.
* **Model** — Contains the application's domain entities.

---

## Getting Started

### Prerequisites

Before running the application, make sure you have installed:

* **Java 21**
* **Git**

Maven does not need to be installed separately because the project includes the **Maven Wrapper**.

---

## Running the Application

### Windows

Open PowerShell in the project directory and run:

```powershell
.\mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

---

## Database

The application uses an **H2 in-memory database**.

### Connection

```text
JDBC URL: jdbc:h2:mem:clinica
Username: sa
Password:
```

### H2 Console

Once the application is running, the H2 console can be accessed at:

```text
http://localhost:8080/h2-console
```

Use the following credentials:

```text
JDBC URL: jdbc:h2:mem:clinica
Username: sa
Password:
```

> Since the database is configured as in-memory, its data is reset when the application is restarted.

---

## Running Tests

### Windows

```powershell
.\mvnw.cmd test
```

### Linux / macOS

```bash
./mvnw test
```

The project uses **JUnit** and **Spring Boot Test** for automated testing.

---

## API

The application exposes REST endpoints for the main clinic resources.

### Main resources

```text
/api/patients
/api/doctors
/api/appointments
```

The API follows REST principles and uses standard HTTP methods such as:

```text
GET     → Retrieve resources
POST    → Create resources
PUT     → Update resources
DELETE  → Delete resources
```

---

## Future Improvements

Possible improvements for future versions include:

* PostgreSQL or MySQL integration
* Authentication and authorization with Spring Security
* API documentation with Swagger / OpenAPI
* Docker support
* Global exception handling
* Pagination and sorting
* Improved test coverage
* Production database configuration

---

## Author

**Diego Gabriel**

---

## License

This project was developed for educational and portfolio purposes.
