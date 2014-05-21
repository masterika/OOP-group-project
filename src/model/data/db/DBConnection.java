package model.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "7676";
	private static final String MYSQL_DATABASE_SERVER = "localhost:456";
	private static final String MYSQL_DATABASE_NAME = "turista";

	private static Connection conn;

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/"
					+ MYSQL_DATABASE_NAME;
			conn = DriverManager.getConnection(url, MYSQL_USERNAME,
					MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
