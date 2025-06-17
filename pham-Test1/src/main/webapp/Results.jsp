<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shopping Cart Price Calculator</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body>
		<header>
			<h1>Shopping Cart Calculator</h1>
		</header>
		<main>
			<div class="calculator-results">
				<fieldset>
					<legend>Shopping Cart</legend>
					<p>Specific Pricing Information:</p>
					<ul>
						<li>Number of Items: <%= request.getAttribute("noItems") %></li>
						<li>Price of Each Item: <%= request.getAttribute("price") %></li>
						<li>Shipping Province: <%= request.getAttribute("shipping") %></li>
						<li>Tax Rate: <%= request.getAttribute("tax") %> %</li>
					</ul>
					<p>The shopping calculator inferred the following information:</p>
					<ul>
						<li>Shipping Fees: $<%= request.getAttribute("shippingFees") %></li>
					</ul>
					<p>total = shippingFees + noItems * price * (1 + tax / 100)</p>
					<p>The total price is: $<%= request.getAttribute("total") %></p>
				</fieldset>
			</div>
		</main>
		<footer>
			<p>Created by Anthony Pham (ID=219523422) for E-Commerce Lab test 1</p>
		</footer>
	</body>
</html>