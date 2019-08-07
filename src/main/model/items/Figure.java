package model.items;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Figure extends Item implements NamedItem, GeneralInformation {
//    public HashMap<String, List<Figure>> stringSetHashMap = new HashMap<>();
    protected  String name;
    protected int quantity;
    protected double priceTag;
    protected static ArrayList<Exq> exqArrayList;
    protected int itemsSold;
    protected double sales;

    public static final ArrayList<Figure> FIGURE_LIST = new ArrayList<Figure>() {
        {
//            FIGURE_LIST.addAll(exqArrayList);
//            FIGURE_LIST.addAll(Nendoroid.NENDOROID_LIST);
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

    public Figure(String name, int quantity, double priceTag) {
        this.name = name;
        this.quantity = quantity;
        this.priceTag = priceTag;
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
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPriceTag() {
        return priceTag;
    }

    @Override
    public String getInformation() {
        return name + ", Quantity: " + quantity + ", $" + priceTag;
    }

    @Override
    public boolean containsNameOrTitle(String givenNameOrTitle) {
        return getName().toLowerCase().contains(givenNameOrTitle.toLowerCase());
    }

    public int purchaseItem() {
        itemsSold++;
        this.sales = sales + getPriceTag();
        //Sales.notifyObservers();
        return quantity--;
    }

    @Override
    public int putItemOnHold() {
        return quantity--;
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
