package model.inventory;

import model.items.Item;
import model.items.Book;
import model.items.Figure;

import java.util.ArrayList;

public abstract class InventoryList {

    private ArrayList<Item> itemData = new ArrayList<>();
    private ArrayList<Book> booksData = new ArrayList<>();
    private ArrayList<Figure> figuresData = new ArrayList<>();


    // MODIFIES: this
    // EFFECTS: adds e to the set unless e is already in the exq set
    //          in which case it does nothing
    public void insert(Item i) {
        if (!itemData.contains(i)) {
            itemData.add(i);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes e from the set unless it is not in the exq set
    //          in which case it does nothing
    public void remove(Item i) {
        itemData.remove(i);
    }

    // EFFECTS: returns the number of elements in the exq set
    public int size() {
        return itemData.size();
    }

    // EFFECTS: returns true iff e is in the set
    public boolean contains(Item i) {
        return itemData.contains(i);
    }

//    // MODIFIES: this
//    // EFFECTS: compares two lists and returns a new list containing
//    //          the same figure(s) from both lists unless they do not
//    //          share the same figure(s) in which case it does nothing
//    public InventoryList putSameFigureInList(InventoryList list) {
//        InventoryList result = new InventoryList();
//        if (list != null) {
//            for (items i : this.itemData) {
//                if (list.itemData.contains(i)) {
//                    result.insert(i);
//                }
//            }
//        }
//        return result;
//    }

    public abstract ArrayList namesAndQuantities();

    public abstract ArrayList inStockList();


}