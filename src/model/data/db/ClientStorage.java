package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.data.users.Client;
import model.data.users.User;

public class ClientStorage{
	private Connection con;
	private UsersStorage storage;
	
	public ClientStorage(){
			con = DBConnection.createConnection();
			storage = new UsersStorage();
			
	}
	
	public boolean saveClient(Client client){
		boolean retVal = false;
		User user = new User();
		user.setPassword(client.getPassword());
		user.setUsername(client.getUsername());
		user.setEmail(client.getEmail());
		if(storage.saveUser(user)){
			int id = 0;
			try {
				String q = "SELECT * FROM users WHERE username = ? and password = ?;";
				PreparedStatement statement = con.prepareStatement(q);
				statement.setString(1, client.getUsername());
				statement.setString(2, client.getPassword());
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
					String query = "INSERT INTO user_client (user_id,name,surname,telephone) VALUES (?,?,?,?);";
					PreparedStatement statement = con.prepareStatement(query);
					statement.setInt(1, id);
					statement.setString(2, client.getName());
					statement.setString(3, client.getSurName());
					statement.setString(4, client.getTelephone());
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
	
	
	public int isValidClient(Client client){
		int retVal = -1;
		try {
			String query = "select users.id,user_client.user_id from user_client,users where users.username = ? and users.password = ? and users.id = user_client.user_id;";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, client.getUsername());
			statement.setString(2, client.getPassword());
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
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            	client = new Client();
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

	
}

