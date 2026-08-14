<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.food.model.Order"%>
<%@page import="com.food.daoimpl.OrderItemDAOImpl"%>
<%@page import="com.food.daoimpl.MenuDAOImpl"%>
<%@page import="com.food.model.OrderItem"%>
<%@page import="com.food.model.Menu"%>
<%@page import="com.food.model.OrderDetails"%>
<%@page import="com.food.model.CartItem"%>

<%@ page import="com.food.model.User"%>

<%
User loggedUser = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>AaharDhaan | My Orders</title>

<link rel="stylesheet" href="css/orderHistory.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>

<nav class="navbar">

<div class="logo">
🍴 Flavora
</div>

<ul>

<li><a href="index.jsp">Home</a></li>

<li><a href="restaurant">Restaurants</a></li>

<li><a href="cart.jsp">Cart</a></li>

<li>

<%
if(loggedUser != null && loggedUser.getUserName() != null
        && !loggedUser.getUserName().trim().isEmpty()) {

    String firstLetter =
        loggedUser.getUserName().trim().substring(0,1).toUpperCase();
%>

    <a href="profile.jsp" class="profile-circle">
        <%= firstLetter %>
    </a>

<%
} else {
%>

    <a href="profile.jsp" class="profile-text">
        Profile
    </a>

<%
}
%>

</li>

</ul>

</nav>

<div class="container">

<h2>📦 My Orders</h2>

<%

List<OrderDetails> orders = (List<OrderDetails>) request.getAttribute("orders");

if(orders!=null && !orders.isEmpty()){

  OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
  MenuDAOImpl menuDAO = new MenuDAOImpl();

  for(OrderDetails details : orders){

	    Order order = details.getOrder();
	    List<CartItem> items = details.getItems();
	
	
%>

<div class="order-card">

<div class="left">

<% if(items != null && !items.isEmpty()) { %>

    <% for(CartItem item : items){ %>

        <img src="images/<%=item.getImageUrl()%>"
             alt="<%=item.getName()%>"
             width="60"
             height="60">

    <% } %>

<% } %>

</div>

<div class="middle">

<h2>Order #<%=order.getOrderId()%></h2>

<p>

<b>Items :</b>

<% for(CartItem item : items){ %>

    <%=item.getName()%> x <%=item.getQuantity()%><br>

<% } %>

</p>

<p>

<b>Date :</b>

<%=order.getOrderDate()%>

</p>

<p>

<b>Payment :</b>

<%=order.getPaymentMethod()%>

</p>

<p>

<b>Total :</b>

₹ <%=String.format("%.2f",order.getTotalAmount())%>

</p>

</div>

<div class="right">

<%

String status=order.getStatus();

if(status.equalsIgnoreCase("Delivered")){

%>

<span class="status delivered">

Delivered

</span>

<%

}

else if(status.equalsIgnoreCase("Pending")){

%>

<span class="status pending">

Preparing

</span>

<%

}

else{

%>

<span class="status cancelled">

Cancelled

</span>

<%

}

%>

<a href="trackOrder?orderId=<%=order.getOrderId()%>" class="order-btn">
    Track Order
</a>

</div>

</div>

<%

}

}

else{

%>

<div class="empty">

<h2>No Orders Yet 🍴</h2>

<p>

Looks like you haven't ordered anything yet.

</p>

<a href="restaurant">

Explore Restaurants

</a>

</div>

<%

}

%>

</div>

</body>
</html>