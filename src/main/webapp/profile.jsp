<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.food.model.User"%>

<%
    // Require login to view this page
    User loggedInUser = (User) session.getAttribute("user");

    if (loggedInUser == null) {
        response.sendRedirect("login.html");
        return;
    }

    // Initial letter for the avatar circle
    String initial = (loggedInUser.getUserName() != null && loggedInUser.getUserName().length() > 0)
            ? loggedInUser.getUserName().substring(0, 1).toUpperCase()
            : "?";
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Flavora | My Profile</title>

<link rel="preconnect" href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet" href="css/profile.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar">

    <div class="logo">🍽️ FLAVORA</div>

    <ul class="nav-links">

        <li><a href="index.jsp">Home</a></li>

        <li><a href="restaurant">Restaurants</a></li>

        <li><a href="orderHistory">My Orders</a></li>

        <li><a href="cart.jsp">Cart</a></li>

        <li><a href="profile.jsp" class="active">Profile</a></li>

    </ul>

    <div class="menu-icon">

        <i class="fa-solid fa-bars"></i>

    </div>

</nav>

<!-- ================= PROFILE HEADER BANNER ================= -->

<section class="profile-banner">

    <div class="profile-banner-content">

        <div class="avatar-circle"><%= initial %></div>

        <div class="profile-banner-info">

            <h1><%= loggedInUser.getUserName() %></h1>

            <p><i class="fa-solid fa-envelope"></i> <%= loggedInUser.getEmail() %></p>

            <% if (loggedInUser.getCreateDate() != null) { %>

            <p class="member-since"><i class="fa-solid fa-calendar"></i> Member since <%= new java.text.SimpleDateFormat("MMMM yyyy").format(loggedInUser.getCreateDate()) %></p>

            <% } %>

            <span class="role-badge"><%= loggedInUser.getRole() %></span>

        </div>

    </div>

</section>

<!-- ================= MAIN CONTENT ================= -->

<div class="profile-container">

    <!-- ===== QUICK STATS ===== -->

    <div class="stats-row">

        <div class="stat-card">

            <i class="fa-solid fa-bag-shopping"></i>

            <h3 id="statOrders">--</h3>

            <p>Total Orders</p>

        </div>

        <div class="stat-card">

            <i class="fa-solid fa-heart"></i>

            <h3 id="statFavourites">--</h3>

            <p>Favourite Restaurants</p>

        </div>

        <div class="stat-card">

            <i class="fa-solid fa-star"></i>

            <h3 id="statReviews">--</h3>

            <p>Reviews Given</p>

        </div>

    </div>

    <div class="profile-grid">

        <!-- ===== PERSONAL INFO ===== -->

        <div class="profile-card">

            <div class="profile-card-header">

                <h2><i class="fa-solid fa-user"></i> Personal Information</h2>

                <button type="button" class="edit-btn" id="editToggleBtn" onclick="toggleEdit()">

                    <i class="fa-solid fa-pen"></i> Edit

                </button>

            </div>

            <form action="ProfileServlet" method="post" id="profileForm">

                <div class="form-row">

                    <label>Username</label>

                    <input type="text" name="userName" value="<%= loggedInUser.getUserName() %>" disabled required>

                </div>

                <div class="form-row">

                    <label>Email</label>

                    <input type="email" name="email" value="<%= loggedInUser.getEmail() %>" disabled required>

                </div>

                <div class="form-row">

                    <label>Delivery Address</label>

                    <input type="text" name="address" value="<%= loggedInUser.getAddress() %>" disabled required>

                </div>

                <div class="form-actions" id="formActions">

                    <button type="submit" class="save-btn">Save Changes</button>

                    <button type="button" class="cancel-btn" onclick="toggleEdit()">Cancel</button>

                </div>

            </form>

        </div>

        <!-- ===== ACCOUNT ACTIONS ===== -->

        <div class="profile-card">

            <div class="profile-card-header">

                <h2><i class="fa-solid fa-gear"></i> Account</h2>

            </div>

            <a href="orderHistory" class="account-link">

                <i class="fa-solid fa-clock-rotate-left"></i>

                <span>Order History</span>

                <i class="fa-solid fa-chevron-right"></i>

            </a>

            <a href="cart.jsp" class="account-link">

                <i class="fa-solid fa-cart-shopping"></i>

                <span>My Cart</span>

                <i class="fa-solid fa-chevron-right"></i>

            </a>

            <a href="#" class="account-link" onclick="openChangePasswordPopup(); return false;">

                <i class="fa-solid fa-lock"></i>

                <span>Change Password</span>

                <i class="fa-solid fa-chevron-right"></i>

            </a>

            <a href="logout" class="account-link logout-link">

                <i class="fa-solid fa-right-from-bracket"></i>

                <span>Logout</span>

                <i class="fa-solid fa-chevron-right"></i>

            </a>

        </div>

    </div>

</div>

<!-- ================= CHANGE PASSWORD POPUP ================= -->

<div class="login-popup-overlay" id="changePasswordOverlay">

    <div class="login-popup-box">

        <button type="button" class="login-popup-close" onclick="closeChangePasswordPopup()">&times;</button>

        <h2>Change Password</h2>

        <p class="login-popup-subtitle">
            Enter your current password and choose a new one.
        </p>

        <form action="ChangePasswordServlet" method="post">

            <input type="password" name="currentPassword" placeholder="Current Password" required>

            <input type="password" name="newPassword" placeholder="New Password" required minlength="6">

            <input type="password" name="confirmPassword" placeholder="Confirm New Password" required minlength="6">

            <button type="submit">Update Password</button>

        </form>

    </div>

</div>

<script src="js/profile.js"></script>

</body>

</html>
