package model.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.Location;
import model.data.Trip;
import model.data.users.Hotel;
public class StaticTripStorage {	
	private static Connection conn;	
	public static int saveTrip(Trip trip) {			
		conn = DBConnection.createConnection();
		int retVal = -1;	
		boolean p = true;
			try { 				
				String query = "INSERT INTO agency_trips (agency_id,trip_type,trip_name,price) VALUES (?,?,?,?);";
				PreparedStatement statement = conn.prepareStatement(query);				
				statement.setInt(1, trip.getAgencyId());				
				statement.setString(2, trip.getType());				
				statement.setString(3, trip.getName());				
				statement.setInt(4,trip.getPrice());				
				statement.execute();
				if (p) {
					retVal = getTripId(trip.getName());					
				}
				p = saveTripLocations(trip);				
			} catch (SQLException e) {
				p = false;				
			} finally {
				DBConnection.closeConnection();
			}				
		return retVal;		
	}
	
	private static int getTripId(String name) { // uewvli gasasworebelia, name sheileba 2 ertnairi iyos/ isnertlastid da misi jani ra
		int id = -1;
		try {
			String q = "SELECT * FROM agency_trips where trip_name = ?;";
			PreparedStatement statement = conn.prepareStatement(q);
			statement.setString(1, name);		
			ResultSet rs = statement.executeQuery();		
			if (rs.next()) {
				id = rs.getInt("id");				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		return id;
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
			statement.setInt(2, getHotelId(location.getHotel())); // -1 tu sheinaxavs znachit ar gvaq bazahi egeti hoteli.
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
			String q = "SELECT * FROM seller_hotel,user_seller WHERE user_seller.identificator = ? and seller_hotel.seller_id=user_seller.id;";
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
	public static Trip loadTrip(int tripId) {
		conn = DBConnection.createConnection();
		Trip trip = new Trip();
		try {
			String query = "SELECT * FROM agency_trips WHERE id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, tripId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				fillTrip(trip,rs);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return trip;		
	}
	

	public static List<Trip> loadTrips(int agencyId) {		
		conn = DBConnection.createConnection();
		List<Trip> trips = new ArrayList<Trip>();
		try {
			String query = "SELECT * FROM agency_trips WHERE agency_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, agencyId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {				
				Trip trip = new Trip();
				fillTrip(trip,rs);	
				trips.add(trip);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return trips;		
	}
	private static void fillTrip(Trip trip, ResultSet rs) {
		try {
			trip.setId(rs.getInt("id"));
			trip.setAgencyId(rs.getInt("agency_id"));
			trip.setName(rs.getString("trip_name"));
			trip.setPrice(rs.getInt("price"));
			trip.setType(rs.getString("trip_type"));
			trip.setLocations(loadLocations(getTripId(trip.getName())));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	private static  List<Location> loadLocations(int tripId) {
		List<Location> locations = new ArrayList<Location>(); // testireba?
		try {			
			String query = "SELECT * FROM locations WHERE trip_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, tripId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {	
				Location location = new Location();
				location.setCity(rs.getString("location_name"));
				location.setDuration(rs.getInt("period"));
				location.setHotelId(rs.getInt("hotel_id"));
				locations.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locations;		
	}	

	/*chemi azrit araswori arqiteqturis bralia. 
	 * memgoni staticstorageshi clientis hotelis agencys loadi
	 *  tavianti idis mixedvit unda xdebodes da ara userId is mixedvit... 
	 */
	
	public static Hotel loadHotel(int hotelId){ 
		conn = DBConnection.createConnection();
		Hotel hotel = new Hotel();
		int userId = -1;
		try {
			String query = "SELECT * FROM seller_hotel,user_seller, users WHERE seller_hotel.id = ? and users.id = user_seller.user_id and user_seller.id=seller_hotel.seller_id;";
			PreparedStatement statement = conn.prepareStatement(query);
			 statement.setInt(1, hotelId);
			 ResultSet rs = statement.executeQuery();
		     if (rs.next()) {
		       	userId = rs.getInt("users.id");
		       	hotel = StaticStorage.loadHotel(userId);
		     }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }finally{
	    	DBConnection.closeConnection();
	    }
		return hotel;		
	}
	
	public static void changeTripPrice(int tripId,String price){ 
		conn = DBConnection.createConnection();
		try {
			String query = "UPDATE agency_trips SET price = ? where id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, price);
			statement.setInt(2, tripId);
			statement.execute();
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }finally{
	    	DBConnection.closeConnection();
	    }
			
	}
	
}
