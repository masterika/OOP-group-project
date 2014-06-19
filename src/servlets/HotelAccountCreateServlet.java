package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;




import model.data.db.HotelStorage;
import model.data.db.StaticStorage;
import model.data.users.Hotel;

/**
 * Servlet implementation class HotelAccountCreateServlet
 */
@WebServlet("/gotohotel")
public class HotelAccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelAccountCreateServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hotel hotel = new Hotel();
		int sellerId = (Integer)request.getAttribute("sellerId");
		int s = Integer.parseInt(request.getParameter("stars"));
		hotel.setStars(s);
		
		
		StaticStorage.saveHotel(hotel,sellerId);
		RequestDispatcher rd = request.getRequestDispatcher("/signin/login");
	    rd.forward(request, response);
		
	}

}
