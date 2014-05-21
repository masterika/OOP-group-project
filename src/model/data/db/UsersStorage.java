package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.data.users.Hotel;
import model.data.users.User;

public class UsersStorage implements UsersStorageInterface{

	@Override
	public boolean saveUser(User user) {
		boolean retVal = false;
		Connection conn = DBConnection.createConnection();
		try {
            String query = "INSERT INTO users (username,password,email) VALUES (?,?,?);";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.execute();
            retVal = true;
        } catch (SQLException e) {
            retVal = false;
        }finally{
        	DBConnection.closeConnection();
        }
		return retVal;
	}
	
	public boolean isValidUser(User user){
		boolean retVal = false;
		Connection conn = DBConnection.createConnection();
		try {
            String query = "select * from users where username = ? and password = ?;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet res = statement.executeQuery();
            if(res.next()){
                retVal = true;
           } else {
                retVal = false;
           }
        } catch (SQLException e) {
            retVal = false;
        }finally{
        	DBConnection.closeConnection();
        }
		return retVal;
	}

	@Override
	public User loadUser(int id) {
		User user = null;
		Connection conn = DBConnection.createConnection();
		try {
            String query = "SELECT * FROM users WHERE id = ?;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            	user = new Hotel((int) rs.getObject(1));
            	user.setUsername((String) rs.getObject(2));
            	user.setPassword((String) rs.getObject(3));
            	user.setEmail((String) rs.getObject(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.closeConnection();
        }
		return user;
	}

}
