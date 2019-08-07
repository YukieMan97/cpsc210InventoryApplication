package model.orders;

public class ItemsSold {
    private int itemsSold;

    public ItemsSold() {
        this.itemsSold = 0;
    }

    public int getSales() {
        return itemsSold;
    }

    public String printSales() {
        return "We have sold " + Integer.toString(itemsSold) + " items so far.";
    }

}
