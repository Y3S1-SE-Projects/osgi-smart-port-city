package pickme.impl;

import pickme.Pickme;

public class PickmeImpl implements Pickme {

	Pickme pickme;

	//Method calculation for taxi quantity and price
	@Override
	public int buy(int qty, int prices) {
		return qty * prices;
	}

	//Displaying taxi prices
	@Override
	public void printMenu() {
		System.out.println("****************************************");
		System.out.println("Taxi Prices");
		System.out.println("");
		System.out.println("Tuk " + pickme.Tuk + "LKR");
		System.out.println("Flex" + pickme.Flex + "LKR");
		System.out.println("Mini " + pickme.Mini + "LKR");
		System.out.println("****************************************");
	}
}