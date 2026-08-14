package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminRestaurants")
public class AdminRestaurantsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RestaurantDAOImpl dao = new RestaurantDAOImpl();

        List<Restaurant> restaurants = dao.getAllRestaurants();

        req.setAttribute("restaurants", restaurants);

        RequestDispatcher rd = req.getRequestDispatcher("adminRestaurants.jsp");

        rd.forward(req, resp);
    }
}