package model.saveload;

import model.inventory.InventoryList;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


// this program reads a list of inventory items from inventoryList.json
public class JsonInventoryListReader {
    static String FILENAME = "inventoryList.json";

    public static void main(String[] args) throws IOException {
        // Initialize Gson
        Gson gson = new Gson();

        // Initialize Gson's JSON reader, pointing to inventoryList.json
        JsonReader reader = new JsonReader(new FileReader(FILENAME));

        // Read from the data into an InventoryList array (InventoryList[])
        InventoryList figuresData = gson.fromJson(reader, InventoryList.class);
//        InventoryList i = figuresData[0];
//        System.out.println(i.namesAndQuantities());
//        System.out.println(Arrays.toString(figuresData));

        // Print out the inventory items  we found
        System.out.println("Here are the inventory items I found:");
//        for (InventoryList fd: figuresData) {
        System.out.println(figuresData.namesAndQuantities());
//        }
    }
}