package itemsTests;

import model.items.*;
import model.orders.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemTests {
    private Item rem;
    private Item asuna;
    private Item albedo;
    private Item maid;
    private Item nier;
    private Item naruto;
    private Customer c1;
    private Customer c2;

    @BeforeEach
    void BeforeTest() {
        rem = Exq.REM_WEDDING;
        asuna = Exq.ASUNA_WEDDING;
        albedo = Nendoroid.ALBEDO;
        maid = Nendoroid.NYARUKO_MAID_VER;
        nier = ArtBook.NIER;
        naruto = Manga.NARUTO_SHIPPUDEN;
        c1 = new Customer("Aaron", "778-374-3892", (new HashSet<Item>()));
        c2 = Customer.TREVOR;
    }

    @Test
    void testPurchaseItem() {
        assertTrue(((Figure) rem).getQuantity() == 0);
        assertTrue(rem.purchaseItem().equals(
                "This item is currently unavailable. However, it can be put on hold."));

        assertTrue(((Figure) asuna).getQuantity() == 2);
        assertTrue(asuna.purchaseItem().equals("1"));
        assertTrue(((Figure) asuna).getQuantity() == 1);
    }

    @Test
    void testPutItemOnHold() {
        assertTrue(((Figure) maid).getQuantity() == 0);
        assertTrue(maid.putItemOnHold().equals("-1"));

        Item ainz = new Nendoroid("Ainz Ooal Gown", "631", 2, 59.99);
        assertTrue(((Figure) ainz).getQuantity() == 2);
        assertTrue(ainz.putItemOnHold().equals("1"));

        Item naruto2 = new Manga("Naruto", 2, "Cool",
                1996, 8, 13.99);
        assertTrue(((Book) naruto2).getQuantity() == 8);
        assertTrue(naruto2.putItemOnHold().equals("7"));

        Item shieldHero = new Manga("Shield Hero", 1, "Terror",
                2015, 0, 15.99);
        assertTrue(((Book) shieldHero).getQuantity() == 0);
        assertTrue(shieldHero.putItemOnHold().equals("-1"));
        assertTrue(((Book) shieldHero).getQuantity() == -1);
    }

    @Test
    void testAddCustomerOrderWithOneItem() {
        nier.addCustomerOrder(c1);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);
    }

    @Test
    void testAddCustomerOrderWithSameItem() {
        rem.addCustomerOrder(c1);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);

        rem.addCustomerOrder(c1);
        assertTrue(c1.getOrderedItems().size() == 1);
    }

    @Test
    void testAddCustomerOrderWithDifferentItems() {
        naruto.addCustomerOrder(c1);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);

        albedo.addCustomerOrder(c1);
        assertTrue(c1.getOrderedItems().size() == 2);
    }

    @Test
    void testAddTwoCustomerOrders() {
        rem.addCustomerOrder(c1);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);

        albedo.addCustomerOrder(c2);
        assertTrue(c2.getOrderedItems().size() == 1);
    }
}
