package model.data.users;

import model.data.Wishlist;

public class Client extends User{

	private Wishlist wishlist;
	private int clientId;
	private String name, surname;
	public Client() {	
		
	}
	
	public void setClientId(int clientId){
		this.clientId = clientId;
	}
	
	public int getClientId(){
		return clientId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setSurName(String surname){
		this.surname = surname;
	}	
	
	public String getName() {
		return name;
	}
	
	public String getSurName() {
		return surname;
	}
	
	public Wishlist getWishlist (){
		return wishlist;
	}
}
	

