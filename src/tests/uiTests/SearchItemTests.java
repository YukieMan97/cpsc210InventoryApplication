package uiTests;

import model.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.*;
import ui.exceptions.*;

import java.util.ArrayList;

import static model.items.ArtBook.NIER;
import static model.items.Manga.*;
import static org.junit.jupiter.api.Assertions.*;

class SearchItemTests {
    private SearchItemMethods searchItemMethods;
    private SearchFigure searchFigure;
    private SearchBook searchBook;
    private Manga mn1;
    private Manga mn2;
    private Manga mn3;
    private Manga mn4;
    private ArtBook ab;
    private Exq e1;
    private Exq e2;
    private Nendoroid n1;
    private Nendoroid n2;
    private ArrayList<Book> bookArrayList;
    private ChangeItemQuantity ciq;
    private TryAgainMethods tam;
    private ToDoWithItem tdwi;

    @BeforeEach
    void runBefore() {
        searchItemMethods = new SearchItemMethods();
        searchBook = new SearchBook(searchItemMethods);
        searchFigure = new SearchFigure(searchItemMethods);
        ciq = new ChangeItemQuantity(searchItemMethods, tam, tdwi);
        mn1 = NARUTO_SHIPPUDEN;
        mn2 = PROMISED_MN2;
        mn3 = PROMISED_MN3;
        mn4 = PROMISED_MN1;
        ab = NIER;
        e1 = Exq.LEAFA_FAIRY;
        e2 = Exq.KIRITO_DUAL_WIELD;
        n1 = Nendoroid.NYARUKO_MAID_VER;
        n2 = Nendoroid.ALBEDO;
        bookArrayList = Book.BOOK_LIST;
    }

    @Test
    void TestChooseFigure() {
        String choice = "1";
        try {
            searchItemMethods.chooseFigureOrBook(choice);
            // success
        } catch (InvalidInputException e) {
            fail("Exception should have been thrown!");
        }
    }

//    @Test
//    void TestChooseBook() throws InvalidInputException {
//        String choice = "2";
//        try {
//            searchItemMethods.chooseFigureOrBook(choice);
//            // success
//        } catch (InvalidInputException e) {
//            fail("Exception should have been thrown!");
//        }
//    }
//
//    @Test
//    void TestChooseFigureOrBookExit() throws InvalidInputException {
//        String choice = "0";
//        try {
//            searchItemMethods.chooseFigureOrBook(choice);
//            // success
//        } catch (InvalidInputException e) {
//            fail("Exception should have been thrown!");
//        }
//    }

    @Test
    void TestChooseFigureOrBookInvalidInputException() {
        String choice = "3";
        try {
            searchItemMethods.chooseFigureOrBook(choice);
            fail("throw new InvalidInputException!");
        } catch (InvalidInputException e) {
            // success
        }
    }

//    @Test
//    void TestGetBookFromSearch() {
//        assertTrue(searchBook.getBookFromSearch("naruto").equals(mn1));
//        System.out.println(searchBook.getBookFromSearch("lllllllll") == null);
//        assertFalse(searchBook.getBookFromSearch("naruto").equals(mn2));
//    }
//
//    @Test
//    void TestGetBookDataListSizeIsOne() {
//        String bookTitle = "naruto";
//        assertTrue(searchBook.getBookFromSearch(bookTitle).equals(mn1));
//    }
//
//    @Test
//    void TestGetBookDataListSizeIsZero() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        String bookTitle = "nierr";
//        try {
//            searchBook.getBookData(bookTitle);
//            fail("throw new InvalidTitleException");
//        } catch (InvalidTitleException e) {
//            // success
//        }
//    }
//
//    @Test
//    void TestCustomerPurchase() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        try {
//            ciq.purchaseOrHold(mn1,"1", "1");
//        } catch (InvalidInputException e) {
//            fail("InvalidInputException should be thrown here!");
//        }
//
//        assertTrue(mn1.getQuantity() == 1);
//    }
//
//    @Test
//    void TestStaffPurchase() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        try {
//            ciq.purchaseOrHold(mn1,"1", "2");
//        } catch (InvalidInputException e) {
//            fail("InvalidInputException should be thrown here!");
//        }
//
//        assertTrue(mn1.getQuantity() == 1);
//    }
//
//    @Test
//    void TestCustomerHold() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        try {
//            ciq.purchaseOrHold(mn1,"2", "1");
//        } catch (InvalidInputException e) {
//            fail("InvalidInputException should be thrown here!");
//        }
//
//        assertTrue(mn1.getQuantity() == 2);
//    }
//
//    @Test
//    void TestStaffHold() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        try {
//            ciq.purchaseOrHold(mn1,"2", "2");
//        } catch (InvalidInputException e) {
//            fail("InvalidInputException should be thrown here!");
//        }
//
//        assertTrue(mn1.getQuantity() == 2);
//    }

//    @Test
//    void TestChangeQuantityPurchaseChoice() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        String purchaseOrHold = "1";
//        try {
//            searchItemMethods.changeQuantity(mn1, purchaseOrHold);
//            // success
//        } catch (InvalidInputException e) {
//            fail("InvalidInputException should be thrown here!");
//        }
//
//    }

//    @Test
//    void TestGetFigureDataOfOneFigure() throws InvalidChangeException,
//            InvalidNameException, InvalidTitleException, InvalidInputException {
//        String figureName = "Kirito";
//        try {
//            searchFigure.getFigureData(figureName);
//            // success
//        } catch (InvalidNameException e) {
//            fail("InvalidNameException should be thrown here!");
//        }
//    }

}

