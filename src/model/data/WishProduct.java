package model.data;

public class WishProduct {
	private int objectId;// object where user has commented
	private String type; // type of object on what has been commented (1 = hotel, 2=agency 3=trip);
	private int userId;
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
