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
 * Servlet implementation class MyServlet2
 * This code is adapted from: https://beginnersbook.com/2013/05/http-session/
 */
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
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
		      HttpSession session = request.getSession(false);
		      String myName = (String)session.getAttribute("uname");
		      String myPass = (String)session.getAttribute("upass");
		      pwriter.print("Name: "+myName+". Password: "+myPass);
		      pwriter.close();
		  }catch(Exception exception){
		      System.out.println(exception); 
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
