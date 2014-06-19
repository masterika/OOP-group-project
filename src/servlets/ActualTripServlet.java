package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.Location;
import model.data.Trip;
import model.data.db.TripStorage;
import model.data.users.Hotel;

/**
 * Servlet implementation class ActualTripServlet
 */
@WebServlet("/ActualTripServlet")
public class ActualTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualTripServlet() {
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
		Trip trip = new Trip();
		fillTrip(trip, request);
		TripStorage storage = new TripStorage(1); // aq cxadia 1iani ar unda meweros, romeli failic iyenebs is unda gadascemdes requests parametrad agencys idis.		
		//TripStorage storage = new TripStorage(Integer.parseInt(request.getParameter("agencyId"))); ase unda gamoiyurebodes realurad
		if(storage.saveTrip(trip)){
			// aqedan albat trip_editshi unda gadadiodes an trip_viewshi
		}else{
			RequestDispatcher r = request.getRequestDispatcher("create_failed.jsp");
			r.forward(request, response);			
		}
	}

	private void fillTrip(Trip trip, HttpServletRequest request) {		
		trip.setName(request.getParameter("name"));	
		trip.setPrice(Integer.parseInt(request.getParameter("price")));
		trip.setType(request.getParameter("type"));
		trip.setLocations(getLocations(request));
	}

	private List<Location> getLocations(HttpServletRequest request) {		
		int num = Integer.parseInt(request.getParameter("N_Locations"));
		
		List<Location> locations = new ArrayList<Location>();
		for (int i=1; i<=num; i++) {			
			Location location = new Location();
			location.setCity(request.getParameter("city"+i));				
			location.setDuration(Integer.parseInt(request.getParameter("period"+i)));			
			location.setHotel(request.getParameter("hotel"+i));
			locations.add(location);
		}
		return locations;
	}
}