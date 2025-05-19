

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
@WebServlet("/CalculatorServlet")
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
// parameter getting and parsing 		
		String noItemsParam = request.getParameter("noItems");
		String priceParam = request.getParameter("price");
		String taxParam = request.getParameter("tax");
		
		int noItems = Integer.parseInt(noItemsParam);
		double price = Double.parseDouble(priceParam);
		double tax;
		
		HttpSession session = request.getSession();
		
		if (taxParam != null && !taxParam.isEmpty()) {
			tax = Double.parseDouble(taxParam);	
			session.setAttribute("taxRate", tax);
		}
		// remembered task (Task C)
		else if (session.getAttribute("taxRate") != null) { 
			tax = (double) session.getAttribute("taxRate");
		}
		else {
			String defaultTax = getServletContext().getInitParameter("defaultTaxRate");
			tax = Double.parseDouble(defaultTax);
		}
		
		double total = noItems * price * (1 + tax / 100);
		total = Math.round(total * 100) / 100.0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Shopping cart Price Calculator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Shopping cart Price Calculator</h1>");
		out.println("<p>You entered:</p>");
		out.println("<ul>");
		out.println("<li>Number of items: " + noItems + "</li>");
		out.println("<li>Price of each item: $" + price + "</li>");
		out.println("<li>Tax rate: " + tax + "%</li>");
		out.println("</ul>");
		out.println("<p>The total price is calculated as:</p>");
		out.println("<p>total = noItems * price * (1 + tax / 100)</p>");
		out.println("<p>The total price is: $" + total + "</p>");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
