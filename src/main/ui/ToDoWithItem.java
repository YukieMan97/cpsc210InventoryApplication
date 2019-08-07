package ui;

import model.items.Item;
import ui.exceptions.InvalidChangeException;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidNameException;
import ui.exceptions.InvalidTitleException;

public class ToDoWithItem {
    private SearchItemMethods sim;

    public ToDoWithItem(SearchItemMethods sim) {
        this.sim = sim;
    }

    public String getUserResponse() {
        return sim.getUserResponse();
    }

    // TODO method is too long
    public void toDoWithItem(Item item) throws InvalidChangeException,
            InvalidInputException, InvalidNameException, InvalidTitleException {

        toDoWithItemMessage();

        String choiceOfChange = getUserResponse();

        switch (choiceOfChange) {
            // TODO cannot purchase/put item on hold if quantity is 0
            case "1":
                changeQuantityReasons();
                String reasonForQuantityChange = getUserResponse();
                changeQuantity(item, reasonForQuantityChange);
                return;
            // TODO change case #2-#4
            case "2":
                System.out.println("Ok, Correct Quantity");
                return;
            case "3":
                System.out.println("Ok, Set New Price");
                return;
            case "0":
                endSearch();
                return;
            default:
                throw new InvalidChangeException();
                //TODO need to catch
        }
    }

    public void changeQuantityReasons() {
        sim.changeQuantityReasons();
    }

    public void changeQuantity(Item item, String reasonForQuantityChange) throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        sim.changeQuantity(item, reasonForQuantityChange);
    }

    public void toDoWithItemMessage() {
        System.out.println("What would you like to do? Press...");
        System.out.println("1 - Purchase/Hold");
        System.out.println("2 - Correct Quantity");
        System.out.println("3 - Change Price");
        System.out.println("0 - Do Nothing and Exit");
        System.out.println("-----------------------------------");
    }

    public void endSearch() {
        sim.endSearch();
    }
}
