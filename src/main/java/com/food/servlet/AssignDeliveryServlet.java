package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.OrderDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/assignDelivery")
public class AssignDeliveryServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException,IOException{
  

        int orderId=Integer.parseInt(req.getParameter("orderId"));

        int deliveryAgentId=Integer.parseInt(req.getParameter("deliveryAgentId"));
        

        OrderDAOImpl dao=new OrderDAOImpl();

        dao.assignDeliveryAgent(orderId,deliveryAgentId);

        resp.sendRedirect("adminOrders");
    }
}