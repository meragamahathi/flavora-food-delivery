<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="com.food.model.*"%>
<%@page import="com.food.daoimpl.*"%>

<%
User loggedUser=(User)session.getAttribute("user");

List<Order> orders=(List<Order>)request.getAttribute("orders");

UserDAOImpl userDAO=new UserDAOImpl();
RestaurantDAOImpl restaurantDAO=new RestaurantDAOImpl();
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Delivery History</title>

<link rel="stylesheet" href="css/deliveryHistory.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<div class="container">

<div class="sidebar">

<h2>🚚 FLAVORA</h2>

<ul>

<li>
<a href="deliveryDashboard">
<i class="fa-solid fa-house"></i>
Dashboard
</a>
</li>

<li class="active">
<i class="fa-solid fa-clock-rotate-left"></i>
History
</li>

<li>
<a href="#">
<i class="fa-solid fa-user"></i>
Profile
</a>
</li>

<li>
<a href="logout">
<i class="fa-solid fa-right-from-bracket"></i>
Logout
</a>
</li>

</ul>

</div>

<div class="main">

<div class="header">

<h1>Delivery History</h1>

<p>
Completed Deliveries
</p>

</div>

<%
if(orders!=null && !orders.isEmpty()){

for(Order order:orders){

User customer=userDAO.getUser(order.getUserId());

Restaurant restaurant=
restaurantDAO.getRestaurant(order.getRestaurantId());
%>

<div class="order-card">

<div class="left">

<img src="images/<%=restaurant.getImageUrl()%>">

</div>

<div class="middle">

<h2><%=restaurant.getName()%></h2>

<p><b>Order :</b> #<%=order.getOrderId()%></p>

<p><b>Customer :</b> <%=customer.getUserName()%></p>

<p><b>Date :</b> <%=order.getOrderDate()%></p>

<p><b>Amount :</b> ₹ <%=order.getTotalAmount()%></p>

<p><b>Payment :</b> <%=order.getPaymentMethod()%></p>

</div>

<div class="right">

<span class="status delivered">

Delivered

</span>

<br><br>

<a href="deliveryOrderDetails?orderId=<%=order.getOrderId()%>"
class="view-btn">

View Details

</a>

</div>

</div>

<%
}
}
else{
%>

<div class="empty">

<i class="fa-solid fa-box-open"></i>

<h2>No Delivered Orders</h2>

<p>
Your completed deliveries will appear here.
</p>

</div>

<%
}
%>

</div>

</div>

</body>

</html>
```
