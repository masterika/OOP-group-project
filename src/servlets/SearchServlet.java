package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.data.db.HotelStorage;
import model.data.db.StaticStorage;
import model.data.users.Agency;
import model.data.users.Hotel;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		try {
			String term = request.getParameter("term");
			ArrayList<MySeller> list = new ArrayList<>();
			
			ArrayList<Hotel> hotels = StaticStorage.getHotelsFromDB(term);
			ArrayList<Agency> agencies = StaticStorage.getAgenciesFromDB(term);
			
			for(Hotel h:hotels){
				MySeller seller = new MySeller();
				seller.setId(h.getId());
				seller.setName(h.getName());
				seller.setAdress(h.getAdress());
				seller.setType("hotel");
				list.add(seller);
			}
			
			for(Agency a:agencies){
				MySeller seller = new MySeller();
				seller.setId(a.getId());
				seller.setName(a.getName());
				seller.setAdress(a.getAdress());
				seller.setType("agency");
				list.add(seller);
			}
			String searchList = new Gson().toJson(list);
			response.getWriter().write(searchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private class MySeller{
		private int id;
		private String name;
		private String adress;
		private String type;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		@Override
		public String toString() {
			return "id= "+id+", name= "+name+", adress="+adress+", type="+type;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}

}
