package model.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String MYSQL_USERNAME = "root";
<<<<<<< HEAD

	private static final String MYSQL_PASSWORD = "1234";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "turista";

=======
	private static final String MYSQL_PASSWORD = "irakli500";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "turista";
	
>>>>>>> 208c31898e9025f5e894256c3cb375d58ba56b34
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
