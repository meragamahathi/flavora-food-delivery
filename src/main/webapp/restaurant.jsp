<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.food.model.Restaurant"%>

<%@ page import="com.food.model.User"%>

<%
User loggedUser = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Flavora | Restaurants</title>

<link rel="stylesheet" href="css/restaurant.css">

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar">

    <div class="logo">

        🍴 FLAVORA

    </div>

    <ul>

        <li><a href="index.jsp">Home</a></li>

        <li><a href="orderHistory.jsp">My Orders</a></li>

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



<!-- ================= SEARCH ================= -->

<section class="search-section">

    <h1>Discover Amazing Restaurants</h1>

    <div class="search-box">

        <i class="fa-solid fa-magnifying-glass"></i>

        <input
        type="text"
        id="searchInput"
        placeholder="Search Restaurant or Cuisine...">

    </div>

</section>



<!-- ================= SORT ================= -->

<section class="sort-section">

    <label>Sort By :</label>

    <select id="sortSelect">

        <option value="default">Default</option>

        <option value="rating">Rating</option>

        <option value="delivery">Delivery Time</option>

        <option value="price">Price For Two</option>

    </select>

</section>



<!-- ================= RESTAURANTS ================= -->

<section class="restaurants">

<%

List<Restaurant> restaurants=(List<Restaurant>)request.getAttribute("restaurants");

if(restaurants!=null && !restaurants.isEmpty()){

for(Restaurant restaurant:restaurants){

%>

<div class="restaurant-card">

    <img
    src="images/<%=restaurant.getImageUrl()%>"
    alt="<%=restaurant.getName()%>">

    <div class="card-body">

        <div class="title-row">

            <h2 class="restaurant-name">

                <%=restaurant.getName()%>

            </h2>

            <span class="rating">

                ⭐ <%=restaurant.getRating()%>

            </span>

        </div>

        <p class="cuisine">

            <%=restaurant.getCuisineType()%>

        </p>

        <p>

            <i class="fa-solid fa-location-dot"></i>

            <%=restaurant.getAddress()%>

        </p>

        <div class="details">

            <span>

                <i class="fa-regular fa-clock"></i>

                <%=restaurant.getDeliveryTime()%> mins

            </span>

            <span>

                ₹<%=restaurant.getPriceForTwo()%> for two

            </span>

        </div>

        <div class="status">

        <% if(restaurant.isActive()){ %>

            <span class="open">

                Open

            </span>

        <% } else { %>

            <span class="closed">

                Closed

            </span>

        <% } %>

        </div>

        <div class="menu-btn">

            <a href="MenuServlet?restaurantId=<%=restaurant.getRestaurantId()%>&restaurantName=<%=restaurant.getName() %>">

                View Menu

            </a>

        </div>

    </div>

</div>

<%

}

}

else{

%>

<div class="no-data">

<h2>No Restaurants Available</h2>

</div>

<%

}

%>

</section>



<script src="js/restaurant.js"></script>

</body>

</html>