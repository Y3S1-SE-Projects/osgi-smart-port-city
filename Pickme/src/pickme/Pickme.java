package pickme;

public interface Pickme {

	public int buy(int qty, int prices);

	public void printMenu();

	//Interface for displaying static taxi prices
	public int Tuk = 50;
	public int Flex = 600;
	public int Mini = 200;
}
