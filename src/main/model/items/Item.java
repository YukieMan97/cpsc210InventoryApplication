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

    public Item() {
        sales1 = new Sales();
    }

    public static final ArrayList<Item> ITEM_LIST = new ArrayList<Item>() {
        {
//            ITEM_LIST.addAll(Figure.FIGURE_LIST);
//            ITEM_LIST.addAll(Book.BOOK_LIST);
        }
    };

    public abstract int purchaseItem();

    public abstract int putItemOnHold();


    public void addCustomerOrder(Customer co) {
        Set<Customer> customers = new HashSet<>();
        if (!customers.contains(co)) {
            customers.add(co);
            co.addItems(this);
        }
    }

}
