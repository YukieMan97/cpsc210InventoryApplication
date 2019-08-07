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

    public void display(String indentLevel) {
        System.out.println(indentLevel + name);

        for (Person person : orderList) {
            person.display(indentLevel + indentLevel);
        }
    }

    public static void main(String[] args) {
        OrderList exqOrderList = new OrderList("Order list for EXQ figures");
        OrderList mangaOrderList = new OrderList("Order list for Manga");
        exqOrderList.addPerson(Staff.TANYA);
        exqOrderList.addPerson(Staff.ELLY);
        mangaOrderList.addPerson(Staff.CARRIE);

        exqOrderList.display("  ");
        mangaOrderList.display("  ");


    }
}
