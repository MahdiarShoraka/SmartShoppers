package implementation;
import java.util.ArrayList;

public class Store {
	
	public String location;
	public ArrayList<Item> items;
	
	public double openingHour;
	public double closingHour;
	
	//Map properties
	public String upperSection;
	public String lowerSection;
	public String leftSection;
	public String rightSection;
	
	public Store(String location, ArrayList<Item> items) {
		super();
		this.location = location;
		this.items = items;
	}
	
	public Store(String location, ArrayList<Item> items, double openingHour, double closingHour, String upperSection, String lowerSection, String rightSection, String leftSection) {
		super();
		this.location = location;
		this.items = items;
		this.openingHour = openingHour;
		this.closingHour = closingHour;
		this.upperSection = upperSection;
		this.lowerSection = lowerSection;
		this.rightSection = rightSection;
		this.leftSection = leftSection;
	}
	
	public Store() {
		super();
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public double getOpeningHour() {
		return this.openingHour;
	}
	
	public void setOpeningHour(double opening) {
		this.openingHour = opening;
	}
	
	public double getClosingHour() {
		return this.closingHour;
	}
	
	public void setClosingHour(double closing) {
		this.closingHour = closing;
	}
	
	public String getUpper() {
		return this.upperSection;
	}
	
	public String getLower() {
		return this.lowerSection;
	}
	
	public String getLeft() {
		return this.leftSection;
	}
	
	public String getRight() {
		return this.rightSection;
	}
	
	public void setUpper(String upper) {
		this.upperSection = upper;
	}
	
	public void setLower(String lower) {
		this.lowerSection = lower;
	}
	
	public void setLeft(String left) {
		this.leftSection = left;
	}
	
	public void setRight(String right) {
		this.rightSection = right;
	}

}
