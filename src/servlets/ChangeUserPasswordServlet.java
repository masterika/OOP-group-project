package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.ChangeStorage;


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
		//select * from users,user_seller,seller_hotel where users.id = user_seller.user_id and user_seller.id = seller_hotel.seller_id;
		//select * from  users,user_client where users.id = user_client.user_id;
		int id = Integer.parseInt(request.getParameter("type"));
		String previousPassword = ChangeStorage.getPassword(id);
		String userType = request.getParameter("user");
		String adress = "welcome" + userType + ".jsp";
		String typedPrevPass = StringToMD5.generate(request.getParameter("prevpass"));
		if (previousPassword.equals(typedPrevPass) && request.getParameter("newpass").equals(request.getParameter("confnewpass"))){
			ChangeStorage.changePassword(id, StringToMD5.generate(request.getParameter("newpass")));
			RequestDispatcher r = request.getRequestDispatcher(adress);
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
