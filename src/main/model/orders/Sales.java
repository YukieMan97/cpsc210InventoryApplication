package model.orders;

public class Sales {
    private double sales;
    private int salesGoal;

    public Sales() {
        this.sales = 0.0;
        this.salesGoal = 200;
    }

    public int getSales() {
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
                + " Only $" + (Integer.toString((salesGoal - getSales())) + " to go!");
    }

    public static void main(String[] args) {
        Sales rev = new Sales();
        System.out.println(rev.setSalesGoals("250"));
        System.out.println(rev.getSales());
        System.out.println(rev.printSales());
        System.out.println(rev.salesGoalMet());
    }
}
