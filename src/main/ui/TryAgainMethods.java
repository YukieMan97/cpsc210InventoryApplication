package ui;

import model.items.Item;
import ui.exceptions.InvalidChangeException;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidNameException;
import ui.exceptions.InvalidTitleException;

public class TryAgainMethods {
    private SearchItemMethods sim;
    private SearchFigure sf;
    private SearchBook sb;
    private ChangeItemQuantity ciq;
    private TryAgainMethods tam;
    private ToDoWithItem tdwi;

    public TryAgainMethods(SearchItemMethods sim, SearchFigure sf, SearchBook sb) {
        this.sim = sim;
        this.sf = sf;
        this.sb = sb;
    }

    public void startAgainSearch() throws InvalidChangeException, InvalidNameException,
            InvalidTitleException, InvalidInputException {
        sim.startAgainSearch();
    }

    public void invalidChoiceMessage() {
        System.out.println("You have entered an invalid choice!");
    }

    // EFFECTS: Asks the user if they want to try again
    public void tryAgainYesOrNo() {
        System.out.println("Would you like to try again? (y/n)");
    }

    // EFFECTS: If user chooses to try again ("y"), then the search function will restart
    //          If user chooses not to "n", then the search function will end.
    public void tryAgainChooseTopic(String yesOrNoAnswer) throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        if (yesOrNoAnswer.equals("y")) {
            startAgainSearch();
        } else if (yesOrNoAnswer.equals("n")) {
            System.out.println("Okay!");
            endSearch();
        } else {
            System.out.println("Invalid answer!");
            System.out.println("Please enter y or n");
            tryAgainChooseTopic(yesOrNoAnswer);
        }
    }

    public void tryAgainBackToSearchAgain() throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        tryAgainYesOrNo();
        String yesOrNoAnswer = sim.getUserResponse();
        tryAgainChooseTopic(yesOrNoAnswer);
    }

    public void backToSearchAgain() throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        System.out.println("Would you like to search for another item? (y/n)");
        String yesOrNoAnswer = sim.getUserResponse();
        tryAgainChooseTopic(yesOrNoAnswer);
    }

    public void tryAgainBackToFigureSearch() throws InvalidNameException,
            InvalidTitleException, InvalidInputException, InvalidChangeException {
        getPrintEmptyLine();
        System.out.println("This figure is not found!");
        getPrintEmptyLine();
        System.out.println("Please try entering a figure name again, ");
        System.out.println("press 1 to go back to the main menu, or ");
        System.out.println("press 0 to exit the search function.");
        System.out.println("----------------------------------------");

        String newResponse = sim.getUserResponse();

        if (newResponse.equals("1")) {
            startAgainSearch();
        }
        if (newResponse.equals("0")) {
            endSearch();
        }
        try {
            getFigureData(newResponse);
        } catch (InvalidNameException e) {
            tryAgainBackToFigureSearch();
        }
    }

    public void getFigureData(String figureName) throws InvalidNameException,
            InvalidTitleException, InvalidInputException, InvalidChangeException {
        sf.getFigureData(figureName);
    }

    public void tryAgainBackToBookSearch() throws InvalidTitleException,
            InvalidInputException, InvalidChangeException, InvalidNameException {
        getPrintEmptyLine();
        System.out.println("This book is not found!");
        getPrintEmptyLine();
        System.out.println("Please try entering a book title again, ");
        System.out.println("press 1 to go back to the main menu, or ");
        System.out.println("press 0 to exit the search function.");
        System.out.println("----------------------------------------");

        String newResponse = sim.getUserResponse();

        if (newResponse.equals("1")) {
            startAgainSearch();
        }
        if (newResponse.equals("0")) {
            endSearch();
        }
        try {
            getBookData(newResponse);
        } catch (InvalidTitleException e) {
            tryAgainBackToBookSearch();
        }
    }

    public void getBookData(String bookTitle) throws InvalidTitleException,
            InvalidInputException, InvalidNameException, InvalidChangeException {
        SearchBook sb = new SearchBook(sim);
        sb.getBookData(bookTitle);
    }

    public void tryAgainBackToGetBookData(String bookTitle) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        invalidChoiceMessage();
        tryAgainYesOrNo();
        String yesOrNoAnswer = sim.getUserResponse();
        if (yesOrNoAnswer.equals("y")) {
            getBookData(bookTitle);
        } else if (yesOrNoAnswer.equals("n")) {
            System.out.println("Okay!");
            endSearch();
        } else {
            tryAgainBackToGetBookData(bookTitle);
        }
    }

    public void tryAgainBackToCustomerOrStaffChoice(Item item, String purchaseOrHold)
            throws InvalidChangeException, InvalidNameException, InvalidTitleException, InvalidInputException {
        getPrintEmptyLine();
        invalidChoiceMessage();
        getPrintEmptyLine();
        System.out.println("Is the item for a customer (1) or staff (2)?");
        System.out.println("Re-enter your choice or press 0 to go back to previous menu.");

        String newChoice = sim.getUserResponse();

        if (newChoice.equals("0")) {
            changeQuantityReasons();
            changeQuantity(item, purchaseOrHold);
        }
        answerToCustomerOrStaff(item, purchaseOrHold, newChoice);
    }

    public void getPrintEmptyLine() {
        System.out.println("");
    }

    public void changeQuantityReasons() {
        ChangeItemQuantity ciq = new ChangeItemQuantity(sim, tam, tdwi);
        ciq.changeQuantityReasons();
    }

    public void changeQuantity(Item item, String purchaseOrHold) throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        ChangeItemQuantity ciq = new ChangeItemQuantity(sim, tam, tdwi);
        ciq.changeQuantity(item, purchaseOrHold);
    }

    public void answerToCustomerOrStaff(Item item, String purchaseOrHold, String chooseCustomerOrStaff) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        ChangeItemQuantity ciq = new ChangeItemQuantity(sim, tam, tdwi);
        ciq.answerToCustomerOrStaff(item, purchaseOrHold, chooseCustomerOrStaff);
    }

    public void endSearch() {
        sim.endSearch();
    }
}
