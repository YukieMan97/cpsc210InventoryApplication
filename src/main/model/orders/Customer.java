package model.orders;

import model.items.Item;

import java.util.HashSet;
import java.util.Set;

public class Customer extends Person {
    protected Set<Item> items;

    public static final Customer TREVOR = new Customer("Trevor", "778-234-6943", (new HashSet<Item>()));

    public Customer(String name, String phoneNumber, Set<Item> items) {
        super(name, phoneNumber);
        this.items = items;
    }

    public Set<Item> getOrderedItems() {
        return items;
    }

    public void addItems(Item i) {
        if (!items.contains(i)) {
            items.add(i);
            i.addCustomerOrder(this);
        }
    }

    public void display(String indentLevel) {
        System.out.println(indentLevel + getName() + ", " + getPhoneNumber());
    }

}
