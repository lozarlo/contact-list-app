package contacts.controller;

import java.io.IOException;

import contacts.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedIn") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String action = request.getParameter("action");

		if (action == null || action.isEmpty()) {
			action = "list";
		}
		if (action.equals("new")) {
			showEditor(request, response, null);
		} else if (action.equals("edit")) {
			int editId = Integer.parseInt(request.getParameter("id"));
			Person p = ContactsManager.getById(editId, session);
			showEditor(request, response, p);
		} else if (action.equals("delete")) {
			int deleteId = Integer.parseInt(request.getParameter("id"));
			ContactsManager.delete(deleteId, session);
			response.sendRedirect("contacts");
		} else {
			showList(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedIn") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String action = request.getParameter("action");

		if ("save".equals(action)) {
			String idParam = request.getParameter("id");
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			int age = Integer.parseInt(request.getParameter("age"));

			if (idParam != null && !idParam.isEmpty()) {
				// Update
				Person p = new Person(name, surname, address, phone, age);
				p.setId(Integer.parseInt(idParam));
				ContactsManager.update(p, session);
			} else {
				// Create
				Person p = new Person(name, surname, address, phone, age);
				ContactsManager.add(p, session);
			}
			response.sendRedirect("contacts");
		}
	}

	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("contacts", ContactsManager.getAll(session));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response, Person p)
			throws ServletException, IOException {
		request.setAttribute("person", p);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/editor.jsp");
		dispatcher.forward(request, response);
	}
}