package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.UserDAOImpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminProfile")
public class AdminProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        User user = (User) session.getAttribute("user");
        
        if (user == null || !user.getRole().equalsIgnoreCase("SuperAdmin")) {
            response.sendRedirect("login.html");
            return;
        }
        request.setAttribute("admin", user);

        request.getRequestDispatcher("adminProfile.jsp")
               .forward(request, response);
    }
}