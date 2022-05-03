package implementation;

public class Item {
	
	public String name;
	public String category;
	public double price;
	public int amount;
	public boolean isOnSale;
	public String desc;
	
	public Item(String name, String category, double price, int amount, boolean isOnSale, String desc) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.amount = amount;
		this.isOnSale = isOnSale;
		this.desc = desc;
	}
	
	public Item()
	{
		super();
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean getSale() {
		return this.isOnSale;
	}

	public void setSale(boolean sale) {
		this.isOnSale = sale;
	}
	
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
