package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.StaticTripStorage;

/**
 * Servlet implementation class AddLocationServlet
 */
@WebServlet("/AddLocationServlet")
public class AddLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLocationServlet() {
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
		int tripId = Integer.parseInt(request.getParameter("type"));
		int period = Integer.parseInt(request.getParameter("newper"));
		int hotelId = StaticTripStorage.getHotelID(Integer.parseInt(request.getParameter("newhot")));
		String locationName = request.getParameter("newcity");
		StaticTripStorage.AddLocation(locationName, hotelId, tripId, period);
		RequestDispatcher r = request.getRequestDispatcher("trip_view.jsp?id="+tripId);
		r.forward(request, response);
	}

}
