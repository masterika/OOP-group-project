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
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/LoginServlet", "/Login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(StringToMD5.generate(request.getParameter("password")));
		UsersStorage storage = new UsersStorage();
		if(storage.isValidUser(user)){
			RequestDispatcher r = request.getRequestDispatcher("welcome.jsp");
			r.forward(request, response);
		}else{
			RequestDispatcher r = request.getRequestDispatcher("failed.jsp");
			r.forward(request, response);
		}
	}

}