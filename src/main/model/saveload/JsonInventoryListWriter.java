package model.saveload;

import model.items.Exq;
import model.inventory.FigureList;
import model.inventory.InventoryList;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonInventoryListWriter {
    static String FILENAME = "inventoryList.json";

    public static void main(String[] args) throws IOException {

        // Make us some inventory items to work with
        InventoryList figuresData = new FigureList();
        figuresData.insert(Exq.KIRITO_DUAL_WIELD);
        figuresData.insert(Exq.ALICE_SITTING);

        System.out.println(figuresData.namesAndQuantities());

        // Initialize Gson Library
        Gson gson = new Gson();

        // Export the books list to JSON
        String json = gson.toJson(figuresData);

        // Write the JSON text to inventoryList.json
        FileWriter writer = new FileWriter(FILENAME);
        writer.write(json);
        writer.close();
        System.out.println("Wrote text: " + json);
    }
}