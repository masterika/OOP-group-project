package model.data;

public class Comment {
	private String text; // comment
	private int userId; // user which has commented
	private int objectId;// object where user has commented
	private int type; // type of object on what has been commented (1 = hotel, 2=agency 3=trip);
	public Comment(){
				
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}	
}
