package waruna_textile_producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class DressInterfaceImpl implements DressInterface {
	
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	public int dayQty=0;
	public int daySales=0;

	@Override
	public int billing(int unitPrice, int qty) {
		
		return unitPrice * qty;
	}

	@Override
	public void DaySummary(List<Item> items) {
		for (Item item : items) {
			dayQty+=item.getQuantity();
			daySales+=billing(item.getPrice(),item.getQuantity());
		}
		System.out.println("\nTotal quantity: "+ dayQty);
		System.out.println("Total sales: "+ daySales+"\n");
		dayQty=0;
		daySales=0;
	}

	@Override
	public void BillPrinting(List<Item> items,int total) {
		LocalDateTime date = LocalDateTime.now();
		
		System.out.println("*************************************************************");
		System.out.println("                      Waruna Textiles                      ");
		System.out.println("                        Colombo 06                      ");
		System.out.println(date.format(dateFormat));
		System.out.println("*************************************************************");
		//System.out.println("123456789012345678901234567890123456789012345678901234567890");
		System.out.printf("%5s %8s %14s %10s %15s \n", "Code ID", "Name", "Quantity", "Price", "Amount");
		for (Item item : items) {
			System.out.printf("%5s %11s %10s %12s %15s \n", item.getCode(), item.getName(),item.getQuantity() , item.getPrice(), billing(item.getPrice(),item.getQuantity()));
		}
		System.out.println("-------------------------------------------------------------");
		System.out.printf("Net Total %47s\n",total);
		System.out.println("*************************************************************");
		System.out.println("                 Thank you and Come again               ");
	}
	
	
	
//	public static void run2(Dress dr) {
//		Scanner scan = new Scanner(System.in);
//		// Customer object for getting and setting from an ArrayList
//		Customer customer = new Customer();
//
//		dr.printmenu();
//		int total = 0;
//		String whileCon = "yes";
//		do {
//
//			System.out.println("Select Dress! \n 1: Shirt \n 2: T-Shirt \n 3: Jeans");
//			int DressName = scan.nextInt();
//
//			if (DressName == 1) {
//				System.out.println("How many shirt/s do you want?");
//				int num = scan.nextInt();
//				countPerShirt = countPerShirt + num;
//				System.out.println("Current Bill: " + dr.Sales(num, dr.shirt) + "LKR");
//
//				customer.setItem("shirt");
//				customer.setqty(countPerShirt);
//				total += dr.Sales(num, dr.shirt);
//				stringlist.add(customer.getItem());
//				stringlist.add(customer.getqty());
//
//			} else if (DressName == 2) {
//				System.out.println("How many T-shirt/s do you want?");
//				int num = scan.nextInt();
//				countPerT_Shirt = countPerT_Shirt + num;
//
//				System.out.println("Current bill: " + dr.Sales(num, dr.t_shirt) + "LKR");
//
//				total += dr.Sales(num, dr.t_shirt);
//				customer.setItem("t-shirt");
//				customer.setqty(countPerT_Shirt);
//				stringlist.add(customer.getItem());
//				stringlist.add(customer.getqty());
//
//			} else if (DressName == 3) {
//				System.out.println("How many Jean/s do you want?");
//				int num = scan.nextInt();
//				countPer_pant = countPer_pant + num;
//				System.out.println("Current Bill: " + dr.Sales(num, dr.pant) + "LKR");
//
//				total += dr.Sales(num, dr.pant);
//				customer.setItem("pant's");
//				customer.setqty(countPer_pant);
//				stringlist.add(customer.getItem());
//				stringlist.add(customer.getqty());
//
//			} else
//				System.out.println("Unexpected error! Please try again");
//			customer.setprice(total);
//			stringlist.add(customer.getprice());
//
//			countPer_pant = 0;
//			countPerT_Shirt = 0;
//			countPerShirt = 0;
//			total = 0;
//
//			System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
//			whileCon = scan.next();
//
//		} while (whileCon.equals("yes"));
//
//		// printing the bill for Dress shop
//		System.out.println("*******************************************************");
//		System.out.println("                  Dress Shop Bill                                     ");
//		System.out.println("*******************************************************");
//
//		System.out.println("	Items 	QTY 	Price        ");
//		for (Object obj : stringlist) {
//
//			if (obj.getClass() == Integer.class) {
//				System.out.print(" " + obj + " \t");
//			}
//			if (obj.getClass() == String.class) {
//
//				System.out.print(" " + obj + " \t ");
//
//			}
//			if (obj.getClass() == Float.class) {
//
//				System.out.print(" " + obj + "\n ");
//				TotalPrice += (Float) obj;
//			}
//
//		}
//
//		System.out.println("--------------------------------------------------------");
//		System.out.println("   	Total : " + TotalPrice + " LKR");
//		System.out.println("**********************************************************");
//		System.out.println("        Thank you & come again. Have nice day..!             ");
//
//		stringlist.clear();
//		customer.setItem("Dress Shop");
//		customer.setprice(TotalPrice);
//		TotalInvoicelist.add(customer.getItem());
//		TotalInvoicelist.add(customer.getprice());
//		TotalPrice = 0;
//	}
}
