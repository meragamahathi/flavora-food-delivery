package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addMenuPage")
public class AddMenuPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RestaurantDAOImpl dao = new RestaurantDAOImpl();

        List<Restaurant> restaurants = dao.getAllRestaurants();

        req.setAttribute("restaurants", restaurants);

        req.getRequestDispatcher("addMenu.jsp").forward(req, resp);
    }
}