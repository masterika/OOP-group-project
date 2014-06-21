package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.data.Location;
import model.data.Trip;
public class StaticTripStorage {	
	private static Connection conn;	
	public static boolean saveTrip(Trip trip,int agencyId) {		
		conn = DBConnection.createConnection();
		boolean retVal = false;		
			try { 				
				String query = "INSERT INTO agency_trips (agency_id,trip_type,trip_name,price) VALUES (?,?,?,?);";
				PreparedStatement statement = conn.prepareStatement(query);				
				statement.setInt(1, agencyId);				
				statement.setString(2, trip.getType());
				statement.setString(3, trip.getName());
				statement.setInt(4,trip.getPrice());				
				statement.execute();				
				retVal = saveTripLocations(trip);
			} catch (SQLException e) {
				retVal = false;
			} finally {
				DBConnection.closeConnection();
			}		
		return retVal;		
	}
	private static boolean saveTripLocations(Trip trip) {		
		boolean retVal = true;
		int tripId = getTripId(trip.getName());		
		if (tripId != -1) {
			List<Location> locations = trip.getLocations();
			for (int i=0; i<locations.size(); i++)
				if (!insertLocation(locations.get(i),tripId))
					retVal = false;				
		}
		return retVal;		
	}
	private static boolean insertLocation(Location location, int tripId) {
		boolean retVal = true;
		try { 
			String query = "INSERT INTO locations (location_name,hotel_id,trip_id,period) VALUES (?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, location.getCity());
	//		statement.setInt(2, getHotelId(location.getHotel())); // -1 tu sheinaxavs znachit ar gvaq bazahi egeti hoteli.
			statement.setInt(3, tripId);
			statement.setInt(4,location.getDuration());
			statement.execute();			
		} catch (SQLException e) {
			retVal = false;
		}
		return retVal;
	}
	private static int getHotelId(int identificator) {
		int id = -1;
		try {
			String q = "SELECT * FROM seller_hotel,user_seller WHERE user_seller.identificator = ? and seller_hotel.id=user_seller.;";
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setInt(1, identificator);		
			ResultSet rs = statement.executeQuery();
			if (rs.next())
				id = rs.getInt("id");			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return id;		
	}
	private static int getTripId(String name) {
		int id = -1;
		try {
			String q = "SELECT * FROM agency_trips WHERE trip_name = ?;";
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setString(1, name);		
			ResultSet rs = statement.executeQuery();
			if (rs.next())
				id = rs.getInt("id");			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return id;		
	}	
	public static Trip loadTrip(int agencyId) {
		conn = DBConnection.createConnection();
		Trip trip = new Trip();
		try {
			String query = "SELECT * FROM agency_trips WHERE id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, agencyId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				trip.setId(rs.getInt("id"));
				trip.setName(rs.getString("trip_name"));
				trip.setPrice(rs.getInt("price"));
				trip.setType("trip_type");
				trip.setLocations(loadLocations(trip.getId()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return trip;		
	}
	public static  List<Location> loadLocations(int tripId) {
		List<Location> locations = new ArrayList<Location>();
		try {			
			String query = "SELECT * FROM locations WHERE trip_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, tripId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {	
				Location location = new Location();
				location.setCity(rs.getString("location_name"));
				location.setDuration(rs.getInt("period"));
//				location.setHotel(getHotelById(rs.getInt("hotel_id")));
				locations.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locations;		
	}
	private static int getHotelById(int id) { // returns hotel's identificator according to its id
		int identificator = -1;
		try {			
            String query = "SELECT * FROM user_seller,  WHERE seller_hotel.seller_id = ? and user_seller.id=seller_hotel.seller_id";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            	identificator = (rs.getInt("identificator"));           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return identificator;		
	}
}
