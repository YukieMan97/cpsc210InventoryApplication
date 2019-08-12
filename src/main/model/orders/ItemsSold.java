package model.orders;

public class ItemsSold {
    private int itemsSold;

    public ItemsSold() {
        itemsSold = 0;
    }

    // EFFECT: returns the amount of items sold plus one
    public int sellItem() {
        return itemsSold += 1;
    }

    // EFFECTS: returns the amount of items sold
    public int getItemsSold() {
        return itemsSold;
    }

    public String getItemsSoldMessage() {
        return "We have sold " + Integer.toString(itemsSold)
                + " item(s) so far.";
    }

}
