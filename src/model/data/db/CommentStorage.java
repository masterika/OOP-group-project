package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.Comment;
import model.data.Trip;

public class CommentStorage {
	private static Connection conn;
	public static boolean saveComment(Comment comment) {
		conn = DBConnection.createConnection();
		boolean retVal = false;
		try {			
			String query = "INSERT INTO comment (text,object,object_id,user_id) VALUES (?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, comment.getText());
			statement.setInt(2, comment.getType());
			statement.setInt(3, comment.getObjectId());
			statement.setInt(4, comment.getUserId());
			statement.execute();
			retVal = true;
		} catch (SQLException e) {			
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;	
	}
	public static List<Comment> loadComments(int type, int objectId) {		
		conn = DBConnection.createConnection();
		List<Comment> comments = new ArrayList<Comment>();
		try {
			String query = "SELECT * FROM comment WHERE object = ? and object_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, type);
			statement.setInt(2,objectId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {				
				Comment comment = new Comment(); //testireba!
				fillComment(comment,rs);	
				comments.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}			
		return comments;		
	}
	private static void fillComment(Comment comment, ResultSet rs) {
		try {			
			comment.setType(rs.getInt("object")); 
			comment.setObjectId(rs.getInt("object_id"));
			comment.setUserId(rs.getInt("user_id"));
			comment.setText(rs.getString("text"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
