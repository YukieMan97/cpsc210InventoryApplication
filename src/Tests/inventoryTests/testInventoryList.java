package inventoryTests;

import model.inventory.BookList;
import model.inventory.FigureList;
import model.inventory.InventoryList;
import model.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testInventoryList {

    private InventoryList il;
    private FigureList fl;
    private BookList bl;

    @BeforeEach
    void beforeTest() {
        il = new FigureList();
        fl = new FigureList();
        bl = new BookList();
    }


    @Test
    void testAddOne() {
        il.insert(Exq.ASUNA_WEDDING);
        assertTrue(il.contains(Exq.ASUNA_WEDDING));
        assertEquals(1, il.size());
    }

    @Test
    void testAddOneDuplicate() {
        il.insert(Exq.ASUNA_WEDDING);
        il.insert(Exq.ASUNA_WEDDING);
        assertTrue(il.contains(Exq.ASUNA_WEDDING));
        assertEquals(1, il.size());
    }

    @Test
    void testAddTwoDifferent() {
        il.insert(Exq.REM_WEDDING);
        il.insert(Exq.ASUNA_WEDDING);
        assertTrue(il.contains(Exq.ASUNA_WEDDING));
        assertTrue(il.contains(Exq.REM_WEDDING));
        assertEquals(2, il.size());
    }

    @Test
    void testRemoveItem() {
        il.insert(Exq.REM_WEDDING);
        il.insert(Exq.ASUNA_WEDDING);
        il.insert(ArtBook.NIER);
        assertTrue(il.size() == 3);
        il.remove(Exq.REM_WEDDING);
        assertTrue(il.size() == 2);
    }

    @Test
    void testPrintNamesAndQuantitiesInList() {
        ArrayList<Figure> a = new ArrayList<>();
        a.add(Exq.ASUNA_WEDDING);
        a.add(Exq.REM_WEDDING);
        fl.figureNamesAndQuantities(a);
        System.out.println(fl.figureNamesAndQuantities(a));
        assertTrue(2 == a.size());
    }

    @Test
    void testPrintTitlesAndQuantitiesInList() {
        ArrayList<Book> a = new ArrayList<>();
        a.add(ArtBook.TOKYO_GHOUL);
        a.add(Manga.KAKEGURUI);
        bl.bookTitlesAndQuantities(a);
        System.out.println(bl.bookTitlesAndQuantities(a));
        assertTrue(2 == a.size());
    }

    @Test
    void testPrintInStockFigures(){
        ArrayList<Figure> a = new ArrayList<>();
        a.add(Exq.ASUNA_WEDDING);
        a.add(Exq.KIRITO_DUAL_WIELD);
       fl.inStockFigureList(a);
        assertTrue(2 == a.size());

        a.add(Exq.REM_WEDDING);
        fl.inStockFigureList(a);
        System.out.println(fl.inStockFigureList(a));
        assertTrue(3 == a.size());
    }

    @Test
    void testPrintInStockBooks() {
        ArrayList<Book> a = new ArrayList<>();
        a.add(ArtBook.TOKYO_GHOUL);
        a.add(Manga.KAKEGURUI);
        bl.inStockBookList(a);
        System.out.println(bl.inStockBookList(a));
        assertTrue(2 == a.size());
        assertTrue(bl.inStockBookList(a).size() == 1);
    }
}
