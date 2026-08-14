package com.food.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.food.daoimpl.OrderDAOImpl;
import com.food.model.Order;
import com.food.model.User;
import com.food.daoimpl.MenuDAOImpl;
import com.food.daoimpl.OrderItemDAOImpl;
import com.food.model.CartItem;
import com.food.model.Menu;
import com.food.model.OrderDetails;
import com.food.model.OrderItem;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {

            session.setAttribute("loginFrom", "orderHistory");
            resp.sendRedirect("login.html");
            return;
        }

        OrderDAOImpl orderDAO = new OrderDAOImpl();

        List<Order> orderList = orderDAO.getOrdersByUserId(user.getUserId());
        
        System.out.println("Logged User ID = " + user.getUserId());
        System.out.println("Orders Found = " + orderList.size());

//        req.setAttribute("orders", orderList);
          
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();

        List<OrderDetails> orderDetailsList = new ArrayList<>();

        for (Order order : orderList) {

            List<OrderItem> orderItems = orderItemDAO.getOrderItemsByOrderId(order.getOrderId());

            List<CartItem> cartItems = new ArrayList<>();

            for (OrderItem oi : orderItems) {

                Menu menu = menuDAO.getMenu(oi.getMenuId());

                CartItem item = new CartItem();

                item.setMenuId(menu.getMenuId());
                item.setRestaurantId(menu.getRestaurantId());
                item.setName(menu.getItemName());
                item.setPrice(menu.getPrice());
                item.setQuantity(oi.getQuantity());
                item.setImageUrl(menu.getImageUrl());

                cartItems.add(item);
            }

            OrderDetails details = new OrderDetails();

            details.setOrder(order);
            details.setItems(cartItems);

            orderDetailsList.add(details);
        }

        req.setAttribute("orders", orderDetailsList);
        
     
        RequestDispatcher rd = req.getRequestDispatcher("orderHistory.jsp");
        rd.forward(req, resp);
    }
}

