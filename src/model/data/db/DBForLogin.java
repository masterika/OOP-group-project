package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBForLogin {
	private static Connection conn;
	
	public static String  getTtype(String username,String password){
		conn = DBConnection.createConnection();
		String st = "";
		try {
			String query = "SELECT * FROM users WHERE username = ? and password = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				int user_id = res.getInt("id");
				String client = getClient(user_id);
				String seller = getSeller(user_id);
				if(!client.equals("")){
					st = client;
				}else if(!seller.equals("")){
					st = seller;
				}
			} 
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		
		return st;
	}
	
	private static String getClient(int user_id){
		String client = "";
		try {
			String query = "SELECT * FROM user_client WHERE user_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, user_id);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				client = client + "client";
			} 
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return client;
	}
	
	private static String getSeller(int user_id){
		String seller = "";
		try {
			String query = "SELECT * FROM user_seller WHERE user_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, user_id);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				int seller_id = res.getInt("id");
				String hotel = getHotel(seller_id);
				String agency = getAgency(seller_id);
				if(!hotel.equals("")){
					seller = hotel;
				}else if(!agency.equals("")){
					seller = agency;
				}
			} 
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return seller;
	}
	
	private static String getHotel(int seller_id){
		String hotel = "";
		try {
			String query = "SELECT * FROM seller_hotel WHERE seller_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, seller_id);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				hotel= hotel + "hotel";
			} 
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return hotel;
	}
	
	private static String getAgency(int seller_id){
		String agency = "";
		try {
			String query = "SELECT * FROM seller_agency WHERE seller_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, seller_id);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				agency= agency + "agency";
			} 
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return agency;
	}

}
