package waruna_textile_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import waruna_textile_producer.*;


public class DressShop {

	public static void main(String[] args) {
		
		Scanner input =new Scanner(System.in);
		List<Item> dayitems = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		int bill = 0 , total = 0 , subtotal = 0;
		
		System.out.println("******  Welcome to dress shop  ******");
		System.out.println("Select the number\n"+"1) Start Billing\n"+"2) Day Summary\n"+"3) View the last bill\n"+"4) End the program");
		System.out.print("\nEnter the selection: ");
		int in = Integer.parseInt(input.nextLine());
		
		while(in!=4) {
			
			if(in==1) {
				if(!items.isEmpty()) {
					items.clear();
					System.out.print("Last Bill cleared");
				}
				
				while(bill!=-1) {
					System.out.print("Enter the item code: ");
					String itcode = input.nextLine();
					
					System.out.print("Enter the item name: ");
					String itname = input.nextLine();
					
					System.out.print("Enter the item price: ");
					int itprice = Integer.parseInt(input.nextLine());
					
					System.out.print("Enter the item quantity: ");
					int itqty = Integer.parseInt(input.nextLine());
					
					Item item = new Item(itcode,itname,itprice,itqty);
					
					subtotal = item.getPrice()*item.getQuantity();
					total+=subtotal;
					
					items.add(item);
					dayitems.add(item);
					
					System.out.println("Subtotal :"+subtotal);
					
					System.out.println("Press any key to continue or end the billing process press -1: ");
					bill = Integer.parseInt(input.nextLine());
					
					
				}
				System.out.println("*************************************************************");
				System.out.println("                      Dress Shop Bill                      ");
				System.out.println("*************************************************************");
				System.out.println("123456789012345678901234567890123456789012345678901234567890");
				System.out.printf("%5s %8s %14s %10s %15s \n", "Code ID", "Name", "Quantity", "Price", "Amount");
				for (Item item : items) {
					System.out.printf("%5s %11s %10s %12s %15s \n", item.getCode(), item.getName(),item.getQuantity() , item.getPrice(), item.getQuantity()*item.getPrice());
				}
				System.out.println("*************************************************************");
				System.out.println("-------------------------------------------------------------");
				System.out.println("*************************************************************");
				//BillPrinting(items);
			}
			else if(in==2) {
				//DaySummary(dayitems);
			}
			else if(in==3) {
				if(!items.isEmpty()) {
					//BillPrinting(items);
					System.out.print("\n\nLast Bill printed\n");
				}else {
					System.out.print("\nThis is your first bill !!! \n\n");
				}
			}
			
			else {
				System.out.println("\nInvalid Selection Please select again\n");
			}
			System.out.println("Select the number:\n"+"1) Start Billing\n"+"2) Day Summary\n"+"3) View the last bill\n"+"4) End the program");
			System.out.print("\nEnter the selection: ");
			in= input.nextInt();
			
		}
			System.out.println("\nProgram Ended");
		
		
		

	}

}
