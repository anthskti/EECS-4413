# Lab 2

## Initialization
1. Download from Apache Tomcat, then click "Servers" at the bottom and link ur server.
2. Then create a Dynamic Web Project. 
3. Create a Servlet by "New" then "Other" then "Servlet", link to Tomcat.

## Purpose
We made a UI.html file that acts as our host, where clients can interact with the page and submit requests.
The Servlet then requests this data from the html, which parses it and calculates the shopping cart amount.
Then, the results are requested by the ShoppingCartCalculator.jsp, which is formatted like an HTML file, with variables from the java servlet.


With that, we have general invalidated or empty inputs we handle through the logic in our java file or javascript file. We also used CSS for basic styling.


## Testing
valid input:

```bash
curl "http://localhost:8080/pham-v3/CalculatorServlet?noItems=5&price=10&tax=15"
```

invalid noItems:

```bash
curl "http://localhost:8080/pham-v3/CalculatorServlet?noItems=-5&price=10&tax=15"
```

invalid price:

```bash
curl "http://localhost:8080/pham-v3/CalculatorServlet?noItems=5&price=-10&tax=15"
```

invalid tax:

```bash
curl "http://localhost:8080/pham-v3/CalculatorServlet?noItems=5&price=10&tax=150"
```

