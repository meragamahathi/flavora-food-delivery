<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Add Restaurant</title>

<link rel="stylesheet" href="css/addRestaurant.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

</head>

<body>

<div class="container">

    <div class="form-box">

        <h2>🍴 Add Restaurant</h2>

        <form action="addRestaurant" method="post">

            <label>Restaurant Name</label>
            <input type="text" name="name" required>

            <label>Cuisine Type</label>
            <input type="text" name="cuisineType" required>

            <label>Delivery Time (Minutes)</label>
            <input type="number" name="deliveryTime" required><br>

            <label>Address</label>
            <textarea name="address" rows="3" required></textarea><br>

            <label>Admin User ID</label>
            <input type="number" name="adminUserId" required><br>

            <label>Rating</label>
            <input type="number"
                   name="rating"
                   step="0.1"
                   min="0"
                   max="5"
                   required><br>

            <label>Price For Two (₹)</label>
            <input type="number" name="priceForTwo" required><br>

            <label>Restaurant Image</label>
            <input type="text"
                   name="imageUrl"
                   placeholder="pizza_hut.jpg"
                   required><br>

            <label>Status</label>

            <select name="isActive">

                <option value="true">Active</option>

                <option value="false">Inactive</option>

            </select>

            <div class="buttons">

                <button type="submit" class="save-btn">

                    Save Restaurant

                </button>

                <a href="adminRestaurants" class="cancel-btn">

                    Cancel

                </a>

            </div>

        </form>

    </div>

</div>

</body>
</html>