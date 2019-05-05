package model.data.users;

public class Hotel extends Sellers{
	private int hotelId,roomsNum,stars;
	
	
	public Hotel() {		
	}
	
	
	public void setHotelId(int hotelId){
		this.hotelId = hotelId;
	}
	
	public int getHotelId(){
		return hotelId;
	}
	
	public void setStars(int stars){
		this.stars = stars;
	}
	
	public int getStars(){
		return stars;
	}
	
	public void setRoomNum(int roomsNum){
		this.roomsNum = roomsNum;
	}
	
	public int getRoomNum(){
		return roomsNum;
	}
	
}
