<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="com.food.model.Menu"%>

<%
Menu menu = (Menu)request.getAttribute("menu");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Edit Menu</title>

<link rel="stylesheet" href="css/addMenu.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

<div class="form-box">

<h2>✏️ Edit Menu Item</h2>

<form action="editMenu" method="post">

<input type="hidden"
name="menuId"
value="<%=menu.getMenuId()%>">

<label>Restaurant ID</label>

<input type="number"
name="restaurantId"
value="<%=menu.getRestaurantId()%>"
required>

<label>Item Name</label>

<input type="text"
name="itemName"
value="<%=menu.getItemName()%>"
required>

<label>Description</label>

<textarea
name="description"
rows="3"
required><%=menu.getDescription()%></textarea>

<label>Price</label>

<input type="number"
step="0.01"
name="price"
value="<%=menu.getPrice()%>"
required>

<label>Category</label>

<select name="category">

<option value="Veg"
<%=menu.getCategory().equals("Veg") ? "selected" : ""%>>
Veg
</option>

<option value="Non-Veg"
<%=menu.getCategory().equals("Non-Veg") ? "selected" : ""%>>
Non-Veg
</option>

<option value="Dessert"
<%=menu.getCategory().equals("Dessert") ? "selected" : ""%>>
Dessert
</option>

<option value="Beverage"
<%=menu.getCategory().equals("Beverage") ? "selected" : ""%>>
Beverage
</option>

</select>

<label>Available</label>

<select name="isAvailable">

<option value="true"
<%=menu.isAvailable() ? "selected" : ""%>>
Yes
</option>

<option value="false"
<%=!menu.isAvailable() ? "selected" : ""%>>
No
</option>

</select>

<label>Image</label>

<input type="text"
name="imageUrl"
value="<%=menu.getImageUrl()%>"
required>

<div class="buttons">

<button class="save-btn">

Update Menu

</button>

<a href="adminMenus"
class="cancel-btn">

Cancel

</a>

</div>

</form>

</div>

</div>

</body>

</html>