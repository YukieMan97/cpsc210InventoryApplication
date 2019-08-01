package model.items;

public class Nendoroid extends Item.Figure {
    String name;
    String num;
    int quantity;

    public static final Nendoroid ALBEDO = new Nendoroid("Albedo", "642", 6, 80.99);
    public static final Nendoroid HATSUNE = new Nendoroid("Hastune Miku", "381-a", 1, 59.99);
    public static final Nendoroid NYARUKO_MAID_VER = new Nendoroid("Nyaruko (Maid Ver.)", "331", 0, 55.99);



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
    public String getInformation() {
        return name + ", #" + num + ", Quantity: " + quantity + ", $" + priceTag;
    }

    @Override
    public boolean containsNameOrTitle(String givenNameOrTitle) {
        return getName().toLowerCase().contains(givenNameOrTitle.toLowerCase());
    }
}