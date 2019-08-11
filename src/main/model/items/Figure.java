package model.items;

import model.orders.ItemsSold;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Figure extends Item implements NamedItem, GeneralInformation {
    protected  String name;
    protected int quantity;
    private double priceTag;
    private static ArrayList<Exq> exqArrayList;
    protected ItemsSold itemsSold;
    protected double sales;

    public static final ArrayList<Figure> FIGURE_LIST = new ArrayList<Figure>() {
        {
            add(Exq.ASUNA_WEDDING);
            add(Exq.REM_WEDDING);
            add(Exq.KIRITO_DUAL_WIELD);
            add(Exq.ALICE_SITTING);
            add(Exq.LEAFA_FAIRY);
            add(Nendoroid.ALBEDO);
            add(Nendoroid.HATSUNE);
            add(Nendoroid.NYARUKO_MAID_VER);
        }
    };

    public Figure(String name) {
        this.name = name;
        exqArrayList = Exq.EXQ_LIST;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String setName(String newName) {
        return name = newName;
    }

    @Override
    public String getInformation() {
        return getName() + ", Quantity: " + getQuantity() + ", $" + getPriceTag();
    }

    // REQUIRES: an actual word to properly find a figure with a matching title.
    // MODIFIES: this
    // EFFECTS: returns true when the givenName is contained in a figure name by making it
    //          lower cased first. Otherwise, return false.
    @Override
    public boolean containsNameOrTitle(String givenName) {
        return getName().toLowerCase().contains(givenName.toLowerCase());
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Figure)) {
            return false;
        }
        Figure figure = (Figure) o;
        return Double.compare(figure.priceTag, priceTag) == 0
                && Objects.equals(name, figure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priceTag);
    }
}
