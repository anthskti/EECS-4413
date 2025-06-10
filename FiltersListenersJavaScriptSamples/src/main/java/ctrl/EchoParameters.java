package ctrl;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Counting
 */
	    /* this servlet does the following
		 * 1. if there is a parameter named firstName, then it saves it as an attribute
		 * 2. echos the query string to the client
		 */
@WebServlet("/EchoParameters")
public class EchoParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoParameters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub ...
		//below we just want to trigger an event...
		if(request.getParameter("firstName")!=null)
		   request.setAttribute("firstName", request.getParameter("firstName"));//this will trigger an event;check the corresponding listner
		
		
		response.getWriter().append("Query String is:  ").append(request.getQueryString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
