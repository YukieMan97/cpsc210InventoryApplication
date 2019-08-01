package model.orders;

import model.items.Item;

import java.util.Set;

public class CustomerOrder {
    String name;
    String phoneNumber;
    Set<Item> items;

    public CustomerOrder(String name, String phoneNumber, Set<Item> items) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<Item> getOrderedItems() {
        return items;
    }

    public void addItemToOrder() {

    }

    public void addItems(Item i) {
        if (!items.contains(i)) {
            items.add(i);
            i.addCustomerOrder(this);
        }
    }

}
