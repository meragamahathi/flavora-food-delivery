<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.food.model.User"%>

<%
List<User> users=(List<User>)request.getAttribute("users");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Manage Users</title>

<link rel="stylesheet" href="css/adminUsers.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

<div class="sidebar">

<h2>🍴 FLAVORA</h2>

<ul>

<li><a href="adminDashboard">Dashboard</a></li>

<li class="active">Users</li>

<li><a href="adminRestaurants">Restaurants</a></li>

<li><a href="adminMenus">Menu</a></li>

<li><a href="adminOrders">Orders</a></li>

<li><a href="logout">Logout</a></li>

</ul>

</div>

<div class="content">

<h1>Manage Users</h1>

<table>

<tr>

<th>ID</th>

<th>Name</th>

<th>Email</th>

<th>Address</th>

<th>Role</th>

<th>Status</th>

<th>Created</th>

<th>Action</th>

</tr>

<%

for(User user:users){

%>

<tr>

<td><%=user.getUserId()%></td>

<td><%=user.getUserName()%></td>

<td><%=user.getEmail()%></td>

<td><%=user.getAddress()%></td>

<td><%=user.getRole()%></td>

<td><%=user.getStatus()%></td>


<td>
<%= (user.getCreateDate() != null)
        ? new java.text.SimpleDateFormat("dd MMM yyyy").format(user.getCreateDate())
        : "26 Jun 2026" %>
</td>

<td>

<% if(user.getStatus().equalsIgnoreCase("Active")){ %>

<a href="userStatus?userId=<%=user.getUserId()%>&status=Blocked"
   class="block-btn"
   onclick="return confirm('Block this user?')">
    Block
</a>

<% } else { %>

<a href="userStatus?userId=<%=user.getUserId()%>&status=Active"
   class="unblock-btn"
   onclick="return confirm('Unblock this user?')">
    Unblock
</a>

<% } %>

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