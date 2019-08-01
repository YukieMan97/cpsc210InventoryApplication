package uiTests;

import org.junit.jupiter.api.BeforeEach;
import ui.SearchItemMethods;

import java.util.Scanner;

public class SearchItemTests {
    private Scanner searchItem;
    private SearchItemMethods searchItemMethods;

    @BeforeEach
    void runBefore() {
        searchItem = new Scanner(System.in);
        searchItemMethods = new SearchItemMethods();
    }

//    @Test
//    void NoInvalidInputExceptionThrown() throws InvalidNameException, InvalidTitleException {
//        String choice1 = "1";
//        try {
//            chooseFigureOrBook(choice1);
//        } catch (InvalidInputException e) {
//            fail("Invalid input exception thrown!");
//        } finally {
//            System.out.println("You can choose whatever you like ~");
//        }
//    }
}

