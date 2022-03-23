package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import uber.Uber;
import kangaroo.Kangaroo;
import pickme.Pickme;

public class CustomerImpl {

	//Initializing Variables
	public static int countPerTuk = 0, countPerZip = 0, countPerPremier = 0;
	public static int countTuk = 0, countFlex = 0, countMini = 0;
	public static int countKtuk = 0, countCar = 0, countVan = 0;
	public static float TotalPrice = 0;
	public static float NoBooking = 0;
	public static float BookingCharge = 0;
	
	//Array List to store data of the choices made
	public static List<Object> stringlist = new ArrayList<Object>();
	public static List<Object> TotalInvoicelist = new ArrayList<Object>();

	// Method where customer selects the type of taxi provider
	public static int find() {
		Scanner sc = new Scanner(System.in);
		String whileCon = "yes";

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Select the type of Taxi! \n 1: Uber Taxi \n 2: Pickme Taxi \n 3: Kangaroo Taxi");
		System.out.println("");

		int details = sc.nextInt();

		if (details == 1) {
			return 1;
		} else if (details == 2) {
			return 2;
		} else if (details == 3) {
			return 3;
		}
		return 0;

	}

	// Method for Uber Taxi
	public static void run2(Uber uber) {
		Scanner scan = new Scanner(System.in);
		
		// Customer object for getting and setting from an ArrayList
		Customer customer = new Customer();

		uber.printmenu();
		int total = 0;
		String whileCon = "yes";
		do {

			System.out.println("You selected Uber Taxi! \n 1: Tuk \n 2: Zip \n 3: Premier");
			System.out.println("");

			int UberName = scan.nextInt();

			//Condition
			if (UberName == 1) {
				System.out.println("----------------------------------------");
				System.out.println("How many Uber Tuks do you want to book?");
				System.out.println("");

				int num = scan.nextInt();
				countPerTuk = countPerTuk + num;
				System.out.println("Current Bill: " + uber.Sales(num, uber.tuk) + "LKR");

				customer.setItem("tuk");
				customer.setqty(countPerTuk);
				total += uber.Sales(num, uber.tuk);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());

			} else if (UberName == 2) {
				System.out.println("---------------------------------------");
				System.out.println("How many Uber Zips do you want to book?");
				System.out.println("");

				int num = scan.nextInt();
				countPerZip = countPerZip + num;

				System.out.println("Current bill: " + uber.Sales(num, uber.zip) + "LKR");

				total += uber.Sales(num, uber.zip);
				customer.setItem("zip");
				customer.setqty(countPerZip);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());

			} else if (UberName == 3) {
				System.out.println("-------------------------------------------");
				System.out.println("How many Uber Premiers do you want to book?");
				System.out.println("");

				int num = scan.nextInt();
				countPerPremier = countPerPremier + num;
				System.out.println("Current Bill: " + uber.Sales(num, uber.premier) + "LKR");

				total += uber.Sales(num, uber.premier);
				customer.setItem("premier");
				customer.setqty(countPerPremier);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());

			} else
				System.out.println("Unexpected error! Please try again");
			customer.setprice(total);
			stringlist.add(customer.getprice());

			countPerPremier = 0;
			countPerZip = 0;
			countPerTuk = 0;
			total = 0;

			System.out.println("-----------------------------------------------------");
			System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
			System.out.println("");

			whileCon = scan.next();

		} while (whileCon.equals("yes"));

		//Printing the checkout for Uber Taxi
		System.out.println("*********************************************************");
		System.out.println("                  UBER TAXI CHECKOUT                                     ");
		System.out.println("*********************************************************");
		System.out.println("	Items 	QTY 	Price        ");

		for (Object obj : stringlist) {

			if (obj.getClass() == Integer.class) {
				System.out.print("  " + obj + " \t");
			}
			if (obj.getClass() == String.class) {

				System.out.print("  " + obj + " \t ");

			}
			if (obj.getClass() == Float.class) {

				System.out.print("  " + obj + "\n ");
				TotalPrice += (Float) obj;
			}

		}

		System.out.println("----------------------------------------------------------");
		System.out.println("   	Total : " + TotalPrice + " LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		System.out.println("**********************************************************");
		System.out.println("");

		stringlist.clear();
		customer.setItem("Uber");
		customer.setprice(TotalPrice);
		TotalInvoicelist.add(customer.getItem());
		TotalInvoicelist.add(customer.getprice());
		TotalPrice = 0;
	}         

	// Method for Pickme shop
	public static void run(Pickme pickme) {
		
		Scanner scan = new Scanner(System.in);
		
		// Customer object for getting and setting from an ArrayList
		Customer customer = new Customer();

		pickme.printMenu();
		String whileCon = "yes";
		int total = 0;
		do {
			System.out.println("You selected Pickme Taxi! \n 1: Tuk \n 2: Flex \n 3: Mini");
			System.out.println("");

			int ToyName = scan.nextInt();

			//Condition
			if (ToyName == 1) {
				System.out.println("-----------------------------------------");
				System.out.println("How many Pickme Tuks do you want to book?");
				System.out.println("");
				
				int num = scan.nextInt();
				countTuk += num;
				System.out.println("Current Bill: " + pickme.buy(num, pickme.Tuk) + "LKR");
				total += pickme.buy(num, pickme.Tuk);

				customer.setItem("Tuk");
				customer.setqty(countTuk);

				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			} else if (ToyName == 2) {
				System.out.println("------------------------------------------");
				System.out.println("How many Pickme Flexs do you want to book?");
				System.out.println("");

				int num = scan.nextInt();
				countFlex += num;
				System.out.println("Current Bill: " + pickme.buy(num, pickme.Flex) + "LKR");
				total += pickme.buy(num, pickme.Flex);

				customer.setItem("Flex");
				customer.setqty(countFlex);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			} else if (ToyName == 3) {
				System.out.println("------------------------------------------");
				System.out.println("How many Pickme Minis do you want to book?");
				System.out.println("");

				int num = scan.nextInt();
				countMini += num;
				System.out.println("Current Bill: " + pickme.buy(num, pickme.Mini) + "LKR");
				total += pickme.buy(num, pickme.Mini);

				customer.setItem("Mini");
				customer.setqty(countMini);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			} else
				System.out.println("Unexpected error! Please try again");

			customer.setprice(total);
			stringlist.add(customer.getprice());

			countMini = 0;
			countFlex = 0;
			countTuk = 0;
			total = 0;

			System.out.println("-----------------------------------------------------");
			System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
			System.out.println("");

			whileCon = scan.next();

		} while (whileCon.equals("yes"));

		
		//Printing the checkout for Pickme Taxi
		System.out.println("*********************************************************");
		System.out.println("                 PICKME TAXI CHECKOUT                                        ");
		System.out.println("*********************************************************");
		System.out.println("	Items 	QTY 	Price        ");

		for (Object obj : stringlist) {
			if (obj.getClass() == Integer.class) {
				System.out.print(" " + obj + " \t");
			}
			if (obj.getClass() == String.class) {

				System.out.print(" " + obj + " \t ");

			}
			if (obj.getClass() == Float.class) {

				System.out.print(" " + obj + "\n ");
				TotalPrice += (Float) obj;
			}

		}

		System.out.println("----------------------------------------------------------");
		System.out.println("   	Total : " + TotalPrice + " LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		System.out.println("**********************************************************");
		System.out.println("");

		stringlist.clear();

		customer.setItem("Pickme");
		customer.setprice(TotalPrice);
		TotalInvoicelist.add(customer.getItem());
		TotalInvoicelist.add(customer.getprice());
		TotalPrice = 0;

	}

	// Method for Kangaroo Taxi
	public static void run3(Kangaroo kangaroo) {
		Scanner scan = new Scanner(System.in);
		
		// Customer object for getting and setting from an ArrayList
		Customer customer = new Customer();
		kangaroo.printMenu();
		String whileCon = "yes";
		int total = 0;

		do {
			System.out.println("You selected Kangaroo Taxi! \n 1: Tuk \n 2: Car \n 3: Van");
			System.out.println("");
			int ToyName = scan.nextInt();

			//Condition
			if (ToyName == 1) {
				System.out.println("-----------------------------------");
				System.out.println("How many Kangaroo Tuks do you want?");
				System.out.println("");

				int num = scan.nextInt();
				countKtuk += num;
				System.out.println("Current Bill: " + kangaroo.buy(num, kangaroo.tuk) + "LKR");
				total += kangaroo.buy(num, kangaroo.tuk);

				customer.setItem("tuk");
				customer.setqty(countKtuk);

				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			} else if (ToyName == 2) {
				System.out.println("-----------------------------------");
				System.out.println("How many Kangaroo Cars do you want?");
				System.out.println("");

				int num = scan.nextInt();
				countVan += num;
				System.out.println("Current Bill: " + kangaroo.buy(num, kangaroo.car) + "LKR");
				total += kangaroo.buy(num, kangaroo.car);

				customer.setItem("car");
				customer.setqty(countVan);

				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			} else if (ToyName == 3) {
				System.out.println("-----------------------------------");
				System.out.println("How many Kangaroo Vans do you want?");
				System.out.println("");

				int num = scan.nextInt();
				countCar += num;
				System.out.println("Current Bill: " + kangaroo.buy(num, kangaroo.van) + "LKR");
				total += kangaroo.buy(num, kangaroo.van);

				customer.setItem("van");
				customer.setqty(countCar);

				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			} else
				System.out.println("Unexpected error! Please try again");

			customer.setprice(total);
			stringlist.add(customer.getprice());

			countVan = 0;
			countCar = 0;
			countKtuk = 0;
			total = 0;

			System.out.println("-----------------------------------------------------");
			System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
			System.out.println("");

			whileCon = scan.next();

		} while (whileCon.equals("yes"));

		
		//Printing the checkout for Kangaroo Taxi
		System.out.println("*********************************************************");
		System.out.println("                 KANGAROO TAXI CHECKOUT                                       ");
		System.out.println("*********************************************************");
		System.out.println("	Items 	QTY 	Price        ");
		
		for (Object obj : stringlist) {
			if (obj.getClass() == Integer.class) {
				System.out.print(" " + obj + " \t");
			}
			if (obj.getClass() == String.class) {

				System.out.print(" " + obj + " \t ");

			}
			if (obj.getClass() == Float.class) {

				System.out.print(" " + obj + "\n ");
				TotalPrice += (Float) obj;
			}

		}

		System.out.println("----------------------------------------------------------");
		System.out.println("   	Total : " + TotalPrice + " LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		System.out.println("**********************************************************");

		stringlist.clear();

		customer.setItem("Kangaroo");
		customer.setprice(TotalPrice);
		TotalInvoicelist.add(customer.getItem());
		TotalInvoicelist.add(customer.getprice());
		TotalPrice = 0;
	}

	
	//Printing the total checkout
	public static void PrintTotalInvoice() {
		System.out.println("*********************************************************");
		System.out.println("                 TOTAL CHECKOUT                                       ");
		System.out.println("*********************************************************");
		System.out.println("	Items 	Price        ");
		
		for (Object obj : TotalInvoicelist) {
			if (obj.getClass() == Integer.class) {
				System.out.print(" " + obj + " \t");
			}
			if (obj.getClass() == String.class) {

				System.out.print(" " + obj + " \t ");

			}
			if (obj.getClass() == Float.class) {

				System.out.print(" " + obj + "\n ");
				TotalPrice += (Float) obj;
			}
		}
		if (NoBooking != 0) {
			System.out.println(" Distance " + BookingCharge + "   " + NoBooking + "km");
		}

		System.out.println("---------------------------------------------------------");
		System.out.println("   	Total : " + (TotalPrice + BookingCharge) + " LKR");
		System.out.println("*********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		System.out.println("*********************************************************");
		System.out.println("");
		
		TotalInvoicelist.clear();
		TotalPrice = 0;
	}
}