package model.inventory;

import model.items.Book;

import java.util.ArrayList;

public class BookList extends InventoryList {

    public BookList() {
    }

    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of book titles and quantities of
    //          every book in the list
    public ArrayList bookTitlesAndQuantities(ArrayList<Book> bookArrayList) {
        ArrayList<String> namesAndQuantitiesList = new ArrayList<>();

        for (int counter = 0; counter < bookArrayList.size(); counter++) {
            String name = bookArrayList.get(counter).getTitle();
            String quantity = (Integer.toString(bookArrayList.get(counter).getQuantity()));
            namesAndQuantitiesList.add(name + " with " + quantity + " left.");
        }
        return namesAndQuantitiesList;
    }

    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of in stock books, giving the name and quantity of
    //          each stock where the quantities are greater than zero
    public ArrayList<String> inStockBookList(ArrayList<Book> bookArrayList) {
        ArrayList<String> stockList = new ArrayList<>();

        for (int counter = 0; counter < bookArrayList.size(); counter++) {
            if (bookArrayList.get(counter).getQuantity() != 0) {
                stockList.add(bookArrayList.get(counter).getTitle() + " with "
                        + (Integer.toString(bookArrayList.get(counter).getQuantity())) + " left.");
            } else {
                counter++;
            }
        }
        return stockList;
    }
}

