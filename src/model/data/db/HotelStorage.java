package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
	
	
	public boolean isValidHotel(Hotel hotel){
		boolean retVal = false;
		try {
			String query = "select * from user_hotel,users where users.username = ? and users.password = ? and users.id = user_hotel.user_id;";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, hotel.getUsername());
			statement.setString(2, hotel.getPassword());
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				retVal = true;
			} else {
				retVal = false;
			}
		} catch (SQLException e) {
			retVal = false;
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;
		
	}
	
	public Hotel loadHotel(String username) {
		Hotel hotel = null;
		try {
            String query = "SELECT * FROM user_hotel, users WHERE users.username = ? and users.id = user_hotel.user_id;";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
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

}
