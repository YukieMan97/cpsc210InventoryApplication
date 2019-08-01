package model.inventory;

import model.items.Book;

import java.util.ArrayList;

public class BookList extends InventoryList {

    ArrayList<Book> bookData = new ArrayList<>();


    // REQUIRES: a non-empty list with no duplicate figures
    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of book titles and quantities of
    //          every book in the list
    @Override
    public ArrayList namesAndQuantities() {
        ArrayList<String> namesAndQuantitiesList = new ArrayList<>();

        for (int counter = 0; counter < bookData.size(); counter++) {
            String name = bookData.get(counter).getTitle();
            String quantity = (Integer.toString(bookData.get(counter).getQuantity()));
            namesAndQuantitiesList.add(name + " with " + quantity + " left.");
        }
        return namesAndQuantitiesList;
    }


    // REQUIRES: a non-empty list with no duplicates
    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of in stock books, giving the name and quantity of
    //          each stock where the quantities are greater than zero
    @Override
    public ArrayList inStockList() {
        ArrayList<String> stockList = new ArrayList<>();

        for (int counter = 0; counter < this.bookData.size(); counter++) {
            if (this.bookData.get(counter).getQuantity() != 0) {
                stockList.add(this.bookData.get(counter).getTitle() + " with "
                        + (Integer.toString(this.bookData.get(counter).getQuantity())) + " left.");
            } else {
                counter++;
            }
        }
        return stockList;
    }
}

