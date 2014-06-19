package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.data.users.User;

public class AdminStorage {
	private static Connection con;

	public static int getNumOfUsers() {
		con = DBConnection.createConnection();
		int numOfUsers = 0;
		try {

			String query = "SELECT COUNT(*) AS numOfUsers FROM users";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				numOfUsers = rs.getInt("numOfUsers");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return numOfUsers;

	}

	public static ArrayList<User> getRecentUsers(Date date) {
		ArrayList<User> users = new ArrayList<User>();
		con = DBConnection.createConnection();
		User user = null;

		try {
			String query = "SELECT * FROM users WHERE Date >'" + date + "'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
				user.setApprStatus(rs.getInt("is_approved"));
				user.setDate((Date)rs.getDate("Date"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}

		return users;
	}

}
