package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.RestaurantDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteRestaurant")
public class DeleteRestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        int restaurantId =
                Integer.parseInt(req.getParameter("restaurantId"));

        RestaurantDAOImpl dao =
                new RestaurantDAOImpl();

        dao.deleteRestaurant(restaurantId);

        resp.sendRedirect("adminRestaurants");
    }
}