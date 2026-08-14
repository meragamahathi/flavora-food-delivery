package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.OrderDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateOrderStatus")
public class UpdateOrderStatusServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
    	System.out.println("UpdateOrderStatusServlet called");

        int orderId =
                Integer.parseInt(req.getParameter("orderId"));

        String status =
                req.getParameter("status");

        OrderDAOImpl dao = new OrderDAOImpl();

        dao.updateOrderStatus(orderId, status);

        resp.sendRedirect("adminOrders");
    }
}