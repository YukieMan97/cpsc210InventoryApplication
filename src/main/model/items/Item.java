package model.items;

import model.orders.Customer;
import model.orders.Sales;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Item {
    protected int itemsSold;
    protected double sales;
    protected Sales sales1;
    private int quantity;

    public Item() {
        sales1 = new Sales();
    }

    public static final ArrayList<Item> ITEM_LIST = new ArrayList<Item>() {
        {
//            ITEM_LIST.addAll(Figure.FIGURE_LIST);
//            ITEM_LIST.addAll(Book.BOOK_LIST);
        }
    };

    // MODIFIES: This
    // EFFECTS: purchases an item by decreasing its quantity by one.
    //          Also increases the amount of items sold by one.
    //          If the quantity is zero, then the item will be unavailable
    //          for purchase but available for putting on hold.
    public String purchaseItem() {
        if (quantity != 0) {
            itemsSold++;
            int newQuantity = quantity--;
            return Integer.toString(newQuantity);
        }
        putItemOnHold();
        return "This item is currently unavailable. However, it can be put on hold.";
    }

    // MOFIDIES: this
    // EFFECTS: puts an item on hold by decreasing the quantity by one.
    //          When the quantity becomes a negative integer, that indicates
    //          how much the store should order in.
    public String putItemOnHold() {
        int newQuantity = quantity--;
        return Integer.toString(newQuantity);
    }


    public void addCustomerOrder(Customer co) {
        Set<Customer> customers = new HashSet<>();
        if (!customers.contains(co)) {
            customers.add(co);
            co.addItems(this);
        }
    }

}
