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
 * Servlet implementation class ChangeUserPasswordServlet
 */
@WebServlet("/ChangeUserPasswordServlet")
public class ChangeUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserPasswordServlet() {
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
		UsersStorage us = new UsersStorage();
		
		String previousPassword = ((User)request.getSession().getAttribute("user")).getPassword();
		String typedPrevPass = StringToMD5.generate(request.getParameter("prevpass"));
		if (previousPassword.equals(typedPrevPass) && request.getParameter("newpass").equals(request.getParameter("confnewpass"))){
			
			us.changePassword(((User)request.getSession().getAttribute("user")).getId(), StringToMD5.generate(request.getParameter("newpass")));
			RequestDispatcher r = request.getRequestDispatcher("edit_profile_client.jsp");
			r.forward(request, response);
		}
		else if (!previousPassword.equals(typedPrevPass)){
			RequestDispatcher r = request.getRequestDispatcher("prev_pass_misspelled.jsp");
			r.forward(request, response);
		}
		else{
			RequestDispatcher r = request.getRequestDispatcher("confirmation_failed.jsp");
			r.forward(request, response);
		}
	}

}
