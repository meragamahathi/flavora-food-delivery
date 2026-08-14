package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addRestaurant")
public class AddRestaurantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String cuisineType = req.getParameter("cuisineType");
        int deliveryTime = Integer.parseInt(req.getParameter("deliveryTime"));
        String address = req.getParameter("address");
        int adminUserId = Integer.parseInt(req.getParameter("adminUserId"));
        double rating = Double.parseDouble(req.getParameter("rating"));
        boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
        String imageUrl = req.getParameter("imageUrl");
        int priceForTwo = Integer.parseInt(req.getParameter("priceForTwo"));

        Restaurant restaurant = new Restaurant(
                name,
                cuisineType,
                deliveryTime,
                address,
                adminUserId,
                rating,
                isActive,
                imageUrl,
                priceForTwo
        );
        
        RestaurantDAOImpl dao = new RestaurantDAOImpl();

        dao.addRestaurant(restaurant);

        resp.sendRedirect("adminRestaurants");
    }
}