package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.MenuDAOImpl;
import com.food.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editMenu")
public class EditMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        int menuId =
                Integer.parseInt(req.getParameter("menuId"));

        MenuDAOImpl dao = new MenuDAOImpl();

        Menu menu = dao.getMenu(menuId);

        req.setAttribute("menu", menu);

        req.getRequestDispatcher("editMenu.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        int menuId =
                Integer.parseInt(req.getParameter("menuId"));

        int restaurantId =
                Integer.parseInt(req.getParameter("restaurantId"));

        String itemName = req.getParameter("itemName");
        String description = req.getParameter("description");

        double price =
                Double.parseDouble(req.getParameter("price"));

        boolean isAvailable =
                Boolean.parseBoolean(req.getParameter("isAvailable"));

        String category = req.getParameter("category");

        String imageUrl = req.getParameter("imageUrl");

        Menu menu = new Menu(
                menuId,
                restaurantId,
                itemName,
                description,
                price,
                isAvailable,
                category,
                imageUrl
        );

        MenuDAOImpl dao = new MenuDAOImpl();

        dao.updateMenu(menu);

        resp.sendRedirect("adminMenus");
    }
}