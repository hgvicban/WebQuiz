# Web Quiz Engine (Java) - Backend Development

## Overview

Welcome to the Web Quiz Engine project, a Java-based backend application designed to provide a robust and scalable platform for creating, solving, and managing quizzes.

## Features

- **Spring Boot Framework**: Harness the power of Spring Boot for rapid development and deployment of Java-based applications.
- **`TODO` Security and Authentication**: Implement secure user account management with features such as registration and login functionalities.
- **Database Integration with Hibernate**: Utilize Hibernate for seamless interaction with databases, ensuring efficient data storage and retrieval.
- **RESTful API Architecture**: Design and implement a RESTful API, enabling easy integration with frontend applications and other systems.
- **Dynamic Quiz Creation**: Leverage Java's flexibility to create quizzes with various multiple-choice questions and customizable options.
- **Interactive Quiz Solving with Immediate Feedback**: Enhance user engagement by providing immediate feedback on quiz solutions.

## Getting Started

### Prerequisites

- **Java 11 or later**
- **Gradle**
- **Spring Boot**

### Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-username/web-quiz-engine.git
   ```

2. **Navigate to the Project Directory**:

   ```bash
   cd web-quiz-engine
   ```

3. **Build with Gradle**:

   ```bash
   ./gradlew build
   ```

4. **Run the Application**:

   ```bash
   java -jar build/libs/web-quiz-engine.jar
   ```

   Access the application at `http://localhost:8080`.

## API Documentation

### User Authentication

#### `TODO` Endpoint: `/api/register`

- **Method**: `POST`
- **Description**: Register a new user.
- **Request Body**:
  - `email` (string): User's email address.
  - `password` (string): User's password.
- **Response**:
  - `200 OK`: User successfully registered.
  - `400 Bad Request`: Invalid request body.
  - `403 Forbidden`: User with the provided email already exists.

#### `TODO` Endpoint: `/api/login`

- **Method**: `POST`
- **Description**: Log in a user.
- **Request Body**:
  - `email` (string): User's email address.
  - `password` (string): User's password.
- **Response**:
  - `200 OK`: User successfully logged in.
  - `400 Bad Request`: Invalid request body.
  - `401 Unauthorized`: Invalid credentials.

### Quiz Management

#### Endpoint: `/api/quizzes`

- **Method**: `POST`
- **Description**: Create a new quiz.
- **Request Body**:
  - `title` (string): Title of the quiz.
  - `text` (string): Text of the quiz.
  - `options` (array of strings): List of answer options.
  - `answer` (number): Index of the correct answer in the `options` array.
- **Response**:
  - `200 OK`: Quiz successfully created.
  - `400 Bad Request`: Invalid request body.

#### Endpoint: `/api/quizzes/{id}`

- **Method**: `GET`
- **Description**: Get details of a specific quiz by its ID.
- **Response**:
  - `200 OK`: Quiz details successfully retrieved.
  - `404 Not Found`: Quiz with the specified ID not found.

#### Endpoint: `/api/quizzes`

- **Method**: `GET`
- **Description**: Get a paginated list of all quizzes.
- **Parameters**:
  - `page` (integer, optional): Page number for pagination.
  - `pageSize` (integer, optional): Number of quizzes per page.
- **Response**:
  - `200 OK`: List of quizzes successfully retrieved.

#### Endpoint: `/api/quizzes/{id}/solve`

- **Method**: `POST`
- **Description**: Solve a specific quiz by its ID.
- **Request Body**:
  - `answer` (number): Index of the chosen answer.
- **Response**:
  - `200 OK`: Quiz solved successfully.
  - `400 Bad Request`: Invalid request body.
  - `404 Not Found`: Quiz with the specified ID not found.

### User Dashboard

#### `TODO` Endpoint: `/api/quizzes/completed`

- **Method**: `GET`
- **Description**: Get a paginated list of completed quizzes by the current user.
- **Parameters**:
  - `page` (integer, optional): Page number for pagination.
  - `pageSize` (integer, optional): Number of quizzes per page.
- **Response**:
  - `200 OK`: List of completed quizzes successfully retrieved.


## Acknowledgments

- Developed as part of the [Hyperskill Java Developer](https://hyperskill.org/tracks/1) track.
