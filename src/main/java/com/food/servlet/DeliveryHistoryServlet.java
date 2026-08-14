package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.OrderDAOImpl;
import com.food.model.Order;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deliveryHistory")
public class DeliveryHistoryServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        User user = (User)session.getAttribute("user");

        if(user==null){
            resp.sendRedirect("login.html");
            return;
        }

        OrderDAOImpl dao = new OrderDAOImpl();

        List<Order> history =
                dao.getDeliveredOrders(user.getUserId());

        req.setAttribute("orders", history);

        req.getRequestDispatcher("deliveryHistory.jsp")
        .forward(req, resp);
    }
}