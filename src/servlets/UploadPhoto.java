package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.data.db.DBConnection;
import sun.misc.IOUtils;

/**
 * Servlet implementation class UploadPhoto
 */
@WebServlet("/UploadPhoto")
@MultipartConfig(maxFileSize = 16177215)
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhoto() {
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
		Connection conn = DBConnection.createConnection();	
		Integer userId = Integer.parseInt(request.getParameter("userId"));
        ArrayList<Part> parts = (ArrayList<Part>) request.getParts();
        for (Part part : parts) {
        	if (part.getContentType() == null)
        		continue;
        	InputStream is = part.getInputStream();
        	String sql = "INSERT INTO pictures (id, imagefile) VALUES (?, ?)";
        	PreparedStatement statement;
			try {
				statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
	            statement.setBlob(2, is);
	            statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		DBConnection.closeConnection();
		
		RequestDispatcher r = request.getRequestDispatcher("edit_profile_hotel.jsp?id="+request.getParameter("ID"));
		r.forward(request, response);
	}
}