<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.food.model.Order"%>

<%
Order order = (Order)request.getAttribute("order");

String status = order.getStatus();
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Track Order</title>

<link rel="stylesheet" href="css/trackOrder.css">

</head>

<body>

<div class="container">

<h1>🍴 Track Your Order</h1>

<div class="card">

<h2>Order #<%=order.getOrderId()%></h2>

<p>Total : ₹ <%=order.getTotalAmount()%></p>

<p>Payment : <%=order.getPaymentMethod()%></p>

<p>Status : <b><%=status%></b></p>

<div class="timeline">

<div class="step <%=status.equals("Pending") || status.equals("Confirmed")
|| status.equals("Preparing")
|| status.equals("Out_For_Delivery")
|| status.equals("Delivered") ? "active" : ""%>">

✔ Pending

</div>

<div class="line"></div>

<div class="step <%=status.equals("Confirmed")
|| status.equals("Preparing")
|| status.equals("Out_For_Delivery")
|| status.equals("Delivered") ? "active" : ""%>">

✔ Confirmed

</div>

<div class="line"></div>

<div class="step <%=status.equals("Preparing")
|| status.equals("Out_For_Delivery")
|| status.equals("Delivered") ? "active" : ""%>">

👨‍🍳 Preparing

</div>

<div class="line"></div>

<div class="step <%=status.equals("Out_For_Delivery")
|| status.equals("Delivered") ? "active" : ""%>">

🛵 Out For Delivery

</div>

<div class="line"></div>

<div class="step <%=status.equals("Delivered") ? "active" : ""%>">

🏠 Delivered

</div>

</div>

<br>

<a href="orderHistory">← Back to Orders</a>

</div>

</div>

</body>
</html>