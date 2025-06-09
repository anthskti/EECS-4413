document.addEventListener('DOMContentLoaded', function() { 

    document.getElementById('cartForm').addEventListener('submit', function(event) { 

        event.preventDefault(); 

        var noItems = parseInt(document.getElementById('noItems').value); 

        var price = parseFloat(document.getElementById('price').value); 

        var tax = parseFloat(document.getElementById('tax').value); 

  

        if (noItems <= 0) { 

            alert("Number of items must be a positive integer."); 

            return; 

        } 

        if (price <= 0) { 

            alert("Price must be a positive number."); 

            return; 

        } 

        if (tax < 0 || tax > 100) { 

            alert("Tax rate must be between 0 and 100."); 

            return; 

        } 

  

        // If validation passes, call the server API 
        event.currentTarget.submit(); 

    }); 

});