package com.food.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.mindrot.jbcrypt.BCrypt;

import com.food.daoimpl.UserDAOImpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SignupServlet called");
		String userName=req.getParameter("fullName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		String address=req.getParameter("address");
		
		String hashpw=BCrypt.hashpw(password, BCrypt.gensalt(12));
		User u=new User(userName,email,hashpw,role,address);
		u.setStatus("Active");
		UserDAOImpl userDAO=new UserDAOImpl();
	    int res=userDAO.addUser(u);
	    if(res==1) {
	    	resp.sendRedirect("login.html");
	    }
	    else {
	    	resp.sendRedirect("signup.html");
	    }
	}
	

}
