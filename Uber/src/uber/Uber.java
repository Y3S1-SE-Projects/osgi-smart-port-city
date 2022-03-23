package uber;

public interface Uber {

	//Interface for displaying static taxi prices
    public int tuk = 1000;
    public int zip = 1200;
    public int premier = 2000;

    public int Sales(int qty, int prices);

    public void printmenu();

}