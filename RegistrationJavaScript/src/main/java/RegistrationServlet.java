

import java.io.IOException;
import java.io.Writer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NAME="firstName";
	private static final String TYPE="type";
	

		
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("application/json");
		Writer out = response.getWriter();

		if (request.getParameter(TYPE)!=null) {
			if (request.getParameter(TYPE).equals("info")) {//if the client asks for info
				             								//construct a msg...
				String msg="Welcome, this is a sample JS-Java client server interaction";

				out.append(msg);
			}
			
		}else {
        //normally, here you continue to check what the clients wants..
		//assume it asks to register a student
		//just echo the parameters, normally you persist it 
		out.append(request.getParameter(NAME));
	    out.append(", registered for: " +request.getParameter("courseNr"));
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
