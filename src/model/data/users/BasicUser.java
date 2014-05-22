package model.data.users;


/*
 * this class contains basic, minimal structure for registration and login.
 * it is parent of User Class.
 */

public class BasicUser {
	private String username;
	private String password;
	
	public BasicUser() {		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}		
}
