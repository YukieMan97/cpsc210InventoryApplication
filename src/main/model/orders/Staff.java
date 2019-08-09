package model.orders;

import model.items.*;

public class Staff extends Person implements SalesObserver {
    String name;
    String position;
    String phoneNumber;
    Item item;

    public static final Staff TANYA = new Staff("Tanya", "Supervisor",
            "778-906-8877", Exq.REM_WEDDING);
    public static final Staff ELLY = new Staff("Elly", "Manager",
            "604-657-9844", Exq.ASUNA_WEDDING);
    public static final Staff JON = new Staff("Jon", "Manager",
            "778-574-2345", null);
    public static final Staff CARRIE = new Staff("Carrie", "Sales Associate",
            "778-456-4736", Manga.PROMISED_MN2);

    public Staff(String name, String position, String phoneNumber, Item item) {
        super(name, phoneNumber);
        this.position = position;
        this.item = item;
    }

    public void display(String indentLevel) {
        System.out.println(indentLevel + getName() + ", Position: "
                + position + ", " + getPhoneNumber());
    }

    public void getItem() {
        if (item != null && (item instanceof Figure)) {
            System.out.println(getName() + " would like to order "
                    + ((Figure) item).getName() + "!");
        } else if (item != null && (item instanceof Book)) {
            System.out.println(getName() + " would like to order "
                    + ((Book) item).getTitle() + " "
                    + ((Book) item).getVolumeOrChapter() + "!");
        }
        System.out.println(getName() + " does not want to order anything.");
    }


    @Override
    public void update(Sales sales) {
        System.out.println("We are currently at $" + Double.toString(sales.getSales()) + ","
                + " and our goal is $" + Integer.toString(sales.salesGoal) + ".");
    }
}
