package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.users.Agency;
import model.data.users.Hotel;

/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet("/search")
//public class SearchServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public SearchServlet() {
//		super();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
	//protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		String keyword = request.getParameter("keyword");
//		String type = request.getParameter("type");
//		
//		if (type.equals("Hotel")) {
//			HotelStorage storage = new HotelStorage();
//			ArrayList<Hotel> hotels = storage.getHotelsFromDB(keyword);
//			
//			response.setContentType("text/html");
//	        PrintWriter out = response.getWriter();
//	        out.print("<ul>");
//	        for(Hotel hotel : hotels){
//	        	out.print("<li><a href=/hotel.jsp?ID="+hotel.getId()+">"+hotel.getName()+"</a></li>");
//	        }
//	        out.print("</ul>");
//		}else
//		if(type.equals("Agency")){
//			AgencyStorage storage = new AgencyStorage();
//			ArrayList<Agency> agencies = storage.getAgenciesFromDB(keyword);
//			
//			response.setContentType("text/html");
//	        PrintWriter out = response.getWriter();
//	        out.print("<ul>");
//	        for(Agency agency : agencies){
//	        	out.print("<li><a href=/agency.jsp?ID="+agency.getId()+">"+agency.getName()+"</a></li>");
//	        }
//	        out.print("</ul>");
//		}
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

//}
