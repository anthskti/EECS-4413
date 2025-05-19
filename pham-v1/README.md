# Lab 0

## Initalization
1. Download from Apache Tomcat, then click "Servers" at the bottom and link ur server.
2. Then create a Dynamic Web Project. 
3. Create a Servlet by "New" then "Other" then "Servlet", link to Tomcat.

## Testing
``` bash
curl "http://localhost:8080/pham-v1/firstApplication/test"
```
Will test your website on the terminal.


Hello World

``` bash
curl "http://localhost:8080/pham-v1/HelloWorld.html"
```

Get Request

``` bash
curl "http://localhost:8080/pham-v1/firstApplication"
```

Post Request

``` bash
curl –d "" -X POST “http://localhost:8080/pham-v1/firstApplication”
```

Query String

``` bash
curl "http://localhost:8080/pham-v1/firstApplication?foo=bar"

```
