package kingsbury_hotel_producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class KingsburyInterfaceImpl implements KingsburyInterface {
	
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public int calAmount(int roomPrice, int noRooms, int noDays) {
		
		return roomPrice*noRooms*noDays;
		
	}

	@Override
	public void printBill(List<KingsBooking> roomBookings,int discount) {
		LocalDateTime date = LocalDateTime.now();
		int subtotal =0, total=0,disamount;
		
		System.out.println("************************************************************************");
		System.out.println("                                 Kingsbury Hotel                        ");
		System.out.println("                                   Colombo 01                           ");
		System.out.println(date.format(dateFormat));
		System.out.println("************************************************************************");
		System.out.println("Name: "+roomBookings.get(0).getName());
		System.out.println("Phone no: "+roomBookings.get(0).getPhone());
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("%5s %15s %14s %15s %12s\n", "Room Type", "Room Price", "Quantity", "No of Days", "Amount");
		for (KingsBooking book : roomBookings) {
			subtotal=calAmount(book.getRoomPrice(),book.getNoRooms(),book.getNoDays());
			total+=subtotal;
			System.out.printf("%8s %13s %13s %14s %17s \n", book.getRoomType(), book.getRoomPrice(),book.getNoRooms() ,book.getNoDays(), subtotal);
			
		}
		System.out.println("************************************************************************");
		if(discount>0) {
			System.out.printf("%7s %55s\n","Gross Total: ",total);
			disamount=discount*total/100;
			total=total-disamount;
			System.out.printf("%7s %58s\n","Discount: ",disamount);
		}
		System.out.printf("%7s %57s\n","Net Total: ",total);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("************************************************************************");
		
		
	}
}
