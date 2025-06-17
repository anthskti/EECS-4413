

import jakarta.servlet.RequestDispatcher;
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
		
		// Initialization
		
		String defaultNoItems = getServletContext().getInitParameter("defaultNoItems");
		String defaultPrice = getServletContext().getInitParameter("defaultPrice");
//		System.out.println("defaultPrice = " + defaultPrice);
		int noItems = Integer.parseInt(defaultNoItems);
		double price = Double.parseDouble(defaultPrice);
		
		
		
		HttpSession session = request.getSession();
		
		// Task A number of items and price initalization
		
		if (request.getParameter("noItems") != null) {
			noItems = Integer.parseInt(request.getParameter("noItems"));
		}
		
		if (request.getParameter("price") != null) {
			price = Double.parseDouble(request.getParameter("price"));
		}
		
		// For shipping calculation
		String defaultShipping = getServletContext().getInitParameter("defaultShipping");
		String shipping = defaultShipping;
		if (request.getParameter("shipping") != null) {
			shipping = request.getParameter("shipping");
		}
		double shippingFees = 0;
		if(!shipping.toLowerCase().equals("ontario")) {
			shippingFees = 7.99;
			
		}
		
		
		// Task B 
		String taxParam = request.getParameter("tax");
		double tax; 
		
		
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
		
		// Calculate Results
		double total = Cart.calculateTotal(noItems, price, tax, shippingFees);
		
		// For rounding
		total = Math.round(total * 100) / 100.00;
		
		// JSP set Attributes
		request.setAttribute("noItems", noItems);
		request.setAttribute("price", price);
		request.setAttribute("shipping", shipping);
		request.setAttribute("tax", tax);
		request.setAttribute("shippingFees", shippingFees);
		request.setAttribute("total", total);
		
		// JSP forward request
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Results.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
