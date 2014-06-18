package model.data.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.Location;
import model.data.Trip;


/*
 * aklia reitingi da comentarebi, 
 * agretve mxolod im shemtxvevistvisaa dawerili rodesac tripi mxolod registrirebul sastumroebs stumrobs
 * later-is chasworeba araa rtuli, mosalaparakebelia girs tu ara 
 * */
public class TripStorage {
	private int agencyId;
	private Connection conn;
	public TripStorage(){}
	public TripStorage(int id) {
		this.agencyId=id;		
	}
	public boolean saveTrip(Trip trip) {		
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
	private boolean saveTripLocations(Trip trip) {		
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
	private boolean insertLocation(Location location, int tripId) {
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
	private int getHotelId(String name) {
		int id = -1;
		try {
			String q = "SELECT * FROM user_hotel WHERE hotel_name = ?;";
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
	private int getTripId(String name) {
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
	public Trip loadTrip(int id) {
		conn = DBConnection.createConnection();
		Trip trip = new Trip();
		try {
			String query = "SELECT * FROM agency_trips WHERE id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
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
	private List<Location> loadLocations(int id) {
		List<Location> locations = new ArrayList<Location>();
		try {			
			String query = "SELECT * FROM locations WHERE trip_id = ?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {	
				Location location = new Location();
				location.setCity(rs.getString("location_name"));
				location.setDuration(rs.getInt("period"));
				location.setHotel(getHotelById(rs.getInt("hotel_id")));
				locations.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locations;		
	}
	private String getHotelById(int id) { // returns hotel's name according to its id
		String hotelName = "";
		try {			
            String query = "SELECT * FROM user_hotel, users WHERE user_hotel.user_id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            	hotelName = (rs.getString("hotel_name"));           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return hotelName;		
	}
}
