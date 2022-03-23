package uber.impl;

import uber.Uber;

public class UberImpl implements Uber {

	//Method calculation for taxi quantity and price
	@Override
	public int Sales(int qty, int prices) {
		return qty * prices;
	}

	//Displaying taxi prices
	public void printmenu() {
		System.out.println("****************************************");
		System.out.println("Taxi Prices");
		System.out.println("");
		System.out.println("Tuk " + Uber.tuk + " LKR");
		System.out.println("Zip " + Uber.zip + " LKR");
		System.out.println("Premier " + Uber.premier + " LKR");
		System.out.println("****************************************");
	}
}
