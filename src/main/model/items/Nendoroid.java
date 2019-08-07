package model.items;

import java.util.ArrayList;
import java.util.List;

public class Nendoroid extends Figure {
    String name;
    String num;
    int quantity;

    public static final Nendoroid ALBEDO = new Nendoroid("Albedo", "642", 6, 80.99);
    public static final Nendoroid HATSUNE = new Nendoroid("Hastune Miku", "381-a", 1, 59.99);
    public static final Nendoroid NYARUKO_MAID_VER = new Nendoroid("Nyaruko (Maid Ver.)", "331", 0, 55.99);

    public static final List<Nendoroid> NENDOROID_LIST = new ArrayList<Nendoroid>() {
        {
            add(Nendoroid.ALBEDO);
            add(Nendoroid.HATSUNE);
            add(Nendoroid.NYARUKO_MAID_VER);
        }
    };

    public Nendoroid(String name, String num, int quantity, double priceTag) {
        super(name, quantity, priceTag);
        this.num = num;
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

    @Override
    public int purchaseItem() {
        return quantity--;
    }

    @Override
    public int putItemOnHold() {
        return 0;
    }
}