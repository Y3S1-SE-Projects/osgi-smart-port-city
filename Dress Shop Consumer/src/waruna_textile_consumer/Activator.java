package waruna_textile_consumer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import waruna_textile_producer.DressInterface;
import waruna_textile_producer.DressInterfaceImpl;
import waruna_textile_producer.Item;

public class Activator implements BundleActivator {

	ServiceRegistration publicServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Dress shop Opening");

		DressInterface dressService = new DressInterfaceImpl();
		publicServiceRegistration = bundleContext.registerService(DressInterface.class.getName(), dressService, null);
		
		System.out.println("Dress shop consumer service is open");
		
		/******************************************/
		
		Scanner input =new Scanner(System.in);
		List<Item> dayitems = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		int bill = 0 , total = 0 , subtotal = 0, in = 0;
		
		System.out.println("******  Welcome to dress shop  ******");
		
		do {
			System.out.println("Select the number:\n"+"1) Start Billing\n"+"2) Day Summary\n"+"3) View the last bill\n"+"4) End the program");
			System.out.print("\nEnter the selection: ");
			in = Integer.parseInt(input.nextLine());
			
			if(in==1) {
				if(!items.isEmpty()) {
					items.clear();
					total=0;
					bill=0;
					//System.out.print("Last Bill cleared\n");
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
					
					subtotal = dressService.billing(item.getPrice(),item.getQuantity());
					total+=subtotal;
					
					items.add(item);
					dayitems.add(item);
					
					System.out.println("\nSubtotal :"+subtotal);
					System.out.println("Total :"+total+"\n");
					
					System.out.print("Press any key to continue or end the billing process press -1: ");
					bill = Integer.parseInt(input.nextLine());
					
					
				}
				dressService.BillPrinting(items,total);
			}
			else if(in==2) {
				dressService.DaySummary(dayitems);
			}
			else if(in==3) {
				if(!items.isEmpty()) {
					System.out.print("\nLast Bill printed\n\n");
					dressService.BillPrinting(items,total);
				}else {
					System.out.print("\n Bill memory is empty !!! \n\n");
				}
			}
			
			else {
				System.out.println("\nInvalid Selection Please select again\n");
			}
			
		}while(in!=4);
		System.out.println("\nProgram Ended");
		
		
		/******************************************/
		input.close();
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Dress shop consumer service is stopped");
		publicServiceRegistration.unregister();
	}

}
