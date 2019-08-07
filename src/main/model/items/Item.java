package model.items;

import model.orders.CustomerOrder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Item {

    private Set<CustomerOrder> customerOrders;

//    protected HashMap<items, Set<items>> itemLookUp = new HashMap<>();
//
//    public void addExqFigure(Exq exq) {
//        itemLookUp.put(exq, new HashSet<>());
//    }
//
//    public void addBook(Book book) {
//        itemLookUp.put(book, new HashSet<>());
//    }
//
//    public void addExqFigure(String figureType, Exq exq) {
//        Set<items> figures = itemLookUp.get(figureType);
//        figures.add(exq);
//
//    }

    public static final ArrayList<Item> ITEM_LIST = new ArrayList<Item>() {
        {
//            ITEM_LIST.addAll(Figure.FIGURE_LIST);
//            ITEM_LIST.addAll(Book.BOOK_LIST);
        }
    };

    public abstract int purchaseItem();

    public abstract int putItemOnHold();


    public void addCustomerOrder(CustomerOrder co) {
        customerOrders = new HashSet<>();
        if (!customerOrders.contains(co)) {
            customerOrders.add(co);
            co.addItems(this);
        }
    }

}
