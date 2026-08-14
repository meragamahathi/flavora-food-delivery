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

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		User loggedInUser = (session != null) ? (User) session.getAttribute("user") : null;

		// Not logged in — bounce to login instead of trusting the form
		if (loggedInUser == null) {
			resp.sendRedirect("login.html");
			return;
		}

		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String address = req.getParameter("address");

		// Basic validation — don't save blank fields
		if (userName == null || userName.trim().isEmpty()
				|| email == null || email.trim().isEmpty()
				|| address == null || address.trim().isEmpty()) {
			resp.sendRedirect("profile.jsp?error=empty");
			return;
		}

		// Only update the fields the profile form actually edits.
		// Password, role, status, userId, etc. stay exactly as they
		// were on the session's User object so updateUser() doesn't
		// accidentally overwrite them with nulls.
		loggedInUser.setUserName(userName.trim());
		loggedInUser.setEmail(email.trim());
		loggedInUser.setAddress(address.trim());

		UserDAOImpl userDAO = new UserDAOImpl();

		// updateUser() returns void and swallows SQLExceptions internally
		// (it only prints a stack trace), so there's no reliable signal
		// here to detect a failed save. We re-fetch the row afterward to
		// confirm the update actually took effect in the database.
		userDAO.updateUser(loggedInUser);

		User refreshed = userDAO.getUserById(loggedInUser.getUserId());

		if (refreshed != null && userName.trim().equals(refreshed.getUserName())) {
			// Keep the session in sync with the freshly saved data
			session.setAttribute("user", refreshed);
			resp.sendRedirect("profile.jsp?success=1");
		} else {
			resp.sendRedirect("profile.jsp?error=save");
		}
	}
}