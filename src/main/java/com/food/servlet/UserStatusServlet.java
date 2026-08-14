package com.food.servlet;

import java.io.IOException;

import com.food.daoimpl.UserDAOImpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userStatus")
public class UserStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        String status = req.getParameter("status");

        UserDAOImpl dao = new UserDAOImpl();

        dao.updateUserStatus(userId, status);

        resp.sendRedirect("adminUsers");
    }
}