package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.MenuDAOImpl;
import com.food.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminMenus")
public class AdminMenusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        MenuDAOImpl dao = new MenuDAOImpl();

        List<Menu> menus = dao.getAllMenus();

        req.setAttribute("menus", menus);

        RequestDispatcher rd =
                req.getRequestDispatcher("adminMenus.jsp");

        rd.forward(req, resp);
    }
}
