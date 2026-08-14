package com.food.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.daoimpl.MenuDAOImpl;
import com.food.daoimpl.OrderDAOImpl;
import com.food.daoimpl.OrderItemDAOImpl;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.Menu;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.model.Restaurant;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deliveryOrderDetails")
public class DeliveryOrderDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        int orderId =
                Integer.parseInt(req.getParameter("orderId"));

        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl itemDAO = new OrderItemDAOImpl();
        UserDAOImpl userDAO = new UserDAOImpl();
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();

        Order order = orderDAO.getOrder(orderId);

        User customer =
                userDAO.getUser(order.getUserId());

        Restaurant restaurant =
                restaurantDAO.getRestaurant(order.getRestaurantId());

        List<OrderItem> items =
                itemDAO.getOrderItemsByOrderId(orderId);

        req.setAttribute("order", order);
        req.setAttribute("customer", customer);
        req.setAttribute("restaurant", restaurant);
        req.setAttribute("items", items);
        Map<Integer, Menu> menuMap = new HashMap<>();

        for(OrderItem item : items){

            Menu menu = menuDAO.getMenu(item.getMenuId());

            menuMap.put(item.getMenuId(), menu);

        }

        req.setAttribute("menuMap", menuMap);

        req.getRequestDispatcher("deliveryOrderDetails.jsp")
                .forward(req, resp);
    }
}