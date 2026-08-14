<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.food.model.Restaurant"%>

<%
List<Restaurant> restaurants =
        (List<Restaurant>)request.getAttribute("restaurants");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Manage Restaurants</title>

<link rel="stylesheet" href="css/adminRestaurants.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

<div class="sidebar">

<h2>🍴 FLAVORA</h2>

<ul>

<li><a href="adminDashboard">Dashboard</a></li>

<li><a href="adminUsers">Users</a></li>

<li class="active">Restaurants</li>

<li><a href="adminMenus">Menu</a></li>

<li><a href="adminOrders">Orders</a></li>

<li><a href="logout">Logout</a></li>

</ul>

</div>

<div class="content">

<h1>Manage Restaurants</h1>

<a href="addRestaurant.jsp" class="add-btn">
➕ Add Restaurant
</a>

<table>

<tr>

<th>ID</th>
<th>Image</th>
<th>Name</th>
<th>Cuisine</th>
<th>Delivery</th>
<th>Rating</th>
<th>Price For Two</th>
<th>Status</th>
<th>Action</th>

</tr>

<%
for(Restaurant restaurant : restaurants){
%>

<tr>

<td><%=restaurant.getRestaurantId()%></td>

<td>
<img src="images/<%=restaurant.getImageUrl()%>"
     width="80"
     height="60">
</td>

<td><%=restaurant.getName()%></td>

<td><%=restaurant.getCuisineType()%></td>

<td><%=restaurant.getDeliveryTime()%> mins</td>

<td>⭐ <%=restaurant.getRating()%></td>

<td>₹ <%=restaurant.getPriceForTwo()%></td>

<td>

<%=restaurant.isActive() ? "Active" : "Inactive"%>

</td>

<td>

<a href="editRestaurant?restaurantId=<%=restaurant.getRestaurantId()%>"
class="edit-btn">

Edit

</a>
<br>


<a href="deleteRestaurant?restaurantId=<%=restaurant.getRestaurantId()%>"
class="delete-btn"
onclick="return confirm('Delete this restaurant?')">

Delete

</a>

</td>

</tr>

<%
}
%>

</table>

</div>

</div>

</body>
</html>