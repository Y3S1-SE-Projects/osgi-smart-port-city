package foodproducer;
import foodproducer.IFoodProducer;

import java.util.Scanner;

public class FoodProducer implements IFoodProducer{
	IFoodProducer ms;

//	@Override
	public int buy(int qty, int prices) {
		return qty * prices;
	}
//method
	public void printintro() {
		//declaring variables
		int choice, qty = 0;
		float agb= 400,alb=300;
		float mp=800,mb=500 ;
		float di=800,dw=500 ;
		float sum = 0;
		float total=0, count=0;
		char ans;
		//output
		do {
		System.out.println("*************************************");
		System.out.println("Welcome to Smart Port City Food Store");
		System.out.println("*************************************");
		Scanner dc= new Scanner(System.in);
		System.out.println("Which food Category would you like to have?");
		System.out.println(" 1. Appetizers");
		System.out.println(" 2. Meal");
		System.out.println(" 3. Dessert");
		choice=dc.nextInt();
		dc.nextLine();
		int number = 0;
		if(choice==1) {
			System.out.println(" What would you like to order?");
			System.out.println(" 1. Garlic Bread with Cheese  LKR 400");
			System.out.println(" 2. Egg and Cream Soup LKR 300");
			number=dc.nextInt();
			dc.nextLine();
			
				if(number==1) {
					System.out.println(" Enter qty:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(agb*qty);
						System.out.println("Current total: LKR"+sum);
						
				} else if(number==2) {
					System.out.println(" Enter qty:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(alb*qty);
						System.out.println("Current total: LKR"+sum);
				}
		} else if(choice==2) {
			
			System.out.println(" What would you like to order?");
			System.out.println(" 1. Pizza  LKR 800");
			System.out.println(" 2. Biriyani LKR 500");
			number=dc.nextInt();
			dc.nextLine();
			
				if(number==1) {
					System.out.println(" Enter qty:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(mp*qty);
						System.out.println("Current total: LKR"+sum);
				} else if(number==2) {
					System.out.println(" Enter qty:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(mb*qty);
						System.out.println("Current total: LKR"+sum);
				}
		} else if(choice==3) {
			
			System.out.println(" What would you like to order?");
			System.out.println(" 1. Ice cream  LKR 100");
			System.out.println(" 2. Watalappan LKR 80");
			number=dc.nextInt();
			dc.nextLine();
			
				if(number==1) {
					System.out.println(" Enter qty:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(di*qty);
						System.out.println("Current total: LKR"+sum);
				} else if(number==2) {
					System.out.println(" Enter quantity:");
					 qty=dc.nextInt();
					 dc.nextLine();
					 sum=sum+(dw*qty); 
						System.out.println("Current total: LKR"+sum);}
		
		
		
		
	}
		System.out.println(" Do you want to enjoy more food(y/n)?");
		ans=dc.next().charAt(0);
		total=total+sum;
		count=count+1;
		
		} while(ans=='y');
		System.out.println("*************************************");
		System.out.println(" Number of Orders:"+ count);
		
		System.out.println(" Total bill is: LKR"+ total);
		System.out.println("*************************************");
		
		return;
	}
	}
