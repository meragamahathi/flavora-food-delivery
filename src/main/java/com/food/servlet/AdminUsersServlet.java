package com.food.servlet;

import java.io.IOException;
import java.util.List;

import com.food.daoimpl.UserDAOImpl;
import com.food.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminUsers")
public class AdminUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        UserDAOImpl dao = new UserDAOImpl();

        List<User> users = dao.getAllUsers();

        req.setAttribute("users", users);

        RequestDispatcher rd =
                req.getRequestDispatcher("adminUsers.jsp");
        System.out.println("Total Users = " + users.size());

        for(User u : users){
            System.out.println(u);
        }

        rd.forward(req, resp);
    }
}