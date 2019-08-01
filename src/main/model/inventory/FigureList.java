package model.inventory;


import model.items.Figure;

import java.util.ArrayList;

public class FigureList extends InventoryList {

    ArrayList<Figure> figureData = new ArrayList<>();

    // REQUIRES: a non-empty list with no duplicate figures
    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of figure names and quantities of
    //          every figure in the list
    @Override
    public ArrayList namesAndQuantities() {
        ArrayList<String> namesAndQuantitiesList = new ArrayList<>();

        for (int counter = 0; counter < figureData.size(); counter++) {
            String name = figureData.get(counter).getName();
            String quantity = (Integer.toString(figureData.get(counter).getQuantity()));
            namesAndQuantitiesList.add(name + " with " + quantity + " left.");
        }
        return namesAndQuantitiesList;
    }


    // REQUIRES: a non-empty list with no duplicates
    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of in stock figures, giving the name and quantity of
    //          each figure where the quantities are greater than zero
    @Override
    public ArrayList inStockList() {
        ArrayList<String> stockList = new ArrayList<>();

        for (int counter = 0; counter < this.figureData.size(); counter++) {
            if (this.figureData.get(counter).getQuantity() != 0) {
                stockList.add(this.figureData.get(counter).getName() + " with "
                        + (Integer.toString(this.figureData.get(counter).getQuantity())) + " left.");
            } else {
                counter++;
            }
        }
        return stockList;
    }
}
