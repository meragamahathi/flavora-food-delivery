<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.food.model.*"%>
<%@ page import="com.food.daoimpl.*"%>

<%
User loggedUser = (User) session.getAttribute("user");

List<Order> orders = (List<Order>) request.getAttribute("orders");

UserDAOImpl userDAO =
(UserDAOImpl) request.getAttribute("userDAO");

RestaurantDAOImpl restaurantDAO =
(RestaurantDAOImpl) request.getAttribute("restaurantDAO");

int pending = 0;
int picked = 0;
int delivered = 0;

if(orders != null){

    for(Order o : orders){

        if(o.getDeliveryStatus().equalsIgnoreCase("Accepted"))
            pending++;

        else if(o.getDeliveryStatus().equalsIgnoreCase("Picked Up")
             || o.getDeliveryStatus().equalsIgnoreCase("Out For Delivery"))
            picked++;

        else if(o.getDeliveryStatus().equalsIgnoreCase("Delivered"))
            delivered++;
    }
}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Delivery Dashboard</title>

<link rel="stylesheet" href="css/deliveryDashboard.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<div class="container">

<!-- Sidebar -->

<div class="sidebar">

<h2>🚚 FLAVORA</h2>

<ul>

<li class="active">
<i class="fa-solid fa-house"></i>
Dashboard
</li>

<li>
<a href="deliveryHistory">
<i class="fa-solid fa-clock-rotate-left"></i>
History
</a>
</li>

<li>
<a href="deliveryProfile">
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

<!-- Main Content -->

<div class="main">

<div class="header">

<h1>

Welcome,

<%=loggedUser.getUserName()%> 👋

</h1>

<p>

Deliver orders quickly and safely.

</p>

</div>

<!-- Statistics -->

<div class="stats">

<div class="card">

<i class="fa-solid fa-box"></i>

<h2><%=orders.size()%></h2>

<p>Total Assigned</p>

</div>

<div class="card">

<i class="fa-solid fa-hourglass-half"></i>

<h2><%=pending%></h2>

<p>Pending</p>

</div>

<div class="card">

<i class="fa-solid fa-motorcycle"></i>

<h2><%=picked%></h2>

<p>In Progress</p>

</div>

<div class="card">

<i class="fa-solid fa-circle-check"></i>

<h2><%=delivered%></h2>

<p>Delivered</p>

</div>

</div>

<!-- Orders -->

<h2 class="title">

Assigned Orders

</h2>

<%
if(orders != null && !orders.isEmpty()){

for(Order order : orders){

User customer = userDAO.getUser(order.getUserId());

Restaurant restaurant =
restaurantDAO.getRestaurant(order.getRestaurantId());
%>

<div class="order-card">

<div class="left">

<img src="images/<%=restaurant.getImageUrl()%>">

</div>

<div class="middle">

<h2>

<%=restaurant.getName()%>

</h2>

<p>

<b>Order :</b>

#<%=order.getOrderId()%>

</p>

<p>

<b>Customer :</b>

<%=customer.getUserName()%>

</p>

<p>

<b>Address :</b>

<%=customer.getAddress()%>

</p>

<p>

<b>Amount :</b>

₹ <%=order.getTotalAmount()%>

</p>

<p>

<b>Payment :</b>

<%=order.getPaymentMethod()%>

</p>

</div>

<div class="right">

<%
String status = order.getDeliveryStatus();

String css = "pending";

if(status.equalsIgnoreCase("Picked Up"))
css="picked";

else if(status.equalsIgnoreCase("Out For Delivery"))
css="out";

else if(status.equalsIgnoreCase("Delivered"))
css="delivered";
%>

<span class="status <%=css%>">

<%=status%>

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

<h2>

No Assigned Orders

</h2>

<p>

Relax...

No deliveries assigned right now.

</p>

</div>

<%
}
%>

</div>

</div>

</body>

</html>