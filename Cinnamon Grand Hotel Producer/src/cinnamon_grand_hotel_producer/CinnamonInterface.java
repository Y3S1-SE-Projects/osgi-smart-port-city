package cinnamon_grand_hotel_producer;

import java.util.List;

public interface CinnamonInterface {

	public int calAmount(int roomPrice, int noRooms, int noDays);
	public void printBill(List<Booking> booking);
}
