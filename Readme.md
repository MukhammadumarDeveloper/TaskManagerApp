# Task Manager App

## Description
This is our internship project for Epam Summer Camp 2024. For the backend we used Spring Boot with a PostgreSQL database.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Backend Configuration](#backend-configuration)
- [Frontend Configuration](#frontend-configuration)

## Installation

### Prerequisites
- Node.js
- npm (Node Package Manager)
- Java Development Kit (JDK)
- PostgreSQL

### Backend Setup
1. Clone the repository:
    ```bash
    git clone <repository_url>
    ```
2. Navigate to the backend directory:
    ```bash
    cd backend
    ```
3. Configure your database connection in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5433/task_manager
    spring.datasource.username=postgres
    spring.datasource.password=000000
    spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true

    server.port=8083
    ```
4. Run the backend application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend Setup
1. Navigate to the frontend directory:
    ```bash
    cd frontend
    ```
2. Install dependencies:
    ```bash
    npm install
    ```

## Usage

### Development
To start the development server with hot reloading:
```bash
npm run serve
