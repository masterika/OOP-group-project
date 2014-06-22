package model.data.users;

/*
 * this class is parent of hotel and agency classes, containing their mutual methods
 */
public class Sellers extends User {
	private String name;
	private String adress;	
	private int identificator;
	private int SellerId;
	private boolean isApproved;
	public Sellers() {		
	}
	public String getName() {
		return name;
	}
	public int getIdentificator() {
		return identificator;
	}
	public void setIdentificator(int identificator) {
		this.identificator = identificator;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
<<<<<<< HEAD
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setApprStatus(int i){
		if (i==1) isApproved = false;
		else isApproved = true;
	}
	
	public boolean getApprStatus(){
		return isApproved;
	}
=======
	}	
>>>>>>> 7813c3a15bfb0b5a26ca8ae59432b297468af762
	
	/* these last to methods doesn't take part in registration */
	public void setRating() {}
	public Object getRating() {return null;}
	public int getSellerId() {
		return SellerId;
	}
	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}
}
