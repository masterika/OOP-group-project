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
@WebServlet(urlPatterns = { "/AccountCreateServlet", "/signup/create" })
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
		String confPassword = StringToMD5.generate(request.getParameter("confPassword"));
		
		if(!password.equals(confPassword)){
			response.sendRedirect("/Turista/signup/?notmatch");
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		UsersStorage storage = new UsersStorage();
		int userId = storage.isValidUser(user);
		if(storage.isValidUser(user) == -1){
			storage.saveUser(user);
			request.getSession().setAttribute("user", storage.loadUser(userId));
			response.sendRedirect("/Turista/welcome.jsp");
		}else{
			response.sendRedirect("/Turista/signup/?failed");
		}
	}

}
