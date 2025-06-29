# Lab 6 / Springboot Tutorial

(Link to Tutorial)[https://spring.io/guides/tutorials/rest]

Employee Payroll Tutorial.

Employee.java: Is a java class that employee constructor, setter and getters. 

EmployeeRepository.java: Helps manage my the employee 

PayrollApplication: for component scanning, auto-configuration, and property support. starts a servlet container and serves up our service.
Running this will bring up information regarding preloading data. 

LoadDatabase.java: Spring Boot runs ALL CommandLineRunner beans once the application context is loaded. This runner requests a copy of the EmployeeRepository you just created. The runner creates two entities and stores them.

EmployeeController.java: Controller mapping. Which will help handle requests.

EmployeeNotFound and EmployeeNotFoundAdvice: Just when an ID isn't exist, then leading it to a 404 page, but advice will implement it so it won't 404 i think.

After, running the "PayrollApplication" will make the server live, go to localhost:8080/employees, and it'll show you the preloaded data. 

curl -v localhost:8080/employees/1 and 99 

## Some Commands

create new employee

```bash
curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```

update

```bash
curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'
```

delete

```bash
curl -X DELETE localhost:8080/employees/3
```

# Part 2

Pretty URLs, such as`/employees/3`, aren’t REST. Merely using GET, POST, and so on is not REST.Having all the CRUD operations laid out is not REST.

Updated @GetMapping

```bash
curl -v localhost:8080/employees/1 | json_pp
```

# Part 3
EmployeeModelAssembler.java: just a component that leads to repeatable code.

```bash
curl -v -X POST localhost:8080/employees -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}' | json_pp
```

update

```bash
curl -v -X PUT localhost:8080/employees/3 -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "role": "ring bearer"}' | json_pp
```


Delete

```bash
curl -v -X DELETE localhost:8080/employees/1
```

# Order

```bash
curl -v http://localhost:8080/orders | json_pp
```