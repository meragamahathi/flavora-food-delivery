<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="com.food.model.Cart"%>
<%@page import="com.food.model.CartItem"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Flavora | Checkout</title>

<link rel="stylesheet" href="css/checkout.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>

<nav class="navbar">

    <div class="logo">
        🍴 FLAVORA
    </div>

    <ul>

        <li><a href="index.jsp">Home</a></li>

        <li><a href="restaurant">Restaurants</a></li>

        <li><a href="cart.jsp">Cart</a></li>

        <li><a href="orderHistory">My Orders</a></li>
        
        <li><a href="#">Profile</a></li>

    </ul>

</nav>

<%

Cart cart=(Cart)session.getAttribute("cart");

double grandTotal=0;

%>

<div class="checkout-container">

<div class="left-section">

<h2>Delivery Details</h2>

<form id="checkoutForm" action="orderServlet" method="post">

<div class="input-group">

<label>Full Name</label>

<input type="text" name="name" placeholder="Enter Full Name" required>

</div>

<div class="input-group">

<label>Phone Number</label>

<input type="text" name="phone" placeholder="Enter Phone Number" required>

</div>

<div class="input-group">

<label>Delivery Address</label>

<textarea name="address" rows="4" placeholder="Enter Delivery Address" required></textarea>

</div>

<h2>Payment Method</h2>

<div class="payment-box">

<label>

<input type="radio" name="payment" value="Cash on Delivery" checked>

Cash on Delivery

</label>

<label>

<input type="radio" name="payment" value="UPI">

UPI

</label>

<label>

<input type="radio" name="payment" value="Credit Card">

Credit / Debit Card

</label>

</div>

<button type="button" class="place-btn" onclick="makePayment()">
    Place Order
</button>

</form>

</div>



<div class="right-section">

<h2>Order Summary</h2>

<%

if(cart!=null && !cart.getItems().isEmpty()){

for(CartItem item:cart.getItems().values()){

double total=item.getTotalPrice();

grandTotal+=total;

%>

<div class="summary-card">

<div class="summary-left">

<img src="images/<%=item.getImageUrl()%>" alt="<%=item.getName()%>">


</div>

<div class="summary-middle">

<h3><%=item.getName()%></h3>

<p>₹ <%=item.getPrice()%></p>

</div>

<div class="summary-right">

<p>Qty : <%=item.getQuantity()%></p>

<h3>₹ <%=total%></h3>

</div>

</div>

<%

}

%>

<div class="bill">

<div class="bill-row">

<span>Subtotal</span>

<span>₹ <%=grandTotal%></span>

</div>

<div class="bill-row">

<span>Delivery Fee</span>

<span>₹ 40</span>

</div>

<div class="bill-row">

<span>GST</span>

<span>₹ <%=String.format("%.2f",grandTotal*0.05)%></span>

</div>

<hr>

<%
double finalAmount = grandTotal + 40 + (grandTotal * 0.05);
session.setAttribute("totalAmount", finalAmount);
%>

<div class="bill-total">

<span>Total Amount</span>

<span>

₹ <%=String.format("%.2f",grandTotal+40+(grandTotal*0.05))%>

</span>

</div>

</div>

<%

}

else{

%>

<div class="empty-cart">

<h2>Your Cart is Empty 🛒</h2>

<a href="restaurant">

Browse Restaurants

</a>

</div>

<%

}

%>

</div>

</div>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script src="js/payment.js"></script>

</body>

</html>