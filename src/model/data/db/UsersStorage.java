package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.data.users.User;

public class UsersStorage implements UsersStorageInterface {
	private Connection conn;

	public UsersStorage() {
		conn = DBConnection.createConnection();
	}

	public boolean saveUser(User user) {
		boolean retVal = false;
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
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;
	}

	public boolean isValidUser(User user) {
		boolean retVal = false;
		try {
			String query = "select * from users where username = ? and password = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
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

	public User loadUser(String username) {
		User user = null;
		try {
			String query = "SELECT * FROM users WHERE username = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return user;
	}

	public void changePassword(int id, String pass) {
		System.out.println(id + " " + pass);
		try {
			String query = "UPDATE users SET password = \"" + pass
					+ "\" WHERE id = \"" + id + "\"";
			Statement stmt = conn.createStatement();
			stmt.execute(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}
}
