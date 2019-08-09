package itemsTests;

import model.items.Exq;
import model.items.Nendoroid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FigureTests {
    private Exq e1;
    private Exq e2;
    private Exq e3;
    private Exq e4;
    private Nendoroid n1;
    private Nendoroid n2;
    private Nendoroid n3;

    @BeforeEach
    void runBefore() {
        e1 = Exq.LEAFA_FAIRY;
        e2 = Exq.KIRITO_DUAL_WIELD;
        e3 = Exq.ASUNA_WEDDING;
        e4 = Exq.REM_WEDDING;
        n1 = Nendoroid.NYARUKO_MAID_VER;
        n2 = Nendoroid.ALBEDO;
        n3 = Nendoroid.HATSUNE;
    }

    @Test
    void getName() {
        assertTrue(e1.getName().equals("Memory Defrag Leafa"));
        assertFalse(n1.getName().equals("Maid Version"));
    }

    @Test
    void setNewName() {
        e1.setName("Leafa");
        assertTrue(e1.getName().equals("Leafa"));

        n1.setName("Nya~");
        assertTrue(n1.getName().equals("Nya~"));
    }

    @Test
    void getQuantity() {
        System.out.println(e3.getQuantity());
        assertTrue(e3.getQuantity() == 2);
        assertFalse(e1.getQuantity() == 1.0);

        assertFalse(n3.getQuantity() == 9);
    }

    @Test
    void getPriceTag() {
        assertTrue(e2.getPriceTag() == 25.99);
        assertFalse(e2.getPriceTag() == 125.99);
        assertFalse(n1.getPriceTag() == 130);
    }

    @Test
    void getInformation() {
        System.out.println(e2.getInformation());
        assertTrue(e2.getInformation().equals("Sword Art Online Kirito, Quantity: 2, $25.99"));
        assertFalse(e2.getInformation().equals("sword Art Online Kirito, Quantity: 2, $25.99"));
    }

    @Test
    void TestDoesContainFigureName() {
        assertTrue(e2.containsNameOrTitle("kirito"));
        assertTrue(e2.containsNameOrTitle("Kirito"));
        assertFalse(e2.containsNameOrTitle("EXQ"));
    }

    @Test
    void TestPurchaseBook() {
        assertTrue(e1.getQuantity() == 1);
        e1.purchaseItem();
        System.out.println(e1.getQuantity());
        assertTrue(e1.getQuantity() == 0);
        n2.purchaseItem();
        System.out.println(n2.getQuantity());
        assertTrue(n2.getQuantity() == 5);
    }

    @Test
    void TestPutFigureOnHold() {
        System.out.println(e4.getQuantity());
        assertTrue(e4.getQuantity() == 0);
        e1.putItemOnHold();
        assertTrue(e4.getQuantity() == 0);

        System.out.println(n3.getQuantity());
        assertTrue(n3.getQuantity() == 1);
        n3.putItemOnHold();
        assertTrue(n3.getQuantity() == 0);
    }
}
