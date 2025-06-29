# Labtest 2


## Testing

Create a Student loan 1:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"loanID":1, "principal":2000,"interest":3.5,"period":120,"studentID":1}' http://localhost:8080/Labtest2-pham/loans
```

Create student loan 2:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"loanID":2, "principal":1900,"interest":3.5,"period":100,"studentID":2}' http://localhost:8080/Labtest2-pham/loans
```

create student loan 3:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"loanID":3, "principal":1600,"interest":3.5,"period":105,"studentID":3}' http://localhost:8080/Labtest2-pham/loans
```

List All Students loans

```bash
curl http://localhost:8080/Labtest2-pham/loans/ | json_pp
```

Update a StudentLoan

```
curl -X PUT -H "Content-Type: application/json" -d '{"loanID":1, "principal":3000,"interest":3.5,"period":120,"studentID":1}' http://localhost:8080/Labtest2-pham/loans/1
```

Delete a Studentloan

```
curl -X DELETE http://localhost:8080/Labtest2-pham/loans/2
```
