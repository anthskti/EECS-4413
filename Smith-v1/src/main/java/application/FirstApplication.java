package application;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;



@WebServlet({ "/FirstApplication", "/FirstApplication/*" })
public class FirstApplication extends HttpServlet {
	
	private String appName = "";
	private String applicantName = "";
	
	
	private static final String CONTEXT_APP_NAME = "applicationName";
	private static final String CONTEXT_APPLICANT = "applicantName";
	private static final String PARAM_APPLICANT = CONTEXT_APPLICANT;


	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = getServletContext();
		appName = context.getInitParameter(CONTEXT_APP_NAME);
		applicantName = context.getInitParameter(CONTEXT_APPLICANT);

	} 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		// Establish a Connections
		System.out.println("Hello, world!\"");
		response.setContentType("text/plain");
		Writer resOut = response.getWriter();
		//resOut.write("Hello, 4413!\n");
		
		// The Networking Layer
		String clientIP = request.getRemoteAddr();
		int clientPort = request.getRemotePort();

		resOut.write("Client IP: " + clientIP + "\n");
		resOut.write("Client Port: " + clientPort + "\n");

		// Simple IP filtering
		if (clientIP.equals("127.0.0.1")) {//if (clientIP.equals("0:0:0:0:0:0:0:1")) {
			resOut.write("This IP has been flagged!" + "\n");
		}
		

		// The HTTP Layer
		String clientProtocol = request.getProtocol();
		String clientMethod = request.getMethod();

		resOut.write("Client Protocol: " + clientProtocol + "\n");
		resOut.write("Client Method: " + clientMethod + "\n");
		
		String clientQueryString = request.getQueryString();
		
		resOut.write("Query String: " + clientQueryString + "\n");
		
		String foo = request.getParameter("foo");
		
		resOut.write("Query Param foo=" + foo + "\n");
		
		// The URL
		
		String clientURI = request.getRequestURI();
		String clientServletPath = request.getServletPath();//String clientServletPath = request.getPathInfo();


		ServletContext context = this.getServletContext();

		
		//it returns a String.  


		
		resOut.write("Request URI : " + clientURI + "\n");
		resOut.write("Request Servlet Path : " + clientServletPath + "\n");

		//resOut.write("Request Servlet Path : " + clientServletPath + "\n");
		//resOut.write("Request Servlet Path : " + clientServletPath + "\n");
		//String clientIP = request.getRemoteAddr(); 
		//resOut.write("Client IP: " + clientIP + "\n");
		//String clientQueryString = request.getQueryString();
		
		//String foo = request.getParameter("foo"); 
		//resOut.write("Query Param foo=" + foo + "\n");
		

		
		//Context object
		resOut.write("--- Information for context object ---\n");
		String contextParameter = this.getServletContext().getInitParameter(CONTEXT_APP_NAME);
		resOut.write("Application name:" + contextParameter + "\n");
		
		String contextPath = context.getContextPath(); 
		resOut.write("Context Path : " + contextPath + "\n");
		
		String realPath = context.getRealPath("FirstApplication");
		resOut.write("Real Path : " + realPath + "\n");
		
		String applicantName = this.getServletContext().getInitParameter(PARAM_APPLICANT);
		resOut.write("Applicant name : " + applicantName + "\n");


	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	}

	
}
