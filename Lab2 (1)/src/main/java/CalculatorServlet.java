

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Servlet implementation class CalculatorServlet
 */

public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(); // Part of Task C
		
		
		// Optional Step: Adding Default Values to NoItems and Price / To Prevent Null Errors
		String defaultNoItems = getServletContext().getInitParameter("defaultNoItems");
		int noItems = Integer.parseInt(defaultNoItems);
		
		String defaultPrice = getServletContext().getInitParameter("defaultPrice");
		double price = Double.parseDouble(defaultPrice);
		
		
		// ___________ TASK A ___________
		//Using GetParameter
		if (request.getParameter("noItems") != null) {
			noItems = Integer.parseInt(request.getParameter("noItems"));
		}
		if (request.getParameter("price") != null) {
			price = Double.parseDouble(request.getParameter("price"));
		} 
		//tax = Double.parseDouble(request.getParameter("tax"));
		
		//___________ Task B: Default Tax Rate ___________
		String defaultTax = getServletContext().getInitParameter("defaultTaxRate");
		double tax = Double.parseDouble(defaultTax);
		
		/*if (request.getParameter("tax") != null) {
			tax = Double.parseDouble(request.getParameter("tax"));
		}
		*/
		
		//___________ Task C: Remembering Tax Rate ___________
				
		if (request.getParameter("tax") != null) {
			tax = Double.parseDouble(request.getParameter("tax"));
			session.setAttribute("tax", tax); 
		} else if (session.getAttribute("tax") != null) {
			tax = (double) session.getAttribute("tax");
			System.out.println("Session Tax Rate: " + tax);
		}

		// ______________________
		 
        // Use the Model class to perform the calculation 
		System.out.println(price);
		
        double total = Cart.calculateTotal(noItems, price, tax); 

  

        // Set attributes to pass to the JSP 

        request.setAttribute("noItems", noItems); 
        request.setAttribute("price", price); 
        request.setAttribute("tax", tax); 
        request.setAttribute("total", total); 

  

        // Forward the request to the JSP file 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ShoppingCartCalculator.jsp"); 
        dispatcher.forward(request, response); 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doGet(request, response);
	}

}
