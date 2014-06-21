package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.UsersStorage;
import model.data.db.StaticStorage;
import model.data.users.User;

/**
 * Servlet implementation class AccountCreateServlet
 */
@WebServlet(urlPatterns = { "/AccountCreateServlet"})
public class AccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountCreateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = StringToMD5.generate(request.getParameter("password"));
		String serAdress = request.getParameter("type");		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);		
		int id = StaticStorage.saveUser(user);
		request.setAttribute("userId", id);
		RequestDispatcher rd = request.getRequestDispatcher(serAdress);
	    rd.forward(request, response);
	}
}
