# PT_Demo_SpringBoot

PT_Demo_SpringBoot

## Contents
- [Setup](#setup)
    - [Initial Setup](#initial-setup)
    - [Codebase Implementation](#codebase-implementation)
    - [Run the Application](#run-the-application)

## Setup
### Initial Setup

1. Go to [Spring Initializr](https://start.spring.io/).
2. Set the following options:
- Project: `Maven`
- Language: `Java`
- Spring Boot Version: `3.1.4`
- Group: `com.petartotev`
- Artifact: `studentboot`
- Name: `studentboot`
- Description: `Some description...`
- Package Name: `com.petartotev.studentboot`
- Packaging: `Jar`
- Java Version: `17`
- Add Dependencies:
  - `Spring Web` - for building the REST API.
  - `Spring Boot DevTools` - for auto-reloading during development.
  - `Spring Boot Validation` - for request validation.
3. Click Generate to download the ZIP file.
![setup-1](./res/setup-1.jpg)
4. Import the Project in IntelliJ IDEA:
- Unzip the file you downloaded.
- Open IntelliJ IDEA.
- Go to `File` > `New` > `Project from Existing Sources`.
- Navigate to the unzipped folder and select the `pom.xml` file.
![setup-2](./res/setup-2.jpg)
- IntelliJ will load the project and download dependencies.

### Codebase Implementation

1. In `studentboot/src/main/java/com.petartotev.studentboot`:
- create package `model` and implement model `Student.java`.
- create package `repository` and implement `StudentRepository.java`.
- create package `controller` and implement `StudentController.java`.
2. In `studentboot/src/main/resources/application.properties`, add port configuration (optional):
```
server.port=8080
```

### Run the Application

1. Open `studentboot/src/main/java/com.petartotev.studentboot/StudentbootApplication`:
2. Run the main() method to start the application.
3. Now API should be available on http://localhost:8080/api/students. 
