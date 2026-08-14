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
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {

	        String email = req.getParameter("email");
	        String password = req.getParameter("password");
	        
	        HttpSession session = req.getSession();

	        UserDAOImpl userDAO = new UserDAOImpl();

	        User user = userDAO.getUserByEmail(email);
	        
	        
	        if(user == null) {
	            resp.sendRedirect("signup.html");
	            return;
	        }
	        
	        if(user.getStatus().equalsIgnoreCase("Blocked")){

	            resp.getWriter().println("<script>");
	            resp.getWriter().println("alert('Your account has been blocked. Please contact Admin.');");
	            resp.getWriter().println("location='login.html';");
	            resp.getWriter().println("</script>");
	            return;
	        }
	        
	        String dbPassword=user.getPassword();
	        
	        if (BCrypt.checkpw(password, dbPassword)) {
	        	
	            user.setLastLoginDate(new java.sql.Timestamp(System.currentTimeMillis()));
	        	userDAO.updateUser(user);

	            session.setAttribute("email", email);
	            session.setAttribute("user", user);

	            String loginFrom = (String) session.getAttribute("loginFrom");

	            if ("checkout".equals(loginFrom)) {

	                session.removeAttribute("loginFrom");
	                resp.sendRedirect("checkout.jsp");
	                return;
	            }

	            String role = user.getRole().trim();

	            if(role.equalsIgnoreCase("Customer")){

	                resp.sendRedirect("restaurant");

	            }
	            else if(role.equalsIgnoreCase("SuperAdmin")){

	                resp.sendRedirect("adminDashboard");

	            }
	            else if(role.equalsIgnoreCase("DeliveryAgent")){

	                resp.sendRedirect("deliveryDashboard");

	            }
	        }
	        else{

	            resp.getWriter().println("<script>");
	            resp.getWriter().println("alert('Invalid Email or Password');");
	            resp.getWriter().println("location='login.html';");
	            resp.getWriter().println("</script>");

	        }
	}

}
