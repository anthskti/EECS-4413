document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('cartForm').addEventListener('submit', function(event) {
		event.preventDefault();
		var name = document.getElementById('name').value;
		var shipping = document.getElementById('shipping').value;
		var noItems = parseInt(document.getElementById('noItems').value);
		var price = parseFloat(document.getElementById('price').value);
		var tax = parseFloat(document.getElementById('tax').value);
		
		// Part 5 Requirements
		
		if (name == "" || name == null) {
			alert("The customer name should not be empty. -js");
			return;
		}
		if (shipping == "" || shipping == null) {
			alert("The shipping province should not be empty. -js");
			return;
		}

		if (noItems <= 0) {
			alert("The number of items should be greater than zero. -js");
			return;
		}
		if (price <= 0) {
		 	alert("The price of each item should be greater than zero. -js");
		 	return;
		}
		if (tax <= 0 || tax > 100) {
			alert("The tax rate should be greater than zero. -js");
			return;
		}
		
		event.currentTarget.submit();
	});
});