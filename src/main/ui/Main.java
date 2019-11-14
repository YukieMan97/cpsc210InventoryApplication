package ui;

import ui.exceptions.InvalidChangeException;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidNameException;
import ui.exceptions.InvalidTitleException;

import static ui.SearchItemMethods.initiateSearch;

public class Main {
    public static void main(String[] args) throws InvalidNameException, InvalidTitleException,
            InvalidInputException, InvalidChangeException {
        SearchItemMethods searchItemMethods = new SearchItemMethods();
        initiateSearch();
        searchItemMethods.startSearch();
    }
}
