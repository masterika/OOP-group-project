package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.Location;
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
		Location location = new Location();
		int tripId = Integer.parseInt(request.getParameter("type"));
		location.setDuration(Integer.parseInt(request.getParameter("newper")));
		location.setHotel(Integer.parseInt(request.getParameter("newhot")));
		location.setCity(request.getParameter("newcity"));
		try {
			StaticTripStorage.addLocation(location,tripId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r = request.getRequestDispatcher("trip_view.jsp?id="+tripId);
		r.forward(request, response);
	}

}
