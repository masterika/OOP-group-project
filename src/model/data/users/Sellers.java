package model.data.users;

/*
 * this class is parent of hotel and agency classes, containing their mutual methods
 */
public class Sellers extends User {
	private String name;
	private String adress;
	public Sellers() {		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	/* these last to methods doesn't take part in registration */
	public void setRating() {}
	public Object getRating() {return null;}
}
