package model.data;


/*
 * during the trip you may visit several "locations"
 * this class object is this "location", that contains information about part of the trip:
 * hotel - where you are staying, duration - how many days are you staying and city
 */
public class Location { // this class is trip helper class
	private int hotel; 
	private int duration; // duration in days
	private String city; // name of the city
	private int userId; // userId corresponding to hotel.
	private int id;
	public int getHotel() { // returns hotel's identification 
		return hotel;
	}
	public void setHotel(int i) {
		this.hotel = i;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}	
}