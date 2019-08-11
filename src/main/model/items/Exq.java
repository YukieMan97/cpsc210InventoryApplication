package model.items;

import model.orders.ItemsSold;

import java.util.ArrayList;

public class Exq extends Figure {
    protected ItemsSold itemsSold;
    protected int quantity;
    private double priceTag;

    public static final Exq ASUNA_WEDDING = new Exq("Code Register Wedding Asuna", 2, 29.99);
    public static final Exq REM_WEDDING = new Exq("Starting Life in Another World Rem", 0, 39.99);
    public static final Exq KIRITO_DUAL_WIELD = new Exq("Sword Art Online Kirito", 2, 25.99);
    public static final Exq ALICE_SITTING = new Exq("Alicization Alice Schuberg", 4, 28.99);
    public static final Exq LEAFA_FAIRY = new Exq("Memory Defrag Leafa", 1, 29.99);

    public static final ArrayList<Exq> EXQ_LIST = new ArrayList<Exq>() {
        {
            add(Exq.ASUNA_WEDDING);
            add(Exq.REM_WEDDING);
            add(Exq.KIRITO_DUAL_WIELD);
            add(Exq.ALICE_SITTING);
            add(Exq.LEAFA_FAIRY);
        }
    };

    private Exq(String name, int quantity, double priceTag) {
        super(name);
        this.quantity = quantity;
        this.priceTag = priceTag;
        itemsSold = new ItemsSold();
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPriceTag() {
        return priceTag;
    }

    // MODIFIES: This
    // EFFECTS: purchases an item by decreasing its quantity by one.
    //          Also increases the amount of items sold by one.
    //          If the quantity is zero, then the item will be unavailable
    //          for purchase but available for putting on hold.
    @Override
    public String purchaseItem() {
        if (quantity != 0) {
            itemsSold.sellItem();
            int newQuantity = quantity--;
            return Integer.toString(newQuantity);
        }
        return "This item is currently unavailable. However, it can be put on hold.";
    }

    // MOFIDIES: this
    // EFFECTS: puts an item on hold by decreasing the quantity by one.
    //          When the quantity becomes a negative integer, that indicates
    //          how much the store should order in.
    @Override
    public String putItemOnHold() {
        int newQuantity = quantity--;
        return Integer.toString(newQuantity);
    }
}
