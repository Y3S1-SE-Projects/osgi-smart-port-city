package waruna_textile_producer;

import java.util.List;

public interface DressInterface {
	

    public int billing(int unitPrice,int qty);
    
    public void DaySummary(List<Item> items);
    
    public void BillPrinting(List<Item> items,int total);


}
