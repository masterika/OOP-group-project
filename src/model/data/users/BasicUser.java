package model.data.users;


/*
 * this class contains basic, minimal structure for registration and login.
 * it is parent of User Class.
 */

public class BasicUser {
	private String userName;
	private String password;
	
	public BasicUser() {		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}		
}
