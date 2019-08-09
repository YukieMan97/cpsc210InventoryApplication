package ui;

import model.items.Book;
import model.items.Figure;
import model.items.Item;
import model.orders.Sales;
import ui.exceptions.InvalidChangeException;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidNameException;
import ui.exceptions.InvalidTitleException;

public class ChangeItemQuantity {
    private SearchItemMethods sim;
    private TryAgainMethods tam;
    private SearchBook sb;
    private SearchFigure sf;
    private ToDoWithItem tdwi;
    private Sales sales;

    // Constructor
    public ChangeItemQuantity(SearchItemMethods sim, TryAgainMethods tam, ToDoWithItem tdwi) {
        this.sim = sim;
        this.tam = tam;
        this.tdwi = tdwi;
        sales = new Sales();
    }

    public String getUserResponse() {
        return sim.getUserResponse();
    }

    // EFFECTS: prints reasons for changing the quantity to select
    public void changeQuantityReasons() {
        System.out.println("More speficially...");
        System.out.println("1 - Purchase");
        System.out.println("2 - Hold");
        System.out.println("0 - Go Back To Previous Menu");
        System.out.println("-----------------------------------");
    }

    public void changeQuantityChoice1(Item item) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        changeQuantityReasons();
        String reasonForQuantityChange = getUserResponse();
        changeQuantity(item, reasonForQuantityChange);
    }

    // EFFECTS: Allows the user to choose the reason for a quantity change where "1"
    //          is to purchase the item, "2" is to put the item on hold, "0" is to
    //          go back to the previous menu.
    //          Throws InvalidInputException when the user enters an invalid input
    public void changeQuantity(Item item, String purchaseOrHold) throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        switch (purchaseOrHold) {
            case "1":
                purchase(item, purchaseOrHold);
                return;
            case "2":
                hold(item, purchaseOrHold);
                return;
            case "0":
                System.out.println("Okay, returning to previous menu!");
                tdwi.toDoWithItemMessage();
                return;

            default:
                throw new InvalidInputException();
        }
    }

    public void purchase(Item item, String purchaseOrHold) throws InvalidTitleException,
            InvalidNameException, InvalidChangeException, InvalidInputException {
        System.out.println("Purchase!");
        try {
            customerOrStaff(item, purchaseOrHold);
        } catch (InvalidInputException e) {
            System.out.println("You have entered an invalid choice!");
            tam.tryAgainBackToSearchAgain();
        }
    }

    public void hold(Item item, String purchaseOrHold) throws InvalidTitleException,
            InvalidNameException, InvalidChangeException, InvalidInputException {
        System.out.println("Hold!");
        try {
            customerOrStaff(item, purchaseOrHold);
        } catch (InvalidInputException e) {
            System.out.println("You have entered an invalid choice!");
            tam.tryAgainBackToSearchAgain();
        }
    }

    // EFFECTS: Allows the user to choose if the purchase or hold of an item
    //          is for a customer or staff.
    //          Throws InvalidInputException when the user enters an invalid input
    public void customerOrStaff(Item item, String purchaseOrHold) throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        System.out.println("For Customer (1) or Staff (2)?");

        String chooseCustomerOrStaff = getUserResponse();

        answerToCustomerOrStaff(item, purchaseOrHold, chooseCustomerOrStaff);

        throw new InvalidInputException();
    }

    public void answerToCustomerOrStaff(Item item, String purchaseOrHold, String chooseCustomerOrStaff)
            throws InvalidChangeException, InvalidNameException, InvalidTitleException, InvalidInputException {
        try {
            purchaseOrHold(item, purchaseOrHold, chooseCustomerOrStaff);
        } catch (InvalidInputException e) {
            tryAgainBackToCustomerOrStaffChoice(item, purchaseOrHold);
        }
    }

    // EFFECTS: prints out whether the purchase of an item is for a customer or staff
    public void purchaseOrHold(Item item, String purchaseOrHold, String chooseCustomerOrStaff)
            throws InvalidInputException, InvalidTitleException, InvalidNameException, InvalidChangeException {

        if (purchaseOrHold.equals("1") && (chooseCustomerOrStaff.equals("1"))) {
            customerPurchase(item);
            return;
        }
        if (purchaseOrHold.equals("1") && (chooseCustomerOrStaff.equals("2"))) {
            staffPurchase(item);
            return;
        }
        if (purchaseOrHold.equals("2") && (chooseCustomerOrStaff.equals("1"))) {
            customerHold(item);
            return;
        }
        if (purchaseOrHold.equals("2") && (chooseCustomerOrStaff.equals("2"))) {
            staffHold(item);
            return;
        }
        throw new InvalidInputException();
    }

    public void staffHold(Item item) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        String info = "staff hold!";
        item.putItemOnHold();
        printPurchaseOrHoldMessage(item, info);
    }

    public void customerPurchase(Item item) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        String info = "customer purchase!";
        item.purchaseItem();
        sales.increaseSales(item);
        printPurchaseOrHoldMessage(item, info);
    }

    public void staffPurchase(Item item) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        String info = "staff purchase!";
        item.purchaseItem();
        sales.increaseSales(item);
        printPurchaseOrHoldMessage(item, info);
    }

    public void customerHold(Item item)
            throws InvalidChangeException, InvalidNameException, InvalidTitleException, InvalidInputException {
        String info = "customer hold!";
        item.putItemOnHold();
        printPurchaseOrHoldMessage(item, info);
    }

    public void printPurchaseOrHoldMessage(Item item, String info) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        if (item instanceof Figure) {
            System.out.println("Okay, " + ((Figure) item).getName() + " will be for " + info);
            System.out.println("Only " + ((Figure) item).getQuantity()
                    + " of " + ((Figure) item).getName() + " left in stock.");
            backToSearchAgain();
        }
        if (item instanceof Book) {
            String titleAndVolumeOrChapter = ((Book) item).getTitle() + " " + ((Book) item).getVolumeOrChapter();
            System.out.println("Okay, " + titleAndVolumeOrChapter + " will be for " + info);
            System.out.println("Only " + ((Book) item).getQuantity()
                    + " of " + titleAndVolumeOrChapter + " left in stock.");
            backToSearchAgain();
        }
    }

    public void endSearch() {
        sim.endSearch();
    }

    public void tryAgainBackToCustomerOrStaffChoice(Item item, String purchaseOrHold)
            throws InvalidChangeException, InvalidNameException, InvalidTitleException, InvalidInputException {
        TryAgainMethods tam = new TryAgainMethods(sim, sf, sb);
        tam.tryAgainBackToCustomerOrStaffChoice(item, purchaseOrHold);
    }

    public void backToSearchAgain() throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        TryAgainMethods tam = new TryAgainMethods(sim, sf, sb);
        tam.backToSearchAgain();
    }

}
