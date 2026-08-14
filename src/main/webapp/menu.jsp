<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.food.model.Menu"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Flavora | Menu</title>

<link rel="stylesheet" href="css/menu.css">

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<!-- Navbar -->

<nav class="navbar">

    <div class="logo">
        🍴 FLAVORA
    </div>

    <ul>

        <li><a href="index.jsp">Home</a></li>

        <li><a href="restaurant">Restaurants</a></li>

        <li><a href="#">Cart</a></li>

        <li><a href="#">Profile</a></li>

    </ul>

</nav>



<!-- Heading -->

<section class="heading">

    <h1>Restaurant Menu</h1>

    <p>Choose your favourite dishes</p>

</section>



<!-- Menu Cards -->

<section class="menu-container">

<%

List<Menu> menus=(List<Menu>)request.getAttribute("allMenusByRestaurant");

if(menus!=null && !menus.isEmpty()){

for(Menu menu:menus){

%>

<div class="menu-card">
 
     <img src="images/<%=menu.getImageUrl()%>"
         alt="<%=menu.getItemName()%>">

    <div class="menu-details">

        <h2>

            <%=menu.getItemName()%>

        </h2>

        <p class="category">

            <%=menu.getCategory()%>

        </p>

        <p class="description">

            <%=menu.getDescription()%>

        </p>

        <h3>

            ₹ <%=menu.getPrice()%>

        </h3>

        <% if(menu.isAvailable()){ %>

        <span class="available">

            Available

        </span>

        <% } else{ %>

        <span class="notavailable">

            Not Available

        </span>

        <% } %>

        <br><br>
        
        <form action="cartServlet" method="post">
          <input type="hidden" name="menuId" value="<%= menu.getMenuId()%>">
          <input type="hidden" name="restaurantId" value="<%= menu.getRestaurantId()%>">
          <input type="hidden" name="quantity" value="1">
          <input type="hidden" name="action" value="add">
          <button type="submit" class="add-btn">Add to Cart</button>
        </form>
        
        
    </div>

</div>

<%

}

}

else{

%>

<h2 class="empty">

No Menu Items Available

</h2>

<%

}

%>

</section>

</body>

</html>