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

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
    
    private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "1234";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "turista";

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
		InputStream inputStream = null;
        Part filePart = request.getPart("image");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null;
        String message = null;
         
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/"
					+ MYSQL_DATABASE_NAME;
			conn = DriverManager.getConnection(url, MYSQL_USERNAME,
					MYSQL_PASSWORD);
 
            String sql = "INSERT INTO pictures (imagefile) values (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
             
            if (inputStream != null) {
                statement.setBlob(1, inputStream);
            }
 
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
        	String sql = "SELECT imagefile FROM pictures WHERE id = 2";
        	try {
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Blob bl = rs.getBlob("imagefile");
					byte[] pict = bl.getBytes(1,(int)bl.length());
			        response.setContentType("image/jpg");
			        OutputStream o = response.getOutputStream();
			        o.write(pict);
			        o.flush();
			        o.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	}
}