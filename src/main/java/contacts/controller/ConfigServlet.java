package contacts.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet("/config")
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String host = request.getParameter("host");
		String port = request.getParameter("port");
		String database = request.getParameter("database");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Test connection
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			conn.close(); // Connection successful

			// Store in session
			HttpSession session = request.getSession();
			session.setAttribute("dbHost", host);
			session.setAttribute("dbPort", port);
			session.setAttribute("dbName", database);
			session.setAttribute("dbUser", username);
			session.setAttribute("dbPassword", password);

			response.sendRedirect("login.jsp");

		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("index.jsp?error=connection");
		}
	}
}