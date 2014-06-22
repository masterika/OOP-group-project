package servlets;

import helper.StringToMD5;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.data.users.Agency;
import model.data.users.User;
import model.data.db.StaticStorage;
import model.data.db.DBForLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(StringToMD5.generate(request.getParameter("password")));
		
		int userId = StaticStorage.isValidUser(user);
		String st = DBForLogin.getTtype(request.getParameter("username"),StringToMD5.generate(request.getParameter("password")));
		
		if(userId != -1 && !st.equals("") ){
			if(st.equals("client")){
				request.getSession().setAttribute("client", StaticStorage.loadClient(userId));
				RequestDispatcher rd = request.getRequestDispatcher("welcomeClient.jsp");
			    rd.forward(request, response);
				//response.sendRedirect("welcomeClient.jsp");
			}else if(st.equals("hotel")){
				request.getSession().setAttribute("hotel", StaticStorage.loadHotel(userId));
				RequestDispatcher rd = request.getRequestDispatcher("welcomeHotel.jsp");
			    rd.forward(request, response);
				//response.sendRedirect("welcomeHotel.jsp");
			}else if(st.equals("agency")){
				request.getSession().setAttribute("agency", StaticStorage.loadAgency(userId));
				RequestDispatcher rd = request.getRequestDispatcher("welcomeAgency.jsp");
			    rd.forward(request, response);
				//response.sendRedirect("welcomeAgency.jsp");
			}
		}else{
			response.sendRedirect("/Turista/signin/?failed");
		}
	}

}

