package model.data;

import model.data.users.Hotel;

/*
 * during the trip you may visit several "locations"
 * this class object is this "location", that contains information about part of the trip:
 * hotel - where you are staying, duration - how many days are you staying and city
 */
public class Location { // this class is trip helper class
	private Hotel hotel = new Hotel(); // hotel, where you are staying
	private int duration; // duration in days
	private String city; // name of city
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
}

