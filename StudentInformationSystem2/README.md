# Lab 4

## Purpose
Using Maven, we're creating a web project. this will have attributes of a dynamic web project built in because of the dependencies we added.

For this project, we're focusing on sqlite, tying a database with the backend.

Firstly, in the context.xml, the url should be linked to your pathname of your db.


The StudenDAO.java contains the CRUD process.
CRUD = Create, Read, Update, and Delete.

Adding: 
- DatabaseConnection
- ApiCallCounterFilter
- ApiCallCounterListener

Updating:
- StudentController
- StudentDAO



## Testing

Create a Student:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"name":"John", "age":20,
"major":"Computer Science"}' http://localhost:8080/StudentInformationSystem2/students
```

List All Students

```bash
curl -X GET http://localhost:8080/StudentInformationSystem2/students
```

Get a Specific Student (gets the first index, 0 doesn't exist)

```
curl -X GET http://localhost:8080/StudentInformationSystem2/students/1 
```

Update a Student

```
curl -X PUT -H "Content-Type: application/json" -d '{"name":"John Doe", "age":21,
"major":"Software Engineering"}' http://localhost:8080/StudentInformationSystem2/students/1
```

Delete a Student

```
curl -X DELETE http://localhost:8080/StudentInformationSystem2/students/1
```
