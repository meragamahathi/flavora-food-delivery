package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.MenuDAOImpl;
import com.food.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addMenu")
public class AddMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        String itemName = req.getParameter("itemName");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        boolean isAvailable = Boolean.parseBoolean(req.getParameter("isAvailable"));
        String category = req.getParameter("category");
        String imageUrl = req.getParameter("imageUrl");

        Menu menu = new Menu(
                restaurantId,
                itemName,
                description,
                price,
                isAvailable,
                category,
                imageUrl
        );

        MenuDAOImpl dao = new MenuDAOImpl();

        dao.addMenu(menu);

        resp.sendRedirect("adminMenus");
    }
}