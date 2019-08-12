package model.items;

import model.orders.ItemsSold;

import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Figure extends Item implements NamedItem, GeneralInformation {
    protected ItemsSold itemsSold;
    protected  String name;
    protected int quantity;
    private double priceTag;

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
            add(Nendoroid.SAITAMA);
        }
    };

    public Figure(String name) {
        this.name = name;
        itemsSold = new ItemsSold();
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
