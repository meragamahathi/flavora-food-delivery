<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="java.util.Map"%>
<%@page import="com.food.model.Cart"%>
<%@page import="com.food.model.CartItem"%>

<%@ page import="com.food.model.User"%>

<%
User loggedUser = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Flavora | Cart</title>

<link rel="stylesheet" href="css/cart.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>

<nav class="navbar">

    <h2>🍴 FLAVORA</h2>

    <ul>

        <li><a href="index.jsp">Home</a></li>

        <li><a href="restaurant">Restaurants</a></li>
        
        
        <li><a href="orderHistory">My Orders</a></li>
        

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


<%

Cart cart=(Cart)session.getAttribute("cart");

double grandTotal=0;

%>
<h2>
🛒 My Cart
(<%= (cart != null) ? cart.getItems().size() : 0 %> items)
</h2>

<% 
if(cart!=null && !cart.getItems().isEmpty()){

for(CartItem item:cart.getItems().values()){

double total=item.getTotalPrice();

grandTotal+=total;

%>

<div class="cart-card">

<div class="left">

<img src="<%=request.getContextPath()%>/images/<%=item.getImageUrl()%>"
     alt="<%=item.getName()%>">

</div>

<div class="middle">

<h3><%=item.getName()%></h3>

<p>₹ <%=item.getPrice()%></p>

</div>

<div class="right">

<div class="quantity">

<form action="cartServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden" name="menuId" value="<%=item.getMenuId()%>">

<input type="hidden" name="restaurantId" value="<%=item.getRestaurantId()%>">

<input type="hidden" name="quantity" value="<%=item.getQuantity()-1%>">

<button>-</button>

</form>

<span><%=item.getQuantity()%></span>

<form action="cartServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden" name="menuId" value="<%=item.getMenuId()%>">

<input type="hidden" name="restaurantId" value="<%=item.getRestaurantId()%>">

<input type="hidden" name="quantity" value="<%=item.getQuantity()+1%>">

<button>+</button>

</form>

</div>

<h2>₹ <%=total%></h2>

<form action="cartServlet" method="post">

<input type="hidden" name="action" value="delete">

<input type="hidden" name="menuId" value="<%=item.getMenuId()%>">

<input type="hidden" name="restaurantId" value="<%=item.getRestaurantId()%>">

<button class="remove">Remove</button>

</form>

</div>

</div>

<%

}

%>
<div class="cart-footer">

    <div class="add-items">

        <a href="restaurant" class="add-more-btn">
            🛍️ Add More Items
        </a>

   </div>

<div class="checkout">

<h2>Total : ₹ <%=grandTotal%></h2>

<a href="checkout.jsp" class="checkout-btn">

Proceed to Checkout

</a>

</div>

<%

}

else{

%>

<div class="empty">

<h2>Your Cart is Empty 🛒</h2>

<a href="restaurant">Explore Restaurants</a>

</div>

<%

}

%>

</div>

</body>

</html> 