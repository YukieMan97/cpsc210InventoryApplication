package model.saveload;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.items.Exq;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// this program reads a list of inventory items from inventoryList.json
public class JsonInventoryListReader {
    static String FILENAME = "inventoryList.json";

    public static void main(String[] args) throws IOException {
        // Initialize Gson
        Gson gson = new Gson();

        // Initialize Gson's JSON reader, pointing to inventoryList.json
        JsonReader reader = new JsonReader(new FileReader(FILENAME));

        // Read from the data into an InventoryList array (InventoryList[])
        ArrayList<Exq> figuresData = gson.fromJson(reader, ArrayList.class);

        // Print out the inventory items  we found
        System.out.println("Here are the EXQ figures found within the system:");
        System.out.println(figuresData);
//        }
    }
}