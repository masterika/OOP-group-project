package model.data.users;

public class User extends BasicUser{
	private String id;	
	private String email;
	private String mobile;
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public User() {
		
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}
