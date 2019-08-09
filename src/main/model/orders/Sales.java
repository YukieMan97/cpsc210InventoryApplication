package model.orders;

import model.items.Book;
import model.items.Figure;
import model.items.Item;
import model.items.Manga;

import java.util.ArrayList;
import java.util.List;

public class Sales {
    private double sales;
    public int salesGoal;
    private List<SalesObserver> observers = new ArrayList<>();

    public Sales() {
        this.sales = 0.0;
        this.salesGoal = 200;
    }

    public double getSales() {
        return sales;
    }

    public int getRoundedSales() {
        return (int) Math.round(sales);
    }

    public int setSalesGoals(String newSalesGoal) {
        return salesGoal = Integer.parseInt(newSalesGoal);
    }

    public String printSales() {
        return "We made $" + Double.toString(sales) + " so far";
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

    public double increaseSales(Item item) {
        if (item instanceof Figure) {
            return getSales() + ((Figure) item).getPriceTag();
        }
        if (item instanceof Book) {
            return getSales() + ((Book) item).getPriceTag();
        }
        return getSales();
    }

    public void addObserver(SalesObserver salesObserver) {
        if (!observers.contains(salesObserver)) {
            observers.add(salesObserver);
        }
    }

    public void notifyObservers(Sales sales) {
        for (SalesObserver observer : observers) {
            observer.update(sales);
        }
    }

    public static void main(String[] args) {
        Sales sales = new Sales();
        System.out.println(sales.setSalesGoals("250"));
        Book promised3 = Manga.PROMISED_MN3;
        promised3.purchaseItem();
        System.out.println(promised3.getPriceTag());
        sales.increaseSales(promised3);
        System.out.println(sales.getSales());
        System.out.println(sales.printSales());
        System.out.println(sales.salesGoalMet());

        sales.addObserver(Staff.ELLY);
        sales.addObserver(Staff.JON);
        sales.addObserver(Staff.CARRIE);

        sales.notifyObservers(sales);
    }
}
