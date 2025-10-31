package contacts.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("admin".equals(username) && "admin".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", true);
			session.setAttribute("username", username);
			response.sendRedirect("contacts");
		} else {
			response.sendRedirect("login.jsp?error=true");
		}
	}
}