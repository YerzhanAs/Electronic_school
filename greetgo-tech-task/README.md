# Spring boot "Electronic school" project 

This project is an example of a Spring Boot application using a database. It demonstrates the work of the Electronic school website. The site has such functionality as authentication (login and password verification), adding, deleting, editing, reading a student from the database.

## 1.1 Technologies Used
- Java 8
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Test NG
- MVC
- React (Client side)
- Hibernate
- Maven

## 1.2 Getting Started
To get started with this project, follow these steps:

1. Clone this repository onto your local machine.
   git clone https://github.com/YerzhanAs/Electronic_school.git 
2. Build the application
   cd Electronic_school
   mvn clean package
3. Run the application
   java -jar target/Electronic_school-0.0.1-SNAPSHOT.jar
4. Create a PostgreSQL database with the name `student_system`.
5. Update the `application.properties` file with your database connection details:
```
server.port=8085
spring.application.name=student-service

spring.datasource.url=jdbc:postgresql://localhost:5432/student_system
spring.datasource.username=postgres
spring.datasource.password=123

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
4. Run the project using `mvn spring-boot:run` command.
5. The project is now running and can be accessed at `http://localhost:8085/api/v1/`.

## 1.3  Data for Login

### Data 1:
####  email: yerzhan@gmail.com  password: Erzhan123

### Data 2:
###  email: admin@gmail.com password: 12345qwe

If you can't log in through these settings, try registering

## 1.4  API Endpoints

### 1.4.1 Registration User
#### Request
```
POST /api/v1/user/save
Content-Type: application/json

{
    "fullName" : "Ashimov Yerzhan",
    "email" : "yerz777@gmail.com",
    "password": "Erzhan1234"
}
```

#### Response
```
HTTP/1.1 200 Ok
Location: /user/save
Content-Type: application/json

{
    "fullName" : "Ashimov Yerzhan",
}
```

### 1.4.2 Login User
#### Request
```
POST /api/v1/user/login
Content-Type: application/json
{
    "email" : "yerz777@gmail.com",
    "password": "Erzhan1234"
}
```

#### Response
```
HTTP/1.1 200 Ok
Location: /user/login
Content-Type: application/json

{
    "message": "Login Success",
    "status": true
}
```

### 1.4.3 Create a Student
#### Request
```
POST /api/v1/students/save
Content-Type: application/json

{
    "fullName": "Ashimov Yerzhan",
    "address": "Al-Farabi 55d",
    "phone": "8-707-185-88-35",
    "age": 20
}
```

#### Response
```
HTTP/1.1 201 Created
Location: /students/save
Content-Type: application/json

{
    "id":"1",
    "fullName": "Ashimov Yerzhan",
    "address": "Al-Farabi 55d",
    "phone": "8-707-185-88-35",
    "age": 20
}
```

### 1.4.4 Get All Students
#### Request
```
GET /students/getall
```

#### Response
```
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "fullName": "John Doe",
        "address": "123 Main St",
        "phone": "555-555-1212",
        "age": 25
    },
    {
        "id": 2,
        "fullName": "Jane Doe",
        "address": "456 Oak Ave",
        "phone": "555-555-2323",
        "age": 27
    }
]
```

### 1.3.4 Get a Student by ID
#### Request
```
GET /students/search/1
```

#### Response
```
HTTP/1.1 200 OK
Content-Type: application/json

{
    "id": 1,
    "fullName": "John Doe",
    "address": "123 Main St",
    "phone": "555-555-1212",
    "age": 25
}
```

### 1.4.5 Update a Student
#### Request
```
PUT /students/edit/1
Content-Type: application/json

{
    "fullName": "John Smith",
    "address": "123 Main St",
    "phone": "555-555-1212",
    "age": 30
}
```

#### Response
```
HTTP/1.1 200 OK
Content-Type: application/json

{
    "id": 1,
    "fullName": "John Smith",
    "address": "123 Main St",
    "phone": "555-555-1212",
    "age": 30
}
```

### 1.4.6 Delete a Student
#### Request
```
DELETE /students/delete/1
```

#### Response
```
HTTP/1.1 204 No Content
``` 

## 1.5 Test
I wrote two classes for the test. The first test is StudentServiceImplTest. First test test all methods of the StudentServiceImpl class. This class contains all the logic of the service. The second test is UserServiceImplTest. Here it is the same as in the first test.

## 1.6 Conclusion
This project has demonstrated how to create a Spring Boot application with a database. It covered connecting to a database, performing CRUD operations, and handling errors. With
