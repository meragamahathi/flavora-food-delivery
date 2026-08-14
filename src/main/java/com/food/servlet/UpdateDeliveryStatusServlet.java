package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.OrderDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateDeliveryStatus")
public class UpdateDeliveryStatusServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        int orderId =
        Integer.parseInt(req.getParameter("orderId"));

        String status =
        req.getParameter("status");

        OrderDAOImpl dao = new OrderDAOImpl();

        dao.updateDeliveryStatus(orderId, status);

        resp.sendRedirect(
        "deliveryOrderDetails?orderId=" + orderId);
    }
}