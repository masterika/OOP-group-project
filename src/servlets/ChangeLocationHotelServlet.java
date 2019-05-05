package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.StaticTripStorage;
import model.data.users.Hotel;

/**
 * Servlet implementation class ChangeLocationHotelServlet
 */
@WebServlet("/ChangeLocationHotelServlet")
public class ChangeLocationHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLocationHotelServlet() {
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
		int id = Integer.parseInt(request.getParameter("type"));
		int identificator = Integer.parseInt(request.getParameter("newiden"));
		StaticTripStorage.changeLocationHotel(identificator, id);		
		int tripId = Integer.parseInt(request.getParameter("trip"));
		RequestDispatcher r = request.getRequestDispatcher("trip_view.jsp?id="+tripId);		
		r.forward(request, response);
	}

}
