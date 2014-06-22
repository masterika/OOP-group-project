package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import helper.StringToMD5;

public class ChangeStorage {
	private static Connection conn;
	
	public static void changePassword(int id,String pass){
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE users SET password = ? WHERE users.id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, pass);
			statement.setInt(2, id);
			statement.execute();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
	}
	

	
	public static void changeEmail(int id,String email){
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE users SET email = ? WHERE users.id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1,email);
			statement.setInt(2, id);
			statement.execute();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
	}
	
	
	public static void changeTelephone(int id,String telephone){
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE users SET telephone = ? WHERE id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1,telephone);
			statement.setInt(2, id);
			statement.execute();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
	}
	
	public static void changeSellerName(int id,String name){
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE user_seller,users SET user_seller.name = ? WHERE users.id = ? and users.id = user_seller.user_id;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1,name);
			statement.setInt(2, id);
			statement.execute();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
	}
	
	public static void changeSellerAdress(int id,String adress){
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE user_seller,users SET user_seller.adress = ? WHERE users.id = ? and users.id = user_seller.user_id;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1,adress);
			statement.setInt(2, id);
			statement.execute();
			
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
	}
	

	
	public static void changeSellerIdentificator(int sellerId,int identificator){
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE user_seller SET identificator = ? WHERE user_seller.id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,identificator);
			statement.setInt(2, sellerId);
			statement.execute();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
	}
	
	public static String getPassword(int id){
		conn = DBConnection.createConnection();
		String retVal = "";
		try {
			String query = "SELECT * FROM users WHERE id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				retVal = rs.getString("password");
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;
	}
	
	
	
}
