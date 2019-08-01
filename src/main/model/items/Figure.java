package model.items;

import java.util.Objects;

public abstract class Figure extends Item implements NamedItems, GeneralInformation {
    protected  String name;

    protected int quantity;

    protected double priceTag;

    public Figure(String name, int quantity, double priceTag) {
        this.name = name;
        this.quantity = quantity;
        this.priceTag = priceTag;
    }

    @Override
    public String getName() {
        return name;
    }

    public String setName(String newName) {
        return name = newName;
    }

    public String getInformation() {
        return name + ", Quantity: " + quantity + ", $" + priceTag;
    }

    public boolean containsNameOrTitle(String givenNameOrTitle) {
        return getName().toLowerCase().contains(givenNameOrTitle.toLowerCase());
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
