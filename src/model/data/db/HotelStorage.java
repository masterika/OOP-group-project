package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import model.data.users.Hotel;
import model.data.users.User;

public class HotelStorage {
	private Connection con;
	private UsersStorage storage;
	
	public HotelStorage(){
			con = DBConnection.createConnection();
			storage = new UsersStorage();
			
	}
	
	public boolean saveHotel(Hotel hotel){
		boolean retVal = false;
		User user = new User();
		user.setPassword(hotel.getPassword());
		user.setUsername(hotel.getUsername());
		user.setEmail(hotel.getEmail());
		if(storage.saveUser(user)){
			int id = 0;
			try {
				String q = "SELECT * FROM users WHERE username = ? and password = ?;";
				PreparedStatement statement = con.prepareStatement(q);
				statement.setString(1, hotel.getUsername());
				statement.setString(2, hotel.getPassword());
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					id = rs.getInt("id");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.closeConnection();
			}
		
			
			if(id !=0){
				try {
					String query = "INSERT INTO user_hotel (user_id,hotel_name,adress,telephone,rooms_num,stars) VALUES (?,?,?,?,?,?);";
					PreparedStatement statement = con.prepareStatement(query);
					statement.setInt(1, id);
					statement.setString(2, hotel.getName());
					statement.setString(3, hotel.getAdress());
					statement.setString(4, hotel.getTelephone());
					statement.setInt(5, hotel.getRoomNum());
					statement.setInt(6, hotel.getStars());
					statement.execute();
					retVal = true;        
				} catch (SQLException e) {
					retVal = false;
				}finally{
					DBConnection.closeConnection();
				}	
			}
		}
		return retVal;
		
	}
	
	
	public int isValidHotel(Hotel hotel){
		int retVal = -1;
		try {
			String query = "select users.id,user_hotel.user_id from user_hotel,users where users.username = ? and users.password = ? and users.id = user_hotel.user_id;";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, hotel.getUsername());
			statement.setString(2, hotel.getPassword());
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
	
	public Hotel loadHotel(int id) {
		Hotel hotel = null;
		try {
            String query = "SELECT * FROM user_hotel, users WHERE users.id = ? and users.id = user_hotel.user_id;";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            	hotel = new Hotel();
            	hotel.setName(rs.getString("hotel_name"));
            	hotel.setAdress(rs.getString("adress"));
            	hotel.setTelephone(rs.getString("telephone"));
            	hotel.setId(rs.getInt("user_id"));
            	hotel.setUsername(rs.getString("username"));
            	hotel.setEmail(rs.getString("email"));
            	hotel.setPassword(rs.getString("password"));
            	hotel.setHotelId(rs.getInt("user_hotel.id"));
            	hotel.setRoomNum(rs.getInt("rooms_num"));
            	hotel.setStars(rs.getInt("stars"));
            	
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
				
		 return hotel;
	}

	public ArrayList<Hotel> getHotelsFromDB(){
		ArrayList<Hotel> list =  new ArrayList<Hotel>();
		try {
            String query = "SELECT * FROM user_hotel, users WHERE users.id = user_hotel.user_id;";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Hotel hotel = new Hotel();
            	hotel.setName(rs.getString("hotel_name"));
            	hotel.setAdress(rs.getString("adress"));
            	hotel.setTelephone(rs.getString("telephone"));
            	hotel.setId(rs.getInt("user_id"));
            	hotel.setUsername(rs.getString("username"));
            	hotel.setEmail(rs.getString("email"));
            	hotel.setPassword(rs.getString("password"));
            	hotel.setHotelId(rs.getInt("user_hotel.id"));
            	hotel.setRoomNum(rs.getInt("rooms_num"));
            	hotel.setStars(rs.getInt("stars"));
            	list.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return list;
	}
}
