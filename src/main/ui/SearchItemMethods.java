package ui;

import model.items.Item;
import ui.exceptions.InvalidChangeException;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidNameException;
import ui.exceptions.InvalidTitleException;

import java.util.Scanner;


public class SearchItemMethods {
    private ChangeItemQuantity ciq;
    private SearchBook sb;
    private SearchFigure sf;
    private TryAgainMethods tam;
    private ToDoWithItem tdwi;

    public SearchItemMethods() {
        ciq = new ChangeItemQuantity(this, tam, tdwi);
        sb = new SearchBook(this);
        sf = new SearchFigure(this);
        tam = new TryAgainMethods(this, sf, sb);
        tdwi = new ToDoWithItem(this);
    }

    // EFFECTS returns the user's input
    public String getUserResponse() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    // EFFECTS prints the main menu for searching
    public static void initiateSearch() {
        System.out.println("To search for a...");
        System.out.println("Figure - press 1");
        System.out.println("Book - press 2");
        System.out.println("Press 0 to exit search.");
        System.out.println("----------------------------");
    }

    // EFFECTS: The first user's response will allow them to choose which item to search.
    //          The second user's response will allow them to search for the item
    //          startsSearch runs again if an exception is thrown and user wants to try again
    public void startSearch() throws InvalidInputException, InvalidChangeException,
            InvalidNameException, InvalidTitleException {
        String choice1 = getUserResponse();
        tryFirstChoice(choice1);
        String choice2 = getUserResponse();
        chosenFigureOrBookChoice(choice1, choice2);
    }

    // EFFECTS initiates the search function again by printing the menu
    //         and starts the search function again by allowing user input
    //         This occurs when the user wants to try again
    public void startAgainSearch() throws InvalidChangeException, InvalidNameException,
            InvalidTitleException, InvalidInputException {
        initiateSearch();
        startSearch();
    }

    private void tryFirstChoice(String choice1) throws InvalidChangeException,
            InvalidTitleException, InvalidInputException, InvalidNameException {
        try {
            chooseFigureOrBook(choice1);
        } catch (InvalidInputException e) {
            tryAgainBackToSearchAgain();
        }
    }

    // EFFECTS: If user input is "1", then figures will be searched
    //          If input is "2", then books will be searched
    //          If input is "0", then the search function will end
    //          Throws InvalidInputException when an invalid choice is inputted
    public void chooseFigureOrBook(String choice) throws InvalidInputException {
        switch (choice) {
            // choose figure
            case "1":
                System.out.println("You have selected figure! Enter the figure's name.");
                return;
            // choose book
            case "2":
                System.out.println("You have selected book! Enter the book's title.");
                return;
            // choose quit
            case "0":
                endSearch();
                return;
            default:
                throw new InvalidInputException();
        }
    }

    // EFFECTS: If user input is "1", then the figure will be searched
    //          If user input is "2", then the book will be searched
    private void chosenFigureOrBookChoice(String choice1, String choice2) throws InvalidChangeException,
            InvalidTitleException, InvalidInputException, InvalidNameException {
        if (choice1.equals("1")) {
            try {
                getFigureData(choice2);
            } catch (InvalidNameException e) {
                tryAgainBackToFigureSearch();
            }
        }
        if (choice1.equals("2")) {
            chosenFigureOrBookChoice2(choice2);
        }
    }

    // EFFECTS: Searches for a book
    public void chosenFigureOrBookChoice2(String choice2) throws InvalidInputException, InvalidChangeException,
            InvalidNameException, InvalidTitleException {
        try {
            getBookData(choice2);
            getBookFromSearch(choice2);
        } catch (InvalidTitleException e) {
            tryAgainBackToBookSearch();
        } finally {
            System.out.println("~ Hope you enjoy this search function ~");
        }
    }

    public void getFigureData(String figureName) throws InvalidNameException,
            InvalidTitleException, InvalidInputException, InvalidChangeException {
        sf.getFigureData(figureName);
    }

    public void tryAgainBackToFigureSearch() throws InvalidNameException,
            InvalidTitleException, InvalidInputException, InvalidChangeException {
        tam.tryAgainBackToFigureSearch();
    }

    public void getBookData(String bookTitle) throws InvalidTitleException,
            InvalidChangeException, InvalidInputException, InvalidNameException {
        sb.getBookData(bookTitle);
    }

    public void tryAgainBackToBookSearch() throws InvalidTitleException,
            InvalidInputException, InvalidChangeException, InvalidNameException {
        tam.tryAgainBackToBookSearch();
    }

    public void getBookFromSearch(String choice2) {
        sb.getBookFromSearch(choice2);
    }

    // EFFECTS: prints reasons for changing the quantity to select
    public void changeQuantityReasons() {
        ciq.changeQuantityReasons();
    }

    public void changeQuantity(Item item, String reasonForQuantityChange) throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        try {
            ciq.changeQuantity(item, reasonForQuantityChange);
        } catch (InvalidInputException e) {
            tryAgainBackToSearchAgain();
        }
    }

    public void tryAgainBackToSearchAgain() throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        tam.tryAgainBackToSearchAgain();
    }

    public void endSearch() {
        System.out.println("Search function exited; Have a good day!");
        System.exit(0);

    }
}
