package kangaroo;

public interface Kangaroo {

	//Interface for displaying static taxi prices
	public int tuk = 100;
	public int car = 700;
	public int van = 900;

	public int buy(int qty, int prices);

	public void printMenu();

}
