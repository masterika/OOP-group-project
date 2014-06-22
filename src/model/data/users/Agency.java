package model.data.users;

import java.util.HashMap;

import model.data.Trip;

public class Agency extends Sellers{	
	private HashMap<Integer,Trip> trips;		
	private int agencyId;	
	public Agency() {		
	}	
	public void setAgencyId(int agencyId){
		this.agencyId = agencyId;
	}
	
	public int getAgencyId(){
		return agencyId;
	}
	

	
	
	
	
	
	
	public Trip getTrip(int tripID) {
		return trips.get(tripID);
	}
	public void addTrip (Trip trip) {
		trips.put(trip.getId(),trip);
	}	
}
