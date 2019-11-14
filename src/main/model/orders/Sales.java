package model.orders;

import model.items.Book;
import model.items.Manga;

import java.util.ArrayList;
import java.util.List;

public class Sales {
    private ItemsSold itemsSold;
    private double sales;
    public int salesGoal;
    private List<SalesObserver> observers = new ArrayList<>();

    public Sales() {
        this.sales = 0.0;
        this.salesGoal = 200;
        itemsSold = new ItemsSold();
    }

    // EFFECTS: returns the current sales amount
    public double getSales() {
        return sales;
    }

    // MODIFIES: this
    // EFFECTS: returns the rounded sales amount
    public int getRoundedSales() {
        return (int) Math.round(sales);
    }

    // MODIFIES: this
    // EFFECTS: adds the price of the figure sold to the sales amount
    private double addToSales(double itemPrice) {
        return sales += itemPrice;
    }

    // REQUIRES: a string that will be able to be converted into an integer
    // MODIFIES: this
    // EFFECTS: sets a new sales goal
    public int setSalesGoals(String newSalesGoal) {
        return salesGoal = Integer.parseInt(newSalesGoal);
    }


    public String printSales() {
        return "We made $" + Double.toString(sales) + " so far.";
    }

    public String salesGoalMet() {
        if (sales >= salesGoal) {
            return "Revenue goal met! We have surpassed $" + Integer.toString(salesGoal) + ","
                    + " and we are now at $" + Double.toString(getSales()) + "!";
        }
        return "Revenue goal is not met. We are currently at $" + Double.toString(getSales()) + ","
                + " and our goal is $" + Integer.toString(salesGoal) + "."
                + " Only $" + (Integer.toString((salesGoal - getRoundedSales())) + " to go!");
    }

//    public double increaseSales(Item item) {
//        if (item instanceof Figure) {
//            return getItemsSold() + ((Figure) item).getPriceTag();
//        }
//        if (item instanceof Book) {
//            return getItemsSold() + ((Book) item).getPriceTag();
//        }
//        return getItemsSold();
//    }

    public void addObserver(SalesObserver salesObserver) {
        if (!observers.contains(salesObserver)) {
            observers.add(salesObserver);
        }
    }

    // EFFECTS: returns the size of the observers list
    public int sizeOfObserverList() {
        return observers.size();
    }

    public void notifyObservers(Sales sales) {
        for (SalesObserver observer : observers) {
            observer.update(sales);
        }
    }

    public static void main(String[] args) {
        Sales sales = new Sales();
        ItemsSold is = new ItemsSold();
        System.out.println(sales.setSalesGoals("250"));
        Book promised3 = Manga.PROMISED_MN3;
        promised3.purchaseItem();
        System.out.println("Quantity: " + promised3.getQuantity());
        System.out.println("Price: $" + promised3.getPriceTag());
        System.out.println("add to sales -> " + sales.addToSales(promised3.getPriceTag()));
        is.sellItem();
        System.out.println(is.getItemsSold());
//        System.out.println(sales.getItemsSoldMessage());
        System.out.println(sales.salesGoalMet());

        sales.addObserver(Staff.ELLY);
        sales.addObserver(Staff.JON);
        sales.addObserver(Staff.CARRIE);

        sales.notifyObservers(sales);
    }
}
