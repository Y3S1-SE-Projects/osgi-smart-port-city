package cinnamon_grand_hotel_producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CinnamonInterfaceImpl implements CinnamonInterface {
	
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public int calAmount(int roomPrice, int noRooms, int noDays) {
		
		return roomPrice*noRooms*noDays;
		
	}

	@Override
	public void printBill(List<Booking> roomBookings) {
		LocalDateTime date = LocalDateTime.now();
		int subtotal =0, total=0;
		
		System.out.println("************************************************************************");
		System.out.println("                              Cinnamon Grand Hotel                      ");
		System.out.println("                                   Colombo 03                           ");
		System.out.println(date.format(dateFormat));
		System.out.println("************************************************************************");
		System.out.println("Name: "+roomBookings.get(0).getName());
		System.out.println("Phone no: "+roomBookings.get(0).getPhone());
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("%5s %15s %14s %15s %12s\n", "Room Type", "Room Price", "Quantity", "No of Days", "Amount");
		for (Booking book : roomBookings) {
			subtotal=calAmount(book.getRoomPrice(),book.getNoRooms(),book.getNoDays());
			total+=subtotal;
			System.out.printf("%8s %13s %13s %14s %17s \n", book.getRoomType(), book.getRoomPrice(),book.getNoRooms() ,book.getNoDays(), subtotal);
			
		}
		System.out.println("************************************************************************");
		System.out.printf("%7s %57s\n","Net Total: ",total);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("************************************************************************");
		
		
	}
}
