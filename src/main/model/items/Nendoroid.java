package model.items;

import java.util.ArrayList;
import java.util.List;

public class Nendoroid extends Figure {
    private String num;
    protected int quantity;
    private double priceTag;

    public static final Nendoroid ALBEDO = new Nendoroid("Albedo", "642",
            6, 80.99);
    public static final Nendoroid HATSUNE = new Nendoroid("Hastune Miku", "381-a",
            1, 59.99);
    public static final Nendoroid NYARUKO_MAID_VER = new Nendoroid("Nyaruko (Maid Ver.)",
            "331", 0, 55.99);
    public static final Nendoroid SAITAMA = new Nendoroid("Saitama", "575",
            0, 29.99);

    public static final List<Nendoroid> NENDOROID_LIST = new ArrayList<Nendoroid>() {
        {
            add(Nendoroid.ALBEDO);
            add(Nendoroid.HATSUNE);
            add(Nendoroid.NYARUKO_MAID_VER);
            add(Nendoroid.SAITAMA);
        }
    };

    public Nendoroid(String name, String num, int quantity, double priceTag) {
        super(name);
        this.num = num;
        this.quantity = quantity;
        this.priceTag = priceTag;
    }


    public String getNum() {
        return "#" + num;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPriceTag() {
        return priceTag;
    }

    @Override
    public double setPriceTag(double newPriceTag) {
        return priceTag = newPriceTag;
    }

    @Override
    public String getInformation() {
        return name + ", " + getNum() + ", Quantity: " + quantity + ", $" + priceTag;
    }

    @Override
    public boolean containsNameOrTitle(String givenNameOrTitle) {
        return getName().toLowerCase().contains(givenNameOrTitle.toLowerCase());
    }

    // MODIFIES: This
    // EFFECTS: purchases an item by decreasing its quantity by one.
    //          Also increases the amount of items sold by one.
    //          If the quantity is zero, then the item will be unavailable
    //          for purchase but available for putting on hold.
//    @Override
    public String purchaseItem() {
        if (quantity != 0) {
            itemsSold.sellItem();
            int newQuantity = quantity -= 1;
            return Integer.toString(newQuantity);
        }
        putItemOnHold();
        return "This item is currently unavailable. However, it can be put on hold.";
    }

    // MOFIDIES: this
    // EFFECTS: puts an item on hold by decreasing the quantity by one.
    //          When the quantity becomes a negative integer, that indicates
    //          how much the store should order in.
//    @Override
    public String putItemOnHold() {
        int newQuantity = quantity -= 1;
        return Integer.toString(newQuantity);
    }

}