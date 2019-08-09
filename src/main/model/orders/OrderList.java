package model.orders;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Person> orderList = new ArrayList<>();
    private String name;

    public OrderList(String name) {
        this.name = name;
    }

    public void addPerson(Person p) {
        orderList.add(p);
    }

    public int length() {
        return orderList.size();
    }

    public void display(String indentLevel) {
        String indenteLevelSpace = "  ";
        System.out.println(indentLevel + name);

        for (Person person : orderList) {
            person.display(indenteLevelSpace + indentLevel);
        }
    }
}
