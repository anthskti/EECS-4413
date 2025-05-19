# Lab 1

## Initalization
1. Download from Apache Tomcat, then click "Servers" at the bottom and link ur server.
2. Then create a Dynamic Web Project. 
3. Create a Servlet by "New" then "Other" then "Servlet", link to Tomcat.

## Testing
``` bash
curl "http://localhost:8080/pham-v2/CalculatorServlet?noItems=5&price=10&tax=15"
```
Will return an HTML page that displays the total price as $57.50.

``` bash
curl "http://localhost:8080/pham-v2/CalculatorServlet?noItems=5&price=10"
```
Will return an HTML page that displays the total price as $65.50. Uses default tax rate from context parameter.

``` bash
curl "http://localhost:8080/pham-v2/CalculatorServlet?noItems=abc&price=10&tax=15"
```
Will return error page that shows java.lang.NumberFormatEception: for input string: "abc".

```bash
#For MacOS/Unix-based:
touch session.txt

curl –c session.txt "http://localhost:8080/pham-v2/CalculatorServlet?noItems=5&price=10&tax=15"
curl –b session.txt "http://localhost:8080/pham-v2/CalculatorServlet?noItems=5&price=10&"

```

For session, using memory tax with cookies.
The first command should return an HTML page that displays the total price as $57.50 and store
the tax rate of 15% in the session attribute. The second command should return an HTML page
that displays the total price as $57.50, using the stored tax rate of 15% from the session
attribute. The third command should return an HTML page that displays the total price as
$60.00 and update the tax rate of 20% in the session attribute.


