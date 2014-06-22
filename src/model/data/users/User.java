package model.data.users;

import java.util.Date;

public class User{
	private int id;	
	private String email;
	private String username;
	private String password;
	private String telephone;
	private boolean isApproved;
	private Date date;


	public User() {
		id = -1;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}		

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void setApprStatus(int i){
		if (i==1) isApproved = false;
		else isApproved = true;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public boolean getApprStatus(){
		return isApproved;
	}
	
	public Date getDate(){
		return date;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
