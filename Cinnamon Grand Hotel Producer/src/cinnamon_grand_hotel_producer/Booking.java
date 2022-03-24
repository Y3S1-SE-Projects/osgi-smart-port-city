package cinnamon_grand_hotel_producer;

public class Booking {
	
	private String name;
	private String nic;
	private String phone;
	private String roomType;
	private int roomPrice;
	private int noRooms;
	private String meals;
	private int noDays;
	
	public Booking(String name, String nic, String phone, String roomType, int roomPrice, int noRooms, String meals, int noDays) {
		
		this.name = name;
		this.nic = nic;
		this.phone = phone;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.noRooms = noRooms;
		this.meals = meals;
		this.noDays = noDays;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	public String getMeals() {
		return meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}
	

}
