package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.StaticRatingStorage;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
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
		int raterId = Integer.parseInt(request.getParameter("raterId")); // id of person/object who rates
		int ratedId = Integer.parseInt(request.getParameter("ratedId")); // id of object that was rated
		int rate = Integer.parseInt(request.getParameter("rate")); // rating given by person to object
		String type = request.getParameter("type");// type of object that has been rated (hotel or agency)
		if (StaticRatingStorage.isEligible(raterId, ratedId, type)) {
			int newRating = StaticRatingStorage.updateRating(rate, raterId,ratedId, type);
			if (newRating != -1) {			
			} else {
				
			}
		} else {
			System.out.println("aqaaelseshi");
			// tu movaswarit you have already rated jsp
		}
	}

}
