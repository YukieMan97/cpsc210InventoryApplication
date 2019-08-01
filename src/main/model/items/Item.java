package model.items;

import model.orders.CustomerOrder;

import java.util.HashSet;
import java.util.Set;

public abstract class Item {
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

    Set<CustomerOrder> customerOrders;

    public void addCustomerOrder(CustomerOrder co) {
        customerOrders = new HashSet<>();
        if (!customerOrders.contains(co)) {
            customerOrders.add(co);
            co.addItems(this);
        }
    }

}
