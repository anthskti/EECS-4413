# Lab 3

## Purpose
Using Maven, we're creating 


The StudenDAO.java contains the CRUD process.
CRUD = Create, Read, Update, and Delete.


## Testing

Create a Student:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"name":"John", "age":20,
"major":"Computer Science"}' http://localhost:8080/StudentInformationSystem/students
```

View all students:

```bash
curl -X GET http://localhost:8080/StudentInformationSystem/students
```

View Specific student:

```bash
curl -X GET http://localhost:8080/StudentInformationSystem/students/0
```
Update a Student

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"name":"John Doe", "age":21,
"major":"Software Engineering"}' http://localhost:8080/StudentInformationSystem/students/0
```
Delete a Student

``` bash
curl -X DELETE http://localhost:8080/StudentInformationSystem/students/0
```