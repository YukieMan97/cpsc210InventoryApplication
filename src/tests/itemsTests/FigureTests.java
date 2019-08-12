package itemsTests;

import model.items.Exq;
import model.items.Figure;
import model.items.Nendoroid;
import model.orders.ItemsSold;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FigureTests {
    private ItemsSold itemsSold;
    private Exq e1;
    private Exq e2;
    private Exq e3;
    private Exq e4;
    private Nendoroid n1;
    private Nendoroid n2;
    private Nendoroid n3;

    @BeforeEach
    void runBefore() {
        itemsSold = new ItemsSold();
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
        assertFalse(e1.getName().equals("Memory Defrag Leafa "));

        assertTrue(n1.getName().equals("Nyaruko (Maid Ver.)"));
        assertFalse(n1.getName().equals("Maid Version"));
    }

    @Test
    void setNewName() {
        e1.setName("Leafa");
        assertTrue(e1.getName().equals("Leafa"));

        n2.setName("Albedo~");
        assertTrue(n2.getName().equals("Albedo~"));
    }

    @Test
    void getNumOfNendoroid() {
        assertTrue(n1.getNum().equals("#331"));
        assertFalse(n1.getNum().equals("331"));
    }

    @Test
    void getQuantity() {
        System.out.println(e3.getQuantity());
        assertTrue(e3.getQuantity() == 2);

        System.out.println(e1.getQuantity());
        assertFalse(e1.getQuantity() == 2.0);

        assertTrue(n1.getQuantity() == 0);
        assertFalse(n3.getQuantity() == 9);
    }

    @Test
    void getPriceTag() {
        assertTrue(e2.getPriceTag() == 25.99);
        assertFalse(e2.getPriceTag() == 125.99);

        assertTrue(n2.getPriceTag() == 80.99);
        assertFalse(n2.getPriceTag() == 80);
        assertFalse(n2.getPriceTag() == 81);
    }

    @Test
    void getInformation() {
        System.out.println(e2.getInformation());
        assertTrue(e2.getInformation().equals("Sword Art Online Kirito, Quantity: 2, $25.99"));
        assertFalse(e2.getInformation().equals("sword Art Online Kirito, Quantity: 2, $25.99"));

        System.out.println(n1.getInformation());
        assertTrue(n1.getInformation().equals("Nyaruko (Maid Ver.), #331, Quantity: 0, $55.99"));
        assertFalse(n1.getInformation().equals("sword Art Online Kirito, Quantity: 2, $25.99"));

    }

    @Test
    void testDoesContainFigureName() {
        assertTrue(e2.containsNameOrTitle("kirito"));
        assertTrue(e2.containsNameOrTitle("Kirito"));
        assertFalse(e2.containsNameOrTitle("EXQ"));

        assertTrue(n2.containsNameOrTitle("Albedo"));
        assertTrue(n2.containsNameOrTitle("albedo"));
        assertFalse(n2.containsNameOrTitle("Nendoroid"));
    }

    @Test
    void testPurchaseItem() {
        Nendoroid n4 = Nendoroid.SAITAMA;

        assertTrue(e1.getQuantity() == 1);
        e1.purchaseItem();
        System.out.println(e1.getQuantity());
        System.out.println(itemsSold.getItemsSold());
        System.out.println(e1.getQuantity());
        assertTrue(e1.getQuantity() == 0);

        assertTrue(n2.purchaseItem().equals("5"));
        System.out.println(n2.getQuantity());
        assertTrue(n2.getQuantity() == 5);

        assertTrue(n4.purchaseItem().equals(
                "This item is currently unavailable. However, it can be put on hold."));
    }

    @Test
    void testPutFigureOnHold() {
        System.out.println(e4.getQuantity());
        assertTrue(e4.getQuantity() == 0);
        e1.putItemOnHold();
        assertTrue(e4.getQuantity() == 0);

        System.out.println(n3.getQuantity());
        assertTrue(n3.getQuantity() == 1);
        assertTrue(n3.putItemOnHold().equals("0"));
    }

    @Test
    void testEqual() {
        assertTrue(e1.equals(e1));
        assertFalse(e1.equals(e2));

        assertTrue(n1.equals(n1));
        assertFalse(n1.equals(n2));
    }

    @Test
    void testHashCode() {
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());

        assertTrue(e1.hashCode() == e1.hashCode());
        assertTrue(n2.hashCode() == n2.hashCode());
        assertFalse(e1.hashCode() == e2.hashCode());
        assertFalse(n1.hashCode() == n2.hashCode());
    }

    @Test
    void testFigureProperties() {
        Figure asuna_doughnut = new Exq("Asuna Doughnut", 4, 33.99);
        assertTrue(asuna_doughnut.getQuantity() == 4);
        assertTrue(asuna_doughnut.purchaseItem().equals("3"));
        System.out.println(asuna_doughnut.getQuantity());

        assertTrue(asuna_doughnut.getName().equals("Asuna Doughnut"));
        System.out.println(asuna_doughnut.getInformation());
        assertTrue(asuna_doughnut.getInformation().equals("Asuna Doughnut, Quantity: 3, $33.99"));
        assertFalse(asuna_doughnut.getInformation().equals(""));

        asuna_doughnut.setPriceTag(49.99);
        assertTrue(((Figure) asuna_doughnut).getPriceTag() == 49.99);

        Figure white_dress = new Exq("Love Live White Dress", 0, 35.99);
        assertTrue(white_dress.getQuantity() == 0);

        Figure rem = new Nendoroid("Rem", "663", 2, 79.99);
        assertTrue(rem.getPriceTag() == (79.99));
        assertTrue(rem.getQuantity() == 2);
    }

}
