package model.orders;

public class ItemsSold {
    private int itemsSold;

    public ItemsSold() {
        this.itemsSold = 0;
    }

    public int sellItem() {
        return itemsSold++;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public String getItemsSoldMessage() {
        return "We have sold " + Integer.toString(itemsSold)
                + " item(s) so far.";
    }

}
