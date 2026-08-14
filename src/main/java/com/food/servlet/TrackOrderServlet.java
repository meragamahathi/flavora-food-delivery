package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.OrderDAOImpl;
import com.food.model.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/trackOrder")
public class TrackOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(req.getParameter("orderId"));

        OrderDAOImpl orderDAO = new OrderDAOImpl();

        Order order = orderDAO.getOrder(orderId);

        req.setAttribute("order", order);

        RequestDispatcher rd = req.getRequestDispatcher("trackOrder.jsp");
        rd.forward(req, resp);
    }
}