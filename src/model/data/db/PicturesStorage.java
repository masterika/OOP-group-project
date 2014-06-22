package model.data.db;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import model.data.users.Hotel;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class PicturesStorage {
	private static Connection conn;
	
	public static ArrayList<String> getPicturesByID(int id){
		ArrayList<String> images = new ArrayList<String>();
		conn = DBConnection.createConnection();
		String sql = "SELECT imagefile FROM pictures WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
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
		return images;
	}
}
