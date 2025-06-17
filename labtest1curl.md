# Step 6 - Testing
Anthony Pham

All I did was modify the parameter names and changed the server name to my file.

1. A valid computation, POST with:
all attributes outside ontario
```bash
curl -X POST 'http://localhost:8080/pham-Test1/CalculatorServlet?noItems=10&price=22&tax=15&shipping=Quebec&name=Alicia%20Smith'
```
all attributes inside ontario
```bash
curl -X POST 'http://localhost:8080/pham-Test1/CalculatorServlet?noItems=10&price=22&tax=15&shipping=Ontario&name=Alicia%20Smith'
```
all attributes with default shipping
```bash
curl -X POST 'http://localhost:8080/pham-Test1/CalculatorServlet?noItems=10&price=22&tax=15&name=Alicia%20Smith'
```


2. An invalid input that should return an error message:

invalid # of items.
```bash
curl -X POST 'http://localhost:8080/pham-Test1/CalculatorServlet?noItems=0&price=100&tax=15&shipping=Ontario&name=Alicia%20Smith'
```
invalid price and tax
```bash
curl -X POST 'http://localhost:8080/pham-Test1/CalculatorServlet?noItems=10&price=0&tax=-1&shipping=Quebec&name=Alicia%20Smith'
```
invalid tax:
```bash
curl -X POST 'http://localhost:8080/pham-Test1/CalculatorServlet?noItems=10&price=10&tax=-1&shipping=Quebec&name=Alicia%20Smith'
```

