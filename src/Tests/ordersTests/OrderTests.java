package ordersTests;

import model.items.Exq;
import model.items.Item;
import model.items.Nendoroid;
import model.orders.CustomerOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTests {
    private Exq e1;
    private Exq e2;
    private Nendoroid n1;
    private Nendoroid n2;
    private Set<CustomerOrder> customerOrders;
    private Set<Item> items;
    private CustomerOrder c1;

    @BeforeEach
    void runBefore() {
        e1 = Exq.LEAFA_FAIRY;
        e2 = Exq.KIRITO_DUAL_WIELD;
        n1 = Nendoroid.NYARUKO_MAID_VER;
        n2 = Nendoroid.ALBEDO;
        c1 = new CustomerOrder("Tanya", "778-234-6943", (new HashSet<Item>()));
    }

    @Test
    void testAddItemToCustomerOrder() {
        e1.addCustomerOrder(c1);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);
    }

    @Test
    void testAddCustomerOrderToItem() {
        c1.addItems(e2);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);
    }
}
