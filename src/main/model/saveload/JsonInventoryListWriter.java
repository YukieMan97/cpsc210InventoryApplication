package model.saveload;

import com.google.gson.Gson;
import model.items.Exq;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonInventoryListWriter {
    static String FILENAME = "inventoryList.json";

    public static void main(String[] args) throws IOException {

        // Make us some inventory items to work with
//        FigureList figuresData = new FigureList();
//        figuresData.insert(Exq.KIRITO_DUAL_WIELD);
//        figuresData.insert(Exq.ALICE_SITTING);
//        System.out.println(figuresData););
////        String json = gson.toJson(figuresData);

//        System.out.println(Item.ITEM_LIST);

        // Initialize Gson Library
        Gson gson = new Gson();

        // Export the exq list to JSON
        List<String> listOfFigures = new ArrayList<>();
        for (Exq f: Exq.EXQ_LIST) {
            listOfFigures.add(f.getName());
        }

//        List<String> listOfBooks = new ArrayList<>();
//        for(Book b: Book.BOOK_LIST) {
//            listOfBooks.add(b.getTitle());
//        }

        String json1 = gson.toJson(listOfFigures);
//        String json = gson.toJson(listOfBooks);

        // Write the JSON text to inventoryList.json
        FileWriter writer = new FileWriter(FILENAME);
        writer.write(json1);
//        writer.write(json);
        writer.close();
        System.out.println("Wrote text: " + json1);
//        System.out.println("Wrote text: " + json);
    }
}