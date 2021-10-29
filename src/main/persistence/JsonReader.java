package persistence;

import model.Item;
import model.ItemList;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads ItemList from JSON data stored in file
public class JsonReader {
    private final String source1;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source1) {
        this.source1 = source1;
    }

    // EFFECTS: reads ItemList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ItemList read() throws IOException {
        String jsonData = readFile(source1);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseStoreItems(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses ItemList from JSON object and returns it
    private ItemList parseStoreItems(JSONObject jsonObject) {
        ItemList items = new ItemList();
        addItems(items, jsonObject);
        return items;
    }

    // MODIFIES: ItemList
    // EFFECTS: parses Item from JSON object and adds them to ItemList
    private void addItems(ItemList items, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Store Items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(items, nextItem);
        }
    }

    // MODIFIES: ItemList
    // EFFECTS: parses Item from JSON object and adds it to ItemList
    private void addItem(ItemList items, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double price = jsonObject.getDouble("price");
        String description = jsonObject.getString("description");
        Item newItem = new Item(name, price, description);
        items.addItem(newItem);
    }
}
