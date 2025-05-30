package firstApplication;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

/**
 * Servlet implementation class firstApplication
 */
@WebServlet({ "/firstApplication", "/firstApplication/*" })
public class firstApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstApplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/plain");
	    PrintWriter resOut = response.getWriter();

	    // a. Return client IP and port
	    String clientIP = request.getRemoteAddr();
	    int clientPort = request.getRemotePort();
	    
	    resOut.write("Client IP: " + clientIP + "\n");
	    resOut.write("Client Port: " + clientPort + "\n");
	    
	    // Simple IP filtering
 		if (clientIP.equals("127.0.0.1")) {//if (clientIP.equals("0:0:0:0:0:0:0:1")) {
 			resOut.write("This IP has been flagged!" + "\n");
 		}
	    
	    
	    // b. Return request protocol and method
	    String clientProtocol = request.getProtocol();
	    String clientMethod = request.getMethod();
	    resOut.write("Client Protocol: " + clientProtocol + "\n");
	    resOut.write("Client Method: " + clientMethod + "\n");

	    // d. Query string and specific parameter "foo"
	    String clientQueryString = request.getQueryString(); // raw query string
	    String foo = request.getParameter("foo"); // value of ?foo=value
	    resOut.write("Query String: " + clientQueryString + "\n");
	    resOut.write("Query Param foo=" + foo + "\n");
	    
	    // c. Return request path
	    String clientURI = request.getRequestURI(); // for /FirstApplication/*
	    String clientServletPath = request.getServletPath(); // for /FirstApplication
	    resOut.write("Request URL: " + clientURI + "\n");
	    resOut.write("Request Servlet Path: " + clientServletPath + "\n");

	    // e. Spaces in URL will show as %20 or + in query string
	    // Try visiting: http://localhost:8080/Pham-V1/FirstApplication?foo=hello%20world
	    
	    // adding my content
	    ServletContext context = this.getServletContext();
	    String appName = context.getInitParameter("applicationName");
	    String contextPath = context.getContextPath();
	    String realPath = context.getRealPath("firstApplication");
	    String applicantName = context.getInitParameter("applicantName");
	    
	    resOut.write("Application Name: " + appName +"\n");
	    resOut.write("Context Path: " + contextPath + "\n");
	    resOut.write("Real Path: " + realPath + "\n");
	    resOut.write("Applicant Name: " + applicantName + "\n");
	    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
