package model.data.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.WishProduct;
public class StaticWishlistStorage {
	private static Connection conn;
	public static boolean saveProduct(WishProduct WishProduct) {		
		conn = DBConnection.createConnection();
		boolean retVal = false;
		try {					
			String query = "INSERT INTO wishlist (object_id,user_id,type) VALUES (?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, WishProduct.getObjectId());
			statement.setInt(2, WishProduct.getUserId());
			statement.setString(3, WishProduct.getType());			
			statement.execute();
			retVal = true;
		} catch (SQLException e) {			
		} finally {
			DBConnection.closeConnection();
		}
		return retVal;	
	}
	public static List<WishProduct> loadProductList(int userId, String type) {		
		conn = DBConnection.createConnection();
		List<WishProduct> products = new ArrayList<WishProduct>();
		try {
			String query = "SELECT * FROM wishlist WHERE type = ? and user_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, type);
			statement.setInt(2,userId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {				
				WishProduct product = new WishProduct(); //testireba! (oditganve sibrdznisaa erti dargi)
				fillProduct(product,rs);	
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}			
		return products;		
	}
	private static void fillProduct(WishProduct product, ResultSet rs) {
		try {			
			product.setType(rs.getString("type")); 
			product.setObjectId(rs.getInt("object_id"));
			product.setUserId(rs.getInt("user_id"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void DeleteWishListItem(int objectId,String type){ 
		conn = DBConnection.createConnection();
		try {
			String query = "DELETE from wishlist WHERE object_id = ? and type = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, objectId);
			statement.setString(2, type);
			statement.execute();
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }finally{
	    	DBConnection.closeConnection();
	    }
	}	
}
