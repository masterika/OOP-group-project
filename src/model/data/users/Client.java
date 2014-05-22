package model.data.users;

import java.util.HashMap;

public class Client extends User{
	/* in following structure we store users wishlist of hotel rooms and trips together
	 * thus we chose ProductID as a value: both of them implement it and we need its methods. 
	 * we will use getClass methods and then cast to use them, when we need them
	 * we have ID as key. this ID is not same ID as in database,
	 *  because room numbers and trips might have same IDs in base.
	 *  this key is unique identifier of product.
	 * */
	private HashMap<String,Product> wishList = new HashMap<String,Product>();	
	private String name, surName;	
	public Client() {		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Product getProduct(String ID) {
		return wishList.get(ID);
	}
	public HashMap<String,Product> getContent() {
		return wishList;
	}	
	public void addProduct(Product product) {
		wishList.put(product.getID(),product);
	}
}
