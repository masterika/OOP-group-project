package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.data.users.Agency;
import model.data.users.Client;
import model.data.users.Hotel;
import model.data.users.Sellers;
import model.data.users.User;


/*
 * aris shenaxvis da loadis failebi
 * aklia
 */
public class StaticStorage {
	private static Connection conn;
	public static int saveUser(User user) {
		conn = DBConnection.createConnection();
		int retVal = -1;
		try {
			String query = "INSERT INTO users (username,password,email) VALUES (?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.execute();
			retVal = getUserId(user.getUsername()); // insert_id unda sinqronizebuli ogond!!!
		} catch (SQLException e) {			
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;				
	}
	public static int saveSeller(Sellers seller, int userid) {		
		conn = DBConnection.createConnection();
		int retVal = -1;
		try {
			String query = "INSERT INTO user_seller (user_id,name,adress,telephone) VALUES (?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, userid);
			statement.setString(2, seller.getName());
			statement.setString(3, seller.getAdress());
			statement.setString(4, seller.getTelephone());
			statement.execute();
			retVal = getSellerId(userid); // insert_id unda sinqronizebuli ogond!!!
		} catch (SQLException e) {			
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;				
	}
	private static int getSellerId(int userid) {
		int id = -1;
		try {
			String q = "SELECT * FROM user_seller WHERE user_id = ?;"; // aq pirdapir select id minda 1 xazzshi ar sheileba?
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setInt(1, userid);		
			ResultSet rs = statement.executeQuery();
			if (rs.next())
				id = rs.getInt("id");			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return id;	
		
	}
	
	public static boolean saveHotel(Hotel hotel, int sellerid) {
		conn = DBConnection.createConnection();
		boolean retVal = false;
		try {
			String query = "INSERT INTO seller_hotel (seller_id,stars) VALUES (?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, sellerid);
			statement.setInt(2, hotel.getStars());			
			statement.execute();
			retVal = true;         
		} catch (SQLException e) {			
		}finally{
			DBConnection.closeConnection();
		}	
		return retVal;			
	}
	
	public static boolean saveAgency(Agency agency, int sellerid) {
		conn = DBConnection.createConnection();
		boolean retVal = false;
		try {
			System.out.println("aq sheveci");
			String query = "INSERT INTO seller_agency (seller_id) VALUES (?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, sellerid);					
			statement.execute();
			retVal = true;         
		} catch (SQLException e) {			
		}finally{
			DBConnection.closeConnection();
		}	
		return retVal;			
	}
	
	
	public static boolean saveClient(Client client, int userid) {
		conn = DBConnection.createConnection();
		boolean retVal = false;
		try {
			String query = "INSERT INTO user_client (user_id,name,surname,telephone) VALUES (?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, userid);
			statement.setString(2, client.getName());
			statement.setString(3, client.getSurName());
			statement.setString(4, client.getTelephone());
			statement.execute();
			retVal = true;         
		} catch (SQLException e) {			
		}finally{
			DBConnection.closeConnection();
		}	
		return retVal;			
	}
	private static int getUserId(String username) {
		conn = DBConnection.createConnection();
		int id = -1;
		try {
			String q = "SELECT * FROM users WHERE username = ?;"; // aq pirdapir select id minda 1 xazzshi ar sheileba?
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setString(1, username);		
			ResultSet rs = statement.executeQuery();
			if (rs.next())
				id = rs.getInt("id");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.closeConnection();
		}		
		return id;			
	}
	/*
	 * this method is created for login.
	 * returns -1 if user with given username and password doesn't exist
	 * returns user id if such user is in base
	 * we use later id for loading user
	 */
	public static int isValidUser(User user) {		
		conn = DBConnection.createConnection();
		int retVal = -1;
		try {
			String query = "select id from users where username = ? and password = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				retVal = res.getInt(1);
			} else {
				retVal = -1;
			}
		} catch (SQLException e) {
			retVal = -1;
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;
	}
	
	public Client loadClient(int id) {
		Client client = null;
		try {
            String query = "SELECT * FROM user_client, users WHERE users.id = ? and users.id = user_client.user_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            	client = new Client(); // testirebadoba!!!
            	client.setName(rs.getString("name"));
            	client.setSurName(rs.getString("surname"));
            	client.setTelephone(rs.getString("telephone"));
            	client.setId(rs.getInt("user_id"));
            	client.setUsername(rs.getString("username"));
            	client.setEmail(rs.getString("email"));
            	client.setPassword(rs.getString("password"));
            	client.setClientId(rs.getInt("user_client.id"));
            	
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return client;
	}
	
	public Hotel loadHotel(int id) {
		Hotel hotel = null;
		try {
            String query = "SELECT * FROM seller_hotel,user_seller, users WHERE users.id = ? and users.id = user_seller.user_id and user_seller.id=seller_hotel.seller_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	hotel = new Hotel(); //testireba!
            	hotel.setName(rs.getString("hotel_name"));
            	hotel.setAdress(rs.getString("adress"));
            	hotel.setTelephone(rs.getString("telephone"));
            	hotel.setId(rs.getInt("id"));
            	hotel.setUsername(rs.getString("username"));
            	hotel.setEmail(rs.getString("email"));
            	hotel.setPassword(rs.getString("password"));
            	hotel.setHotelId(rs.getInt("user_hotel.id"));            	
            	hotel.setStars(rs.getInt("stars"));            	
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return hotel;
	}
	public Agency loadAgency(int id) {
		Agency agency = null;
		try {
            String query = "SELECT * FROM seller_agency,user_seller, users WHERE users.id = ? and users.id = user_seller.user_id and user_seller.id=seller_agency.seller_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	agency = new Agency();
            	agency.setName(rs.getString("agency_name"));
            	agency.setAdress(rs.getString("adress"));
            	agency.setTelephone(rs.getString("telephone"));
            	agency.setId(rs.getInt("user_id"));
            	agency.setUsername(rs.getString("username"));
            	agency.setEmail(rs.getString("email"));
            	agency.setPassword(rs.getString("password"));
            	agency.setAgencyId(rs.getInt("user_agency.id"));            	
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }

        
		return agency;
	}
}



