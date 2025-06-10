package crtl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet1
 * This code is adapted from: https://beginnersbook.com/2013/05/http-session/
 */
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     try{ 
	         response.setContentType("text/html");
	         PrintWriter pwriter = response.getWriter();
	         String name = request.getParameter("userName");
	         String password = request.getParameter("userPassword");
	         pwriter.print("Hello "+name + ". " );
	         pwriter.print(" Your Password is: " +password + ". ");
	         HttpSession session=request.getSession();
	         session.setAttribute("uname",name);
	         session.setAttribute("upass",password);
	         pwriter.print("<a href='welcome'> view details</a>");
	         pwriter.close();
	       }
	     catch(Exception exp){
	         System.out.println(exp); 
	      }
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
