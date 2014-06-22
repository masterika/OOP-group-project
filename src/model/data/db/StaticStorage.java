package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			String query = "INSERT INTO users (username,password,email,telephone) VALUES (?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getTelephone());
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
			String query = "INSERT INTO user_seller (user_id,name,adress,identificator) VALUES (?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, userid);
			statement.setString(2, seller.getName());
			statement.setString(3, seller.getAdress());			
			statement.setInt(4,seller.getIdentificator());
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
	public static int saveHotel(Hotel hotel, int sellerid) {
		conn = DBConnection.createConnection();
		int retVal = -1;
		try {
			String query = "INSERT INTO seller_hotel (seller_id,stars) VALUES (?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, sellerid);
			statement.setInt(2, hotel.getStars());			
			statement.execute();
			retVal = getHotelId(sellerid);         
		} catch (SQLException e) {			
		}finally{
			DBConnection.closeConnection();
		}	
		return retVal;			
	}
	private static int getHotelId(int sellerid) {
		conn = DBConnection.createConnection();
		int id = -1;
		try {
			String q = "SELECT * FROM seller_hotel WHERE seller_hotel.seller_id = ?;"; // aq pirdapir select id minda 1 xazzshi ar sheileba?
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setInt(1, sellerid);		
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
	public static int saveAgency(Agency agency, int sellerid) {
		conn = DBConnection.createConnection();
		int retVal = -1;
		try {
			String query = "INSERT INTO seller_agency (seller_id) VALUES (?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, sellerid);					
			statement.execute();
			retVal = getAgencyId(sellerid);         
		} catch (SQLException e) {			
		}finally{
			DBConnection.closeConnection();
		}	
		return retVal;			
	}
	private static int getAgencyId(int sellerid) {
		conn = DBConnection.createConnection();
		int id = -1;		
		try {
			String q = "SELECT * FROM seller_agency WHERE seller_agency.seller_id = ?;"; // aq pirdapir select id minda 1 xazzshi ar sheileba?
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setInt(1, sellerid);		
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
	public static int saveClient(Client client, int userid) {		
		conn = DBConnection.createConnection();
		int retVal = -1;
		try {
			String query = "INSERT INTO user_client (user_id,name,surname) VALUES (?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, userid);
			statement.setString(2, client.getName());
			statement.setString(3, client.getSurName());			
			statement.execute();			
			retVal = getClientId(userid);         
		} catch (SQLException e) {			
		}finally{
			DBConnection.closeConnection();
		}	
		return retVal;			
	}
	private static int getClientId(int userid) {
		conn = DBConnection.createConnection();
		int id = -1;
		try {
			String q = "SELECT * FROM user_client WHERE user_client.user_id = ?;"; // aq pirdapir select id minda 1 xazzshi ar sheileba?
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setInt(1, userid);		
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
	public static Client loadClient(int userid) {
		conn = DBConnection.createConnection();
		Client client = null;
		try {
            String query = "SELECT * FROM user_client, users WHERE users.id = ? and users.id = user_client.user_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, userid);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	client = new Client(); // testirebadoba!!!
            	fillClient(client,rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return client;
	}
	public static Hotel loadHotel(int userid) {
		conn = DBConnection.createConnection();
		Hotel hotel = null;
		try {
			 String query = "SELECT * FROM seller_hotel,user_seller, users WHERE users.id = ? and users.id = user_seller.user_id and user_seller.id=seller_hotel.seller_id;";
			 PreparedStatement statement = conn.prepareStatement(query);
			 statement.setInt(1, userid);
			 ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	hotel = new Hotel();
            	fillHotel(hotel,rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return hotel;
	}
	public static Agency loadAgency(int userid) {
		conn = DBConnection.createConnection();
		Agency agency = null;
		try {
            String query = "SELECT * FROM seller_agency,user_seller, users WHERE users.id = ? and users.id = user_seller.user_id and user_seller.id=seller_agency.seller_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, userid);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	agency = new Agency();
            	fillAgency(agency,rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }        
		return agency;
	}
	public static ArrayList<Hotel> getHotelsFromDB(){
		conn = DBConnection.createConnection();
		ArrayList<Hotel> list =  new ArrayList<Hotel>();
		try {
			String query = "SELECT * FROM seller_hotel, user_seller, users WHERE users.id = user_seller.user_id and user_seller.id=seller_hotel.seller_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Hotel hotel = new Hotel();
            	fillHotel(hotel,rs);
                list.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return list;
	}
	
	public static ArrayList<Agency> getAgenciesFromDB(){	
		conn = DBConnection.createConnection();
		ArrayList<Agency> list =  new ArrayList<Agency>();
		try {
            String query = "SELECT * FROM seller_agency,user_seller, users WHERE users.id = user_seller.user_id and user_seller.id=seller_agency.seller_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	Agency agency = new Agency();
            	fillAgency(agency,rs);
            	list.add(agency);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }        
		return list;
	}
	
	public static boolean isValidUsername(String username) {
		conn = DBConnection.createConnection();
		boolean p = true;
		try {
			String query = "select * from users where username = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);			
			ResultSet res = statement.executeQuery();
			if (res.next())
				p = false;
		} catch (SQLException e) {
			// aq ravi ra qnas
		} finally {
			DBConnection.closeConnection();
		}
		return p;		
	}		
	public static boolean isValidIdentificator(int id) {
		conn = DBConnection.createConnection();
		boolean p = true;
		try {
			String query = "select * from user_seller where identificator = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);			
			ResultSet res = statement.executeQuery();
			if (res.next())
				p = false;
		} catch (SQLException e) {
			// aq ravi ra qnas
		} finally {
			DBConnection.closeConnection();
		}
		return p;	
	}
	
	private synchronized static void fillUser(User user,ResultSet rs){		
		try {			
			user.setId(rs.getInt("user_id"));		
			user.setUsername(rs.getString("username"));
	    	user.setEmail(rs.getString("email"));
	    	user.setPassword(rs.getString("password"));
	    	user.setTelephone(rs.getString("telephone"));
		} catch (SQLException e) {
			System.out.println("useris catch shevida");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
	}
	private synchronized static void fillClient(Client client,ResultSet rs) {
		fillUser(client,rs);
		try {
			client.setName(rs.getString("name"));
			client.setSurName(rs.getString("surname"));	    	
	    	client.setClientId(rs.getInt("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
	}
	private synchronized static void fillSeller(Sellers seller, ResultSet rs) {
		fillUser(seller,rs);
		try {
			seller.setName(rs.getString("name"));
<<<<<<< HEAD

			seller.setAdress(rs.getString("adress"));
	    	seller.setTelephone(rs.getString("telephone"));
	    	seller.setSellerId(rs.getInt("id"));

			seller.setAdress(rs.getString("adress"));	    	
	    	seller.setSellerId(rs.getInt("id"));

=======
			seller.setAdress(rs.getString("adress"));	    	
	    	seller.setSellerId(rs.getInt("seller_id"));
>>>>>>> b0606d7a4e2ed7070891b8b3512285e790d4c1d8
	    	seller.setIdentificator(rs.getInt("identificator"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
	}
	private synchronized static void fillAgency(Agency agency, ResultSet rs) {
		fillSeller(agency,rs);
		try {
			agency.setAgencyId(rs.getInt("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private synchronized static void fillHotel(Hotel hotel, ResultSet rs) {		
		fillSeller(hotel,rs);
		try {
			hotel.setStars(rs.getInt("stars"));
			hotel.setHotelId(rs.getInt("id"));
		} catch (SQLException e) {
			System.out.println("catch");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}