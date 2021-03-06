package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.data.db.StaticStorage;
import model.data.users.Agency;


/**
 * Servlet implementation class AgencyAccountCreateServlet
 */
@WebServlet("/gotoagency")
public class AgencyAccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyAccountCreateServlet() {
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
		Agency agency = new Agency();
		int sellerId =  (Integer)request.getAttribute("sellerId");		
		if(StaticStorage.saveAgency(agency,sellerId) != -1){		
			RequestDispatcher rd = request.getRequestDispatcher("/LoginServlet");
		    rd.forward(request, response);
		}
	}
}
