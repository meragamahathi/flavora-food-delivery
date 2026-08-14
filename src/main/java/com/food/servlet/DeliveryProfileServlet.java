package com.food.servlet;

import java.io.IOException;

import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deliveryProfile")
public class DeliveryProfileServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session=req.getSession(false);

        if(session==null || session.getAttribute("user")==null){

            resp.sendRedirect("login.html");
            return;
        }

        User user=(User)session.getAttribute("user");

        req.setAttribute("user",user);

        req.getRequestDispatcher("deliveryProfile.jsp")
        .forward(req,resp);
    }
}