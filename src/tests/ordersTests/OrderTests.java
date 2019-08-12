package ordersTests;

import model.items.Exq;
import model.items.Item;
import model.items.Nendoroid;
import model.orders.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderTests {
    private Sales sales;
    private ItemsSold itemsSold;
    private Exq e1;
    private Exq e2;
    private Nendoroid n1;
    private Nendoroid n2;
    private Customer c1;
    private Customer c2;

    @BeforeEach
    void runBefore() {
        sales = new Sales();
        itemsSold = new ItemsSold();
        e1 = Exq.LEAFA_FAIRY;
        e2 = Exq.KIRITO_DUAL_WIELD;
        n1 = Nendoroid.NYARUKO_MAID_VER;
        n2 = Nendoroid.ALBEDO;
        c1 = new Customer("Aaron", "778-374-3892", (new HashSet<Item>()));
        c2 = Customer.TREVOR;
    }

    @Test
    void testGetCustomerName() {
        assertTrue(c2.getName().equals("Trevor"));
        assertFalse(c2.getName().equals("trevor"));
    }

    @Test
    void testGetCustomerPhoneNumber() {
        assertTrue(c1.getPhoneNumber().equals("778-374-3892"));
        assertFalse(c1.getPhoneNumber().equals("778-374-38922"));
    }

    @Test
    void testGetStaffName() {
        assertTrue(Staff.TANYA.getName().equals("Tanya"));
        assertFalse(Staff.TANYA.getName().equals("tanya"));
    }

    @Test
    void testGetItemWanted() {
        Staff.TANYA.getItem();
        Staff.CARRIE.getItem();
    }

    @Test
    void testNoItemsWanted() {
        Staff.JON.getItem();
    }

    @Test
    void testAddCustomerOrderToItem() {
        c1.addItems(e2);
        System.out.println(c1.getOrderedItems());
        assertTrue(c1.getOrderedItems().size() == 1);
    }

    @Test
    void testaddPerson() {
        OrderList exqOrderList = new OrderList("Order list for EXQ figures");
        exqOrderList.addPerson(Staff.TANYA);
        exqOrderList.addPerson(Staff.ELLY);
        exqOrderList.display("  -");
        assertTrue(exqOrderList.length() == 2);
    }

    @Test
    void testLengthOfOrderList() {
        OrderList exqOrderList = new OrderList("Order list for EXQ figures");
        assertTrue(exqOrderList.length() == 0);
        exqOrderList.addPerson(Staff.TANYA);
        exqOrderList.addPerson(Staff.ELLY);
        assertTrue(exqOrderList.length() == 2);
    }

    @Test
    void testDisplay() {
        OrderList exqOrderList = new OrderList("Order list for EXQ figures");
        exqOrderList.addPerson(Staff.CARRIE);
        exqOrderList.addPerson(Staff.TANYA);
        exqOrderList.display("  -");
        exqOrderList.display("  --");

        c1.display("~ ~ ~");
        Staff.CARRIE.display("~ ~ ~");
    }

    @Test
    void testUpdate() {
        Staff.TANYA.update(sales);
    }

    @Test
    void testGetSales() {
        assertTrue(sales.getSales() == 0.0);
        assertTrue(sales.getSales() == 0);
    }

    @Test
    void testGetRoundedSales() {
        System.out.println(sales.getSales() + 14.99);
        System.out.println(sales.getRoundedSales());
        assertFalse((sales.getSales() + 14.99) == sales.getRoundedSales());
    }

    @Test
    void testSetSalesGoal() {
        assertTrue(sales.salesGoal == 200);
        sales.setSalesGoals("300");
        assertTrue(sales.salesGoal == 300);
    }

    @Test
    void testPrintSales() {
        System.out.println(sales.printSales());
        assertTrue(sales.printSales().equals("We made $0.0 so far."));
    }

    @Test
    void testSalesGoalMet() {
        Sales sales2 = new Sales();
        sales2.setSalesGoals("0");
        System.out.println(sales2.salesGoalMet());
        assertTrue(sales2.salesGoalMet().equals("Revenue goal met! We "
                + "have surpassed $0, and we are now at $0.0!"));
    }

    @Test
    void testSalesGoalNotMet() {
        System.out.println(sales.salesGoalMet());
        assertTrue(sales.salesGoalMet().equals("Revenue goal is not met."
                + " We are currently at $0.0, and our goal is $200. Only"
                + " $200 to go!"));
    }

    @Test
    void testAddObserver() {
        assertTrue(sales.sizeOfObserverList() == 0);
        sales.addObserver(Staff.ELLY);
        sales.addObserver(Staff.JON);
        assertTrue(sales.sizeOfObserverList() == 2);
    }

    @Test
    void testSizeOfOberserverList() {
        assertTrue(sales.sizeOfObserverList() == 0);
        sales.addObserver(Staff.ELLY);
        assertTrue(sales.sizeOfObserverList() == 1);
    }

    @Test
    void testNotifyObservers() {
        sales.addObserver(Staff.JON);
        sales.addObserver(Staff.CARRIE);
        sales.notifyObservers(sales);
    }

    @Test
    void testGetNumberOfItemsSold() {
        itemsSold.sellItem();
        itemsSold.sellItem();
        assertTrue(itemsSold.getItemsSold() == 2);
    }

    @Test
    void testGetItemsSold() {
        System.out.println(itemsSold.getItemsSoldMessage());
        itemsSold.sellItem();
        assertTrue((itemsSold.getItemsSoldMessage()).equals("We have sold 1 item(s) so far."));
    }

    @Test
    void testSellItem() {
        itemsSold.sellItem();
        assertTrue(itemsSold.getItemsSold() == 1);
    }
}
