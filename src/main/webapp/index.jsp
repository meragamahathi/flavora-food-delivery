<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Flavora | Taste Delivered With Love</title>

<link rel="preconnect" href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet" href="css/home.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar">

    <div class="logo">

        🍽️ FLAVORA

    </div>

    <ul class="nav-links">

        <li><a href="#">Home</a></li>

        <li><a href="restaurant">Restaurants</a></li>

        <li><a href="orderHistory.jsp">My Orders</a></li>

        <li><a href="cart.jsp">Cart</a></li>

        <li><a href="login.html">Login</a></li>

        <li><a href="signup.html">Sign Up</a></li>

    </ul>

    <div class="menu-icon">

        <i class="fa-solid fa-bars"></i>

    </div>

</nav>



<!-- ================= HERO SECTION ================= -->

<section class="hero">

    <video autoplay muted loop playsinline id="heroVideo" class="bg-video">

        <source src="videos/food1.mp4" type="video/mp4">

    </video>

    <div class="overlay"></div>

    <div class="hero-content">

        <span class="tagline">

            India's Favourite Food Delivery

        </span>

        <h2>

            Every Meal Delivered Fresh.

        </h2>

        <p>

            Discover restaurants near you and enjoy delicious food,

            fast delivery and unforgettable taste.

        </p>

        <div class="search-box">

            <i class="fa-solid fa-location-dot"></i>

            <input type="text"

            placeholder="Search restaurants, cuisines or dishes">

            <button class="explore-btn"

            onclick="goToRestaurants()">

                Explore Restaurants

            </button>

        </div>

    </div>

</section>



<!-- ================= POPULAR CATEGORIES ================= -->

<section class="categories">

    <h2>

        Popular Categories

    </h2>

    <p class="section-subtitle">

        Choose your favourite cuisine

    </p>

    <div class="category-container">

        <div class="category-card">

            <img src="images/pizza.jpg">

            <h3>Pizza</h3>

        </div>

        <div class="category-card">

            <img src="images/burger.jpg">

            <h3>Burger</h3>

        </div>

        <div class="category-card">

            <img src="images/biryani.jpg">

            <h3>Biryani</h3>

        </div>

        <div class="category-card">

            <img src="images/chinese.jpg">

            <h3>Chinese</h3>

        </div>

        <div class="category-card">

            <img src="images/dessert.jpg">

            <h3>Desserts</h3>

        </div>

    </div>

</section>



<!-- ================= POPULAR RESTAURANTS ================= -->

<section class="restaurants">

    <h2>

        Featured Restaurants

    </h2>

    <p class="section-subtitle">

        Loved by thousands of food lovers

    </p>

    <div class="restaurant-container">

        <div class="restaurant-card">

            <img src="images/burgerking.jpg">

            <div class="restaurant-info">

                <h3>Burger King</h3>

                <p>Burgers • Fast Food</p>

                <span>⭐ 4.5 | 25 mins</span>

            </div>

        </div>

        <div class="restaurant-card">

            <img src="images/dominos.jpg">

            <div class="restaurant-info">

                <h3>Domino's Pizza</h3>

                <p>Pizza</p>

                <span>⭐ 4.4 | 30 mins</span>

            </div>

        </div>

        <div class="restaurant-card">

            <img src="images/kfc.jpg">

            <div class="restaurant-info">

                <h3>KFC</h3>

                <p>Chicken</p>

                <span>⭐ 4.3 | 28 mins</span>

            </div>

        </div>

        <div class="restaurant-card">

            <img src="images/starbucks.jpg">

            <div class="restaurant-info">

                <h3>Starbucks</h3>

                <p>Coffee • Beverages</p>

                <span>⭐ 4.6 | 20 mins</span>

            </div>

        </div>

        <div class="restaurant-card">

            <img src="images/mcdonalds.jpg">

            <div class="restaurant-info">

                <h3>McDonald's</h3>

                <p>Burgers • Fries</p>

                <span>⭐ 4.5 | 22 mins</span>

            </div>

        </div>

        <div class="restaurant-card">

            <img src="images/barbeque.jpg">

            <div class="restaurant-info">

                <h3>Barbeque Nation</h3>

                <p>Barbecue • Grill</p>

                <span>⭐ 4.7 | 35 mins</span>

            </div>

        </div>

    </div>

</section>

<!-- ================= WHY CHOOSE US ================= -->

<section class="features">

    <h2>Why Choose Flavora?</h2>

    <p class="section-subtitle">

        We deliver happiness along with every meal.

    </p>

    <div class="feature-container">

        <div class="feature-card">

            <i class="fa-solid fa-motorcycle"></i>

            <h3>Lightning Fast Delivery</h3>

            <p>

                Get your favourite food delivered within 30 minutes.

            </p>

        </div>

        <div class="feature-card">

            <i class="fa-solid fa-bowl-food"></i>

            <h3>Fresh & Delicious</h3>

            <p>

                Prepared by top restaurants using fresh ingredients.

            </p>

        </div>

        <div class="feature-card">

            <i class="fa-solid fa-credit-card"></i>

            <h3>Secure Payments</h3>

            <p>

                Pay safely using UPI, Cards or Cash on Delivery.

            </p>

        </div>

        <div class="feature-card">

            <i class="fa-solid fa-headset"></i>

            <h3>24 × 7 Support</h3>

            <p>

                Our team is always ready to help you.

            </p>

        </div>

    </div>

</section>



<!-- ================= CUSTOMER REVIEWS ================= -->

<section class="reviews">

    <h2>What Our Customers Say</h2>

    <p class="section-subtitle">

        Trusted by thousands of happy food lovers.

    </p>

    <div class="review-container">

        <div class="review-card">

            <img src="images/user1.jpg" alt="Customer">

            <h3>Rahul Sharma</h3>

            <span>⭐⭐⭐⭐⭐</span>

            <p>

                Amazing delivery speed and delicious food.
                Highly recommended!

            </p>

        </div>

        <div class="review-card">

            <img src="images/user2.jpg" alt="Customer">

            <h3>Priya Reddy</h3>

            <span>⭐⭐⭐⭐⭐</span>

            <p>

                Beautiful interface and super easy ordering
                experience.

            </p>

        </div>

        <div class="review-card">

            <img src="images/user3.jpg" alt="Customer">

            <h3>Arjun Kumar</h3>

            <span>⭐⭐⭐⭐⭐</span>

            <p>

                Fresh food every time.
                Flavora has become my favourite.

            </p>

        </div>

    </div>

</section>



<!-- ================= DOWNLOAD APP ================= -->

<section class="download-app">

    <div class="download-left">

        <h2>

            Food Delivery

            <br>

            Made Simple

        </h2>

        <p>

            Browse restaurants, order your favourite meals,
            track deliveries in real-time and enjoy every bite.

        </p>

        <div class="download-buttons">

            <a href="#">

                <i class="fa-brands fa-google-play"></i>

                Google Play

            </a>

            <a href="#">

                <i class="fa-brands fa-apple"></i>

                App Store

            </a>

        </div>

    </div>

    <div class="download-right">

        <img src="images/mobile.png" alt="Mobile App">

    </div>

</section>



<!-- ================= FOOTER ================= -->

<footer>

    <div class="footer-container">

        <div class="footer-about">

            <h2>

                🍽️ Flavora

            </h2>

            <p>

                Bringing delicious food from your favourite restaurants
                straight to your doorstep.

            </p>

        </div>

        <div class="footer-links">

            <h3>Quick Links</h3>

            <a href="#">Home</a>

            <a href="restaurant">Restaurants</a>

            <a href="orderHistory">My Orders</a>

            <a href="cart.jsp">Cart</a>

        </div>

        <div class="footer-links">

            <h3>Support</h3>

            <a href="#">Help Center</a>

            <a href="#">Privacy Policy</a>

            <a href="#">Terms & Conditions</a>

            <a href="#">Contact Us</a>

        </div>

        <div class="footer-social">

            <h3>Follow Us</h3>

            <div class="social-icons">

                <a href="#"><i class="fa-brands fa-facebook-f"></i></a>

                <a href="#"><i class="fa-brands fa-instagram"></i></a>

                <a href="#"><i class="fa-brands fa-x-twitter"></i></a>

                <a href="#"><i class="fa-brands fa-linkedin-in"></i></a>

                <a href="#"><i class="fa-brands fa-github"></i></a>

            </div>

        </div>

    </div>

    <hr>

    <p class="copyright">

        © <span id="year">2026</span> Flavora. All Rights Reserved.

    </p>

</footer>



<!-- ================= JAVASCRIPT ================= -->

<script src="js/home.js"></script>

</body>

</html>
