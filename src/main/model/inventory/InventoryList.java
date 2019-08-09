package model.inventory;

import model.items.Item;

import java.util.ArrayList;

public abstract class InventoryList {

    private ArrayList<Item> itemData = new ArrayList<>();

    public InventoryList() {
    }

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
}