package User;

//Item model class
public class Customer {
	
	//Defining Variables
	public float price;
	public int qty;
	public String item;

	//Getters  
	public float getprice() {
		return price;
	}

	public void setprice(float price) {
		this.price = price;
	}

	public int getqty() {
		return qty;
	}

	//Setters
	public void setqty(int qty) {
		this.qty = qty;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String items) {
		this.item = items;
	}
}