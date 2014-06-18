package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.data.users.User;
import model.data.users.Agency;


public class AgencyStorage {
	private Connection con;
	private UsersStorage storage;
	
	public AgencyStorage(){
			con = DBConnection.createConnection();
			storage = new UsersStorage();
			
	}
	
	public boolean saveAgency(Agency agency){
		boolean retVal = false;
		User user = new User();
		user.setPassword(agency.getPassword());
		user.setUsername(agency.getUsername());
		user.setEmail(agency.getEmail());
		if(storage.saveUser(user)){
			int id = 0;
			try {
				String q = "SELECT * FROM users WHERE username = ? and password = ?;";
				PreparedStatement statement = con.prepareStatement(q);
				statement.setString(1, agency.getUsername());
				statement.setString(2, agency.getPassword());
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
					String query = "INSERT INTO user_agency (user_id,agency_name,adress,telephone) VALUES (?,?,?,?);";
					PreparedStatement statement = con.prepareStatement(query);
					statement.setInt(1, id);
					statement.setString(2, agency.getName());
					statement.setString(3, agency.getAdress());
					statement.setString(4, agency.getTelephone());
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
	
	
	public int isValidAgency(Agency agency){
		int retVal = -1;
		try {
			String query = "select users.id,user_agency.user_id from user_agency,users where users.username = ? and users.password = ? and users.id = user_agency.user_id;";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, agency.getUsername());
			statement.setString(2, agency.getPassword());
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
	
	public Agency loadAgency(int id) {
		Agency agency = null;
		try {
            String query = "SELECT * FROM user_agency, users WHERE users.id = ? and users.id = user_agency.user_id;";
            PreparedStatement statement = con.prepareStatement(query);
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
