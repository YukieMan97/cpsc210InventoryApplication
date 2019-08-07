package ui;

import model.items.Figure;
import model.items.Item;
import ui.exceptions.InvalidChangeException;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidNameException;
import ui.exceptions.InvalidTitleException;

import java.util.ArrayList;

public class SearchFigure {
    private SearchItemMethods sim;
    private ArrayList<Figure> figureArrayList;

    public SearchFigure(SearchItemMethods sim) {
        this.sim = sim;
        figureArrayList = Figure.FIGURE_LIST;
    }

    // EFFECTS: Searches for the desired figure that is within the system.
    //          Throws InvalidNameException when the desired figure is not found.
    public void getFigureData(String figureName) throws InvalidNameException,
            InvalidTitleException, InvalidInputException, InvalidChangeException {
        for (Figure f : figureArrayList) {
            if (f.containsNameOrTitle(figureName)) {

                String information = f.getInformation();

                System.out.println("Item(s) found! " + information);
                toDoWithItem(f);
                return;
            }
        }
        throw new InvalidNameException();
    }

    public void toDoWithItem(Item item) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        ToDoWithItem tdwi = new ToDoWithItem(sim);
        tdwi.toDoWithItem(item);
    }

    public void endSearch() {
        sim.endSearch();
    }
}
