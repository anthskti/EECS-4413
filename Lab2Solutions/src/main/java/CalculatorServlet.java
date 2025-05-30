

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		HttpSession session = request.getSession(); // Part of Task C
		
		// Optional Step: Adding Default Values to NoItems and Price / To Prevent Null Errors
		String defaultNoItems = getServletContext().getInitParameter("defaultNoItems");
		double noItems = Double.parseDouble(defaultNoItems);
		
		String defaultPrice = getServletContext().getInitParameter("defaultPrice");
		double price = Double.parseDouble(defaultPrice);
		
		// ___________ TASK A ___________
		//Using GetParameter
		if (request.getParameter("noItems") != null) {
			noItems = Double.parseDouble(request.getParameter("noItems"));
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
		 
		// Calculation
		double total = noItems * price * (1 + tax / 100);
		total = Math.round(total * 100) / 100.0;
		

		// Output
		response.setContentType("text/html");
		PrintWriter resOut = response.getWriter();  
		
		resOut.println("<html>"); 
		resOut.println("<head>"); 
		resOut.println("<title>Shopping cart Price Calculator</title>"); 
		resOut.println("</head>"); 
		resOut.println("<body>"); 
		resOut.println("<h1>Shopping cart Price Calculator</h1>"); 
		resOut.println("<p>You entered:</p>"); 
		resOut.println("<ul>"); 
		resOut.println("<li>Number of items: " + noItems + "</li>"); 
		resOut.println("<li>Price of each item: $" + price + "</li>"); 
		resOut.println("<li>Tax rate: " + tax + "%</li>"); 
		resOut.println("</ul>"); 
		resOut.println("<p>The total price is calculated as:</p>"); 
		resOut.println("<p>total = noItems * price * (1 + tax / 100)</p>"); 
		resOut.println("<p>The total price is: $" + total + "</p>"); 
		resOut.println("</body>"); 
		resOut.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
