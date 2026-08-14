<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.food.model.Menu"%>

<%
List<Menu> menus = (List<Menu>)request.getAttribute("menus");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Manage Menus</title>

<link rel="stylesheet" href="css/adminMenus.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

<div class="sidebar">

<h2>🍴 FLAVORA</h2>

<ul>

<li><a href="adminDashboard">Dashboard</a></li>

<li><a href="adminUsers">Users</a></li>

<li><a href="adminRestaurants">Restaurants</a></li>

<li class="active">Menu</li>

<li><a href="adminOrders">Orders</a></li>

<li><a href="logout">Logout</a></li>

</ul>

</div>

<div class="content">

<h1>Manage Menu</h1>

<a href="addMenuPage" class="add-btn">
➕ Add Menu
</a>

<table>

<tr>

<th>ID</th>
<th>Restaurant ID</th>
<th>Image</th>
<th>Item Name</th>
<th>Description</th>
<th>Category</th>
<th>Price</th>
<th>Status</th>
<th>Action</th>

</tr>

<%
for(Menu menu : menus){
%>

<tr>

<td><%=menu.getMenuId()%></td>

<td><%=menu.getRestaurantId()%></td>

<td>

<img src="images/<%=menu.getImageUrl()%>"
width="70"
height="60">

</td>

<td><%=menu.getItemName()%></td>

<td><%=menu.getDescription()%></td>

<td><%=menu.getCategory()%></td>

<td>₹ <%=menu.getPrice()%></td>

<td>

<%=menu.isAvailable() ? "Available" : "Unavailable"%>

</td>

<td>

<a href="editMenu?menuId=<%=menu.getMenuId()%>"
class="edit-btn">

Edit

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