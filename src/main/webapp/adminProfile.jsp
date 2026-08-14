<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.food.model.User"%>

<%
User admin = (User)request.getAttribute("admin");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Admin Profile</title>

<link rel="stylesheet" href="css/adminProfile.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

    <div class="profile-card">

        <div class="profile-header">

            <div class="avatar">
                👤
            </div>

            <h1>ADMIN PROFILE</h1>

        </div>

        <div class="profile-info">

            <div class="info-box">

                <label>Username</label>

                <p><%=admin.getUserName()%></p>

            </div>

            <div class="info-box">

                <label>Email Address</label>

                <p><%=admin.getEmail()%></p>

            </div>

            <div class="info-box">

                <label>Address</label>

                <p><%=admin.getAddress()%></p>

            </div>

            <div class="info-box">

                <label>Role</label>

                <p><%=admin.getRole()%></p>

            </div>

            <div class="info-box">

                <label>Account Status</label>

                <p><%=admin.getStatus()%></p>

            </div>

            <div class="info-box">

                <label>Joined On</label>

                <p><%=admin.getCreateDate()%></p>

            </div>

            <div class="info-box">

                <label>Last Login</label>

                <p><%=admin.getLastLoginDate()%></p>

            </div>

        </div>

        <div class="buttons">

            <a href="editProfile" class="edit-btn">
                ✏ Edit Profile
            </a>

            <a href="changePassword" class="password-btn">
                🔒 Change Password
            </a>

        </div>

    </div>

</div>

</body>
</html>