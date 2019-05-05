package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticRatingStorage {
	private static Connection conn;
	
	
	/*
	 * for passed userid and objectid method returns true if user can rate this objectid,
	 *  that is if he has not rated this object before
	 */
	public static boolean isEligible(int userId, int objectId,String type) {
		conn = DBConnection.createConnection();	
		boolean retVal = true;
		try {		
			String query = "select * from rating where user_id = "+userId+" and object_id = "+objectId+";";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if (rs.next())
				retVal = false;
		} catch (SQLException e) {			
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;
		
	}
	/*
	 * updates rating according to passed rating, and returns updated rating.
	 *  returns -1 if jusper exeption occurs
	 */
	public static int updateRating(int rate, int userId, int objectId,String type) {
		conn = DBConnection.createConnection();		
		int retVal = -1;
		try {		
			String query = "INSERT INTO Rating (object_id,user_id,type) VALUES (?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,objectId);
			statement.setInt(2,userId);
			statement.setString(3,type);			
			statement.execute();
			retVal = updateActuallyRating(rate,type,objectId);
		} catch (SQLException e) {			
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;	
	}
	private static int updateActuallyRating(int rate, String type,int objectId) {
		int retVal = -1;
		try {		
			String query = "INSERT INTO "+type+" (user_id,rating) VALUES (?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,objectId);
			statement.setInt(2,rate);		
			statement.execute();
			retVal = countRating(type,objectId);
		} catch (SQLException e) {			
		 
		}
		return retVal;	
	}
	private static int countRating(String type, int objectId) {		
		int res = -1;		
		try {
			
			String query = "select avg(rating) as denominator from "+type+" where user_id = "+objectId+";";
			Statement statement = conn.prepareStatement(query);			
			ResultSet rs = statement.executeQuery(query);
			if (rs.next())
				res = rs.getInt("denominator");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;	
		
	}	
	
	/*
	 * for passed type of object and it's user_id(objectId)) method returns object's rating
	 */
	
	public static int loadRating(String type, int objectId) {	
		conn = DBConnection.createConnection();	
		int res = -1;
		try {
			res = countRating(type,objectId);
		} finally {
			DBConnection.closeConnection();
		}				
		return res; 
	}	
}
