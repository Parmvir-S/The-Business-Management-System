package persistence;

import model.*;


import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads ItemList from JSON data stored in file
public class JsonReaderCustomer {
    private final String source1;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderCustomer(String source1) {
        this.source1 = source1;
    }

    // EFFECTS: reads ItemList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public AllCustomers read() throws IOException {
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
    private AllCustomers parseStoreItems(JSONObject jsonObject) {
        AllCustomers customers = new AllCustomers();
        addItems(customers, jsonObject);
        return customers;
    }

    // MODIFIES: ItemList
    // EFFECTS: parses Item from JSON object and adds them to ItemList
    private void addItems(AllCustomers customers, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Customers");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(customers, nextItem);
        }
    }

    // MODIFIES: ItemList
    // EFFECTS: parses Item from JSON object and adds it to ItemList
    private void addItem(AllCustomers customers, JSONObject jsonObject) {
        int id = jsonObject.getInt("customerID");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");
        int phoneNumber = jsonObject.getInt("phoneNumber");

        ItemList items = new ItemList();
        JSONArray cartJson = jsonObject.getJSONArray("cart");
        for (Object item: cartJson) {
            JSONObject nextItem = (JSONObject) item;
            addToItems(items, nextItem);
        }

        CustomerCart cart = new CustomerCart();
        for (Item i: items.getItems()) {
            cart.addToCart(i);
        }

        Customer newCustomer = new Customer(id, name, email, phoneNumber, cart);
        customers.addCustomer(newCustomer);
    }

    public void addToItems(ItemList items, JSONObject jsonObject) {
        String itemName = jsonObject.getString("name");
        String itemDesc = jsonObject.getString("description");
        double itemPrice = jsonObject.getDouble("price");
        Item newItem = new Item(itemName,itemPrice,itemDesc);
        items.addItem(newItem);
    }
}
