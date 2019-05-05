package model.data;
import java.util.ArrayList;
import java.util.List;
import model.data.users.Product;
public class Trip implements Product{
	private int id;
	private String name;
	private int userId;// userId corresponding to trip owner agency 
	private String type; // 2 men trip, 10 men group team or ect.
	private String sDate;
	private String eDate;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
	private List<Location> Locations = new ArrayList<Location>();
	public Trip(){		
	}
	public int getId(){
		return id;
	}	
	public String getName(){
		return name;
	}	
	public void setId(int i) {
		this.id = i;		
	}
	public List<Location> getLocations() {
		return Locations;
	}
	public void setLocations(List<Location> locations) {
		Locations = locations;
	}
	public void addLocation(Location location) {
		Locations.add(location);
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}	
}
