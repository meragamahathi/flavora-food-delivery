<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@page import="com.food.model.User"%>

<%
User user=(User)request.getAttribute("user");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Delivery Profile</title>

<link rel="stylesheet"
href="css/deliveryProfile.css">

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

<li>

<a href="deliveryHistory">

<i class="fa-solid fa-clock-rotate-left"></i>

History

</a>

</li>

<li class="active">

<i class="fa-solid fa-user"></i>

Profile

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

<h1>Delivery Agent Profile</h1>

<div class="profile-card">

<div class="avatar">

<i class="fa-solid fa-user"></i>

</div>

<h2><%=user.getUserName()%></h2>

<p class="role">

<%=user.getRole()%>

</p>

<div class="info">

<div>

<span>User ID</span>

<h3><%=user.getUserId()%></h3>

</div>

<div>

<span>Email</span>

<h3><%=user.getEmail()%></h3>

</div>

<div>

<span>Address</span>

<h3><%=user.getAddress()%></h3>

</div>

<div>

<span>Status</span>

<h3>

<%=user.getStatus()%>

</h3>

</div>

<div>

<span>Joined</span>

<h3>

<%
if(user.getCreateDate()!=null){
%>

<%=new java.text.SimpleDateFormat("dd MMM yyyy")
.format(user.getCreateDate())%>

<%
}else{
%>

Not Available

<%
}
%>

</h3>

</div>

<div>

<span>Last Login</span>

<h3>

<%
if(user.getLastLoginDate()!=null){
%>

<%=new java.text.SimpleDateFormat("dd MMM yyyy hh:mm a")
.format(user.getLastLoginDate())%>

<%
}else{
%>

Not Available

<%
}
%>

</h3>

</div>

</div>

<a href="deliveryDashboard"
class="back">

← Back to Dashboard

</a>

</div>

</div>

</div>

</body>

</html>