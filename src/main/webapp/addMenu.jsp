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

<title>Add Menu</title>

<link rel="stylesheet" href="css/addMenu.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

<div class="form-box">

<h2>🍽 Add Menu Item</h2>

<form action="addMenu" method="post">

<label>Restaurant</label>

<select name="restaurantId" required>

<%
for(Restaurant restaurant : restaurants){
%>

<option value="<%=restaurant.getRestaurantId()%>">
    <%=restaurant.getName()%>
</option>

<%
}
%>

</select>

<label>Item Name</label>
<input type="text"
name="itemName"
required>

<label>Description</label>
<textarea
name="description"
rows="3"
required></textarea>

<label>Price</label>
<input type="number"
step="0.01"
name="price"
required>

<label>Category</label>

<select name="category">

<option value="Veg">Veg</option>

<option value="Non-Veg">Non-Veg</option>

<option value="Dessert">Dessert</option>

<option value="Beverage">Beverage</option>

</select>

<label>Available</label>

<select name="isAvailable">

<option value="true">Yes</option>

<option value="false">No</option>

</select>

<label>Image</label>

<input type="text"
name="imageUrl"
placeholder="burger.jpg"
required>

<div class="buttons">

<button type="submit"
class="save-btn">

Save Menu

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