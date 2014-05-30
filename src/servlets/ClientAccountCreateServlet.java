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
import model.data.users.Client;

/**
 * Servlet implementation class ClientAccountCreateServlet
 */
@WebServlet("/CreateClient")
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
		client.setUsername(request.getParameter("username"));
		client.setPassword(StringToMD5.generate(request.getParameter("password")));
		client.setEmail(request.getParameter("email"));
		client.setName(request.getParameter("name"));
		client.setSurName(request.getParameter("surname"));
		client.setTelephone(request.getParameter("telephone"));
		
		ClientStorage storage = new ClientStorage();
		if(storage.saveClient(client)){
			request.getSession().setAttribute("client", storage.loadClient(client.getUsername()));
			RequestDispatcher r = request.getRequestDispatcher("welcome.jsp");
			r.forward(request, response);
		}else{
			RequestDispatcher r = request.getRequestDispatcher("create_failed.jsp");
			r.forward(request, response);
			
		}
		
		
	}

}
