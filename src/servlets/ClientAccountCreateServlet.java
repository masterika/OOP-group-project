package servlets;

import helper.StringToMD5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;



import model.data.db.ClientStorage;
import model.data.db.StaticStorage;
import model.data.users.Client;

/**
 * Servlet implementation class ClientAccountCreateServlet
 */
@WebServlet("/client")
public class ClientAccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientAccountCreateServlet() {
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
		Client client = new Client();
		
		int userId =(Integer)request.getAttribute("userId");
		client.setName(request.getParameter("name"));
		client.setSurName(request.getParameter("surname"));
		client.setTelephone(request.getParameter("telephone"));
		
	
		if(StaticStorage.saveClient(client,userId) !=-1){
			RequestDispatcher rd = request.getRequestDispatcher("/signin/login");
		    rd.forward(request, response);
		}else{
			response.sendRedirect("/Turista/signup/?failed");
			
		}
		
		
	}

}
