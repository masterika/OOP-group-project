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
import model.data.users.Hotel;

/**
 * Servlet implementation class HotelAccountCreateServlet
 */
@WebServlet("/CreateHotel")
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
		hotel.setUsername(request.getParameter("username"));
		hotel.setPassword(StringToMD5.generate(request.getParameter("password")));
		hotel.setEmail(request.getParameter("email"));
		hotel.setName(request.getParameter("hotel_name"));
		hotel.setAdress(request.getParameter("adress"));
		hotel.setTelephone(request.getParameter("telephone"));
		int n = Integer.parseInt(request.getParameter("rooms_num")); 
		hotel.setRoomNum(n);
		int s = Integer.parseInt(request.getParameter("stars"));
		hotel.setStars(s);
		
		HotelStorage storage = new HotelStorage();
		if(storage.saveHotel(hotel)){
			request.getSession().setAttribute("hotel", storage.loadHotel(hotel.getUsername()));
			RequestDispatcher r = request.getRequestDispatcher("welcome.jsp");
			r.forward(request, response);
		}else{
			RequestDispatcher r = request.getRequestDispatcher("create_failed.jsp");
			r.forward(request, response);
			
		}
	}

}
