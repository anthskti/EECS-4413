
public class Cart {

	 public static String validateInput(int noItems, double price, double tax) {
		 if (noItems <= 0) return "Number of items must be a positive integer. -cart";
		 if (price <= 0) return "Price must be a positive number. -cart";
		 if (tax < 0 || tax > 100) return "Tax rate must be between 0 and 100. -cart";
		 return null;
	}

	public static double calculateTotal(int noItems, double price, double tax) {
		// Perform the calculation
		String validationError = validateInput(noItems, price, tax);
		if (validationError != null) {
			throw new IllegalArgumentException(validationError);
		}
		double total = noItems * price * (1 + tax / 100);
		return total;
	}	
}
