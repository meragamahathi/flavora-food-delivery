package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.OrderDAOImpl;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.Order;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminOrders")
public class AdminOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        OrderDAOImpl dao = new OrderDAOImpl();

        List<Order> orders = dao.getAllOrders();

        req.setAttribute("orders", orders);
        
        UserDAOImpl userDAO=new UserDAOImpl();

        List<User> agents=userDAO.getAllDeliveryAgents();

        req.setAttribute("agents",agents);

        req.getRequestDispatcher("adminOrders.jsp")
                .forward(req, resp);
    }
}