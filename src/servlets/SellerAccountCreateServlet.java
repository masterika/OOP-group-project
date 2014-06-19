package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.StaticStorage;
import model.data.db.UsersStorage;
import model.data.users.User;
import model.data.users.Sellers;

/**
 * Servlet implementation class SellerAccountCreateServlet
 */
@WebServlet(urlPatterns = { "/hotel", "/agency" })
public class SellerAccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerAccountCreateServlet() {
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
		String name = request.getParameter("name");
		String adress = request.getParameter("adress");
		String telephone = request.getParameter("telephone");
		String s = request.getParameter("type");
		String serAdress = "goto" + s;
		
		
		Sellers seller = new Sellers();
		seller.setName(name);
		seller.setAdress(adress);
		seller.setTelephone(telephone);
		int userId = (Integer)request.getAttribute("userId");
		
		
		
			int sellerId = StaticStorage.saveSeller(seller,userId);
			request.setAttribute("sellerId", sellerId);
			RequestDispatcher rd = request.getRequestDispatcher(serAdress);
		    rd.forward(request, response);
		
		
		
		
		
		
	}

}
