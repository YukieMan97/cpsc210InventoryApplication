package model.inventory;


import model.items.Figure;

import java.util.ArrayList;

public class FigureList extends InventoryList {

    public FigureList() {
    }

    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of figure names and quantities of
    //          every figure in the list
    public ArrayList figureNamesAndQuantities(ArrayList<Figure> figureArrayList) {
        ArrayList<String> namesAndQuantitiesList = new ArrayList<>();

        for (int counter = 0; counter < figureArrayList.size(); counter++) {
            String name = figureArrayList.get(counter).getName();
            String quantity = (Integer.toString(figureArrayList.get(counter).getQuantity()));
            namesAndQuantitiesList.add(name + " with " + quantity + " left.");
        }
        return namesAndQuantitiesList;
    }

    // MODIFIES: this list by making a new list of strings (item names and quantities)
    // EFFECTS: returns a list of in stock figures, giving the name and quantity of
    //          each stock where the quantities are greater than zero
    public ArrayList<String> inStockFigureList(ArrayList<Figure> figureArrayList) {
        ArrayList<String> stockList = new ArrayList<>();

        for (int counter = 0; counter < figureArrayList.size(); counter++) {
            if (figureArrayList.get(counter).getQuantity() != 0) {
                stockList.add(figureArrayList.get(counter).getName() + " with "
                        + (Integer.toString(figureArrayList.get(counter).getQuantity())) + " left.");
            } else {
                counter++;
            }
        }
        return stockList;
    }
}

