package kingsbury_hotel_producer;

import java.util.List;

public interface KingsburyInterface {

	public int calAmount(int roomPrice, int noRooms, int noDays);
	public void printBill(List<KingsBooking> booking , int discount);
}
