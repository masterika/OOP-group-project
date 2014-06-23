package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StaticUserIdGetterStorage {
	private static Connection conn;	
	public static int getHotelUserId(int hotelId) {
		int userId = -1;
		conn = DBConnection.createConnection();				
		try {
			String query = "SELECT * FROM seller_hotel,user_seller, users WHERE seller_hotel.id = ? and users.id = user_seller.user_id and user_seller.id=seller_hotel.seller_id;";
			PreparedStatement statement = conn.prepareStatement(query);
			 statement.setInt(1, hotelId);
			 ResultSet rs = statement.executeQuery();
		     if (rs.next()) {
		       	userId = rs.getInt("users.id");		       
		     }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }finally{
	    	DBConnection.closeConnection();
	    }	
		return userId;
	}
	
	public static int getAgencyUserId(int agencyId) {
		int userId = -1;
		conn = DBConnection.createConnection();				
		try {
			String query = "SELECT * FROM seller_agency,user_seller, users WHERE seller_agency.id = ? and users.id = user_seller.user_id and user_seller.id=seller_agency.seller_id;";
			PreparedStatement statement = conn.prepareStatement(query);
			 statement.setInt(1, agencyId);
			 ResultSet rs = statement.executeQuery();
		     if (rs.next()) {
		       	userId = rs.getInt("users.id");		       
		     }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }finally{
	    	DBConnection.closeConnection();
	    }	
		return userId;
	}
}
