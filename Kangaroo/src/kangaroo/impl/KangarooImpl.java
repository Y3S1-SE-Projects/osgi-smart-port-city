package kangaroo.impl;

import kangaroo.Kangaroo;

public class KangarooImpl implements Kangaroo {

	Kangaroo kangaroo;

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
		System.out.println("Tuk =" + kangaroo.tuk + "LKR");
		System.out.println("Car =" + kangaroo.car + "LKR");
		System.out.println("Van =" + kangaroo.van + "LKR");
		System.out.println("****************************************");
	}
}
