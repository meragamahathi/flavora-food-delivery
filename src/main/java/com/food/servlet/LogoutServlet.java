package com.food.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleLogout(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleLogout(req, resp);
	}

	private void handleLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("LogoutServlet called");

		// Invalidate the session instead of creating a new one just to kill it
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// Clear the JSESSIONID cookie so no stale session id lingers in the browser
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("JSESSIONID".equals(c.getName())) {
					c.setValue("");
					c.setPath(req.getContextPath().isEmpty() ? "/" : req.getContextPath());
					c.setMaxAge(0);
					resp.addCookie(c);
				}
			}
		}

		resp.sendRedirect("logout.html");
	}
}