package com.food.servlet;
import java.io.IOException;
import java.util.List;

import com.food.daoimpl.MenuDAOImpl;
import com.food.daoimpl.OrderDAOImpl;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.Menu;
import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserDAOImpl userDAO = new UserDAOImpl();
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();

        List<User> users = userDAO.getAllUsers();
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
        List<Menu> menus = menuDAO.getAllMenus();
        List<Order> orders = orderDAO.getAllOrders();

        req.setAttribute("totalUsers", users.size());
        req.setAttribute("totalRestaurants", restaurants.size());
        req.setAttribute("totalMenus", menus.size());
        req.setAttribute("totalOrders", orders.size());

        RequestDispatcher rd =
                req.getRequestDispatcher("adminDashboard.jsp");

        rd.forward(req, resp);
    }

}
