<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Flavora Admin Dashboard</title>

<link rel="stylesheet" href="css/adminDashboard.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

    <!-- Sidebar -->

    <div class="sidebar">

        <h2>🍴 FLAVORA</h2>

        <ul>

            <li class="active">
                <a href="adminDashboard">🏠 Dashboard</a>
            </li>

            <li>
                <a href="adminUsers">👥 Users</a>
            </li>

            <li>
                <a href="adminRestaurants">🍴 Restaurants</a>
            </li>

            <li>
                <a href="adminMenus">🍕 Menu</a>
            </li>

            <li>
                <a href="adminOrders">📦 Orders</a>
            </li>

            <li>
                <a href="#">📊 Reports</a>
            </li>

            <li>
                <a href="adminProfile">👤 Profile</a>
            </li>

            <li>
                <a href="logout">🚪 Logout</a>
            </li>

        </ul>

    </div>

    <!-- Main Content -->

    <div class="main">

        <div class="topbar">

            <div>

                <h1>Dashboard</h1>

                <p class="welcome-text">
                    Welcome back, Admin 👋
                </p>

            </div>

        </div>

        <!-- Statistics Cards -->

        <div class="cards">

            <div class="card users">

                <div class="icon">
                    👥
                </div>

                <div>

                    <h2>${totalUsers}</h2>

                    <p>Total Users</p>

                </div>

            </div>

            <div class="card restaurants">

                <div class="icon">
                    🍴
                </div>

                <div>

                    <h2>${totalRestaurants}</h2>

                    <p>Restaurants</p>

                </div>

            </div>

            <div class="card orders">

                <div class="icon">
                    📦
                </div>

                <div>

                    <h2>${totalOrders}</h2>

                    <p>Total Orders</p>

                </div>

            </div>

            <div class="card menus">

                <div class="icon">
                    🍕
                </div>

                <div>

                    <h2>${totalMenus}</h2>

                    <p>Menu Items</p>

                </div>

            </div>

        </div>

        <!-- Quick Actions -->

        <div class="quick-actions">

            <h2>Quick Actions</h2>

            <div class="quick-grid">

                <a href="addRestaurant.jsp" class="quick-card">

                    <div class="quick-icon">➕</div>

                    <span>Add Restaurant</span>

                </a>

                <a href="addMenuPage" class="quick-card">

                    <div class="quick-icon">🍽</div>

                    <span>Add Menu</span>

                </a>

                <a href="adminUsers" class="quick-card">

                    <div class="quick-icon">👥</div>

                    <span>Manage Users</span>

                </a>

                <a href="adminOrders" class="quick-card">

                    <div class="quick-icon">📦</div>

                    <span>Manage Orders</span>

                </a>

            </div>

        </div>

    </div>

</div>

</body>
</html>