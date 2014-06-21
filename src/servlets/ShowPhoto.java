package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import model.data.db.DBConnection;

/**
 * Servlet implementation class ShowPhoto
 */
@WebServlet("/ShowPhoto")
public class ShowPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ID"));
		ArrayList<String> images = new ArrayList<String>();
		Connection conn = DBConnection.createConnection();
		String sql = "SELECT imagefile FROM pictures WHERE id = ?";
    	try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(request.getParameter("ID")));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Blob bl = rs.getBlob("imagefile");
				byte[] pict = bl.getBytes(1, (int)bl.length());
				String stringToStore = new String(Base64.encode(pict));
				images.add(stringToStore);
			}
    	} catch (SQLException e) {
            e.printStackTrace();
        } finally{
        	DBConnection.closeConnection();
        }
    	request.setAttribute("images", images);
    	RequestDispatcher rd = request.getRequestDispatcher("hotel.jsp");
    	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}