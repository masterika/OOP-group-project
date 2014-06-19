package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.db.AgencyStorage;
import model.data.users.Agency;


/**
 * Servlet implementation class AgencyAccountCreateServlet
 */
@WebServlet("/CreateAgency")
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
		agency.setUsername(request.getParameter("username"));
		agency.setPassword(StringToMD5.generate(request.getParameter("password")));
		agency.setEmail(request.getParameter("email"));
		agency.setName(request.getParameter("agency_name"));
		agency.setAdress(request.getParameter("adress"));
		agency.setTelephone(request.getParameter("telephone"));
		
		AgencyStorage storage = new AgencyStorage();
		if(storage.saveAgency(agency)){
			RequestDispatcher rd = request.getRequestDispatcher("/signin/login");
		    rd.forward(request, response);
		}else{
			RequestDispatcher r = request.getRequestDispatcher("create_failed.jsp");
			r.forward(request, response);
			
		}
	}

}
