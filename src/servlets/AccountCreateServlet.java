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
import model.data.users.User;

/**
 * Servlet implementation class AccountCreateServlet
 */
@WebServlet(urlPatterns = { "/AccountCreateServlet", "/Create" })
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
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(StringToMD5.generate(request.getParameter("password")));

		
		UsersStorage storage = new UsersStorage();
		if (storage.saveUser(user)) {
			request.getSession().setAttribute("user", storage.loadUser(user.getUsername()));
			RequestDispatcher r = request.getRequestDispatcher("welcome.jsp");
			r.forward(request, response);
		}else{
			RequestDispatcher r = request.getRequestDispatcher("create_failed.jsp");
			r.forward(request, response);
			
		}
	}

}
