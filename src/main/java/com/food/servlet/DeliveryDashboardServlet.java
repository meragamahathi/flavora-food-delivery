package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.OrderDAOImpl;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.daoimpl.UserDAOImpl;
import com.food.model.Order;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deliveryDashboard")
public class DeliveryDashboardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
	        HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession();

	    User user = (User) session.getAttribute("user");

	    if (user == null) {

	        resp.sendRedirect("login.html");
	        return;
	    }

	    OrderDAOImpl orderDAO = new OrderDAOImpl();
	    UserDAOImpl userDAO = new UserDAOImpl();
	    RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();

	    List<Order> orders =
	            orderDAO.getOrdersByDeliveryAgent(user.getUserId());

	    req.setAttribute("orders", orders);
	    req.setAttribute("userDAO", userDAO);
	    req.setAttribute("restaurantDAO", restaurantDAO);

	    req.getRequestDispatcher("deliveryDashboard.jsp")
	       .forward(req, resp);
	}
}