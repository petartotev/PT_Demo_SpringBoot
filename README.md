# PT_Demo_SpringBoot

PT_Demo_SpringBoot

## Contents
- [Setup](#setup)
    - [Initial Setup](#initial-setup)
    - [Codebase Implementation](#codebase-implementation)
    - [Run the Application](#run-the-application)
- [Unit Testing](#unit-testing)
- [Use Database](#use-database)
- [Use Redis](#use-redis)

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

## Unit Testing
1. Make sure you have the following dependency in `pom.xml`, as it is needed in order to test the controller, using Spring Boot's MockMvc to mock HTTP requests:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```
2. In `studentboot/src/test/java/com.petartotev.studentboot`:
- create package `repository` and implement `StudentRepositoryTest`;
- create package `controller` and implement `StudentControllerTest`.
3. In order to run all tests, either:
- `Ctrl + Shift + F10` (this didn't work for me...);
- Right click on `src/test/java` > Run `All Tests`.

## Use Database
1. Run PostgreSQL container (see PT_Demo_PostgreSQL).
2. Implement Car model, CarRepository and CarController similar to Student's.
3. Add the following dependencies in `pom.xml`:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```
4. In `application.properties`, add the following:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# Optional: Enable SQL logging
spring.jpa.show-sql=true
spring.datasource.initialization-mode=always
```
5. Make sure you have the Car table created by creating `schema.sql` in resource directory with query "IF NOT EXISTS CREATE".
This doesn't work!
I needed to create this manually by executing the query in DBeaver.
6. Refactor the Repository and Controller as it currently is.

## Use Redis
1. Run Redis in Docker Container on `localhost:6370`:
```
docker run --name redis-server -p 6379:6379 -d redis
```
2. Add the following dependency in `pom.xml`:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
3. Configure Redis in `application.properties`:
```
spring.redis.host=localhost
spring.redis.port=6379
```
4. Implement `Employee` model, using @RedisHash("Employee") and @Id - should be String.
5. Implement `EmployeeRepository` interface using @Repository and extending CrudRepository<Employee, String>.
6. Implement `EmployeeController` that injects `EmployeeRepository employeeRepository`.