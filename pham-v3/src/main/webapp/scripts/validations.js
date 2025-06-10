document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('cartForm').addEventListener('submit', function(event) {
		event.preventDefault();
		var noItems = parseInt(document.getElementById('noItems').value);
		var price = parseFloat(document.getElementById('price').value);
		var tax = parseFloat(document.getElementById('tax').value);
		
		if (noItems <= 0) {
			alert("Number of items must be a positive integer. -js");
			return;
		}
		if (price <= 0) {
		 	alert("Price must be a positive number. -js");
		 	return;
		}
		if (tax < 0 || tax > 100) {
			alert("Tax rate must be between 0 and 100. -js");
			return;
		}
		
		event.currentTarget.submit();
	});
	
	const taxError = document.querySelector("#tax + span.error");
	document.getElementId('tax').addEventListener("input", (event) => {
		var tax = parseFloat(document.getElementById('tax').value);
		if (tax < 0 || tax > 100) {
			// In case there is an error message visible, if the field
			taxError.textContent = "Tax rate must be between 0 and 100.";
			taxError.className = "error active";
		} 
		else {
			taxError.textContent = ""; // Reset the content of the message
			taxError.className = "error"; // Reset the visual state of the message
		}
	});
});