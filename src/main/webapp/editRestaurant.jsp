<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.food.model.Restaurant"%>

<%
Restaurant restaurant = (Restaurant)request.getAttribute("restaurant");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Edit Restaurant</title>

<link rel="stylesheet" href="css/addRestaurant.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

<div class="form-box">

<h2>✏️ Edit Restaurant</h2>

<form action="editRestaurant" method="post">

<input type="hidden"
       name="restaurantId"
       value="<%=restaurant.getRestaurantId()%>">

<label>Restaurant Name</label>
<input type="text"
       name="name"
       value="<%=restaurant.getName()%>"
       required>

<label>Cuisine Type</label>
<input type="text"
       name="cuisineType"
       value="<%=restaurant.getCuisineType()%>"
       required>

<label>Delivery Time</label>
<input type="number"
       name="deliveryTime"
       value="<%=restaurant.getDeliveryTime()%>"
       required>

<label>Address</label>
<textarea name="address" rows="3"><%=restaurant.getAddress()%></textarea>

<label>Admin User ID</label>
<input type="number"
       name="adminUserId"
       value="<%=restaurant.getAdminUserId()%>"
       required>

<label>Rating</label>
<input type="number"
       step="0.1"
       min="0"
       max="5"
       name="rating"
       value="<%=restaurant.getRating()%>"
       required>

<label>Price For Two</label>
<input type="number"
       name="priceForTwo"
       value="<%=restaurant.getPriceForTwo()%>"
       required>

<label>Image</label>
<input type="text"
       name="imageUrl"
       value="<%=restaurant.getImageUrl()%>"
       required>

<label>Status</label>

<select name="isActive">

<option value="true"
<%=restaurant.isActive() ? "selected" : ""%>>

Active

</option>

<option value="false"
<%=!restaurant.isActive() ? "selected" : ""%>>

Inactive

</option>

</select>

<div class="buttons">

<button class="save-btn">

Update Restaurant

</button>

<a href="adminRestaurants"
class="cancel-btn">

Cancel

</a>

</div>

</form>

</div>

</div>

</body>
</html>