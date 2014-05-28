package model.data.users;

import model.data.Wishlist;

public class Client extends User{

	private Wishlist wishlist;	
	private String name, surName;	
	public Client() {	
		
	}
	public String getName() {
		return name;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public Wishlist getWishlist (){
		return wishlist;
	}
}
	

