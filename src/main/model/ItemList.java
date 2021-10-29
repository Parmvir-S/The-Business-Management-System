package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//This class represents a catalogue/ItemList that contains all items/services offered by business
public class ItemList implements Writable {
    private final ArrayList<Item> items;

    //EFFECTS: constructs an ItemList object when called
    public ItemList() {
        items = new ArrayList<>();
    }

    //EFFECTS: returns the items arraylist
    public ArrayList<Item> getItems() {
        return items;
    }

    //MODIFIES: this
    //EFFECTS: adds an item to items
    public void addItem(Item item) {
        items.add(item);
    }

    //MODIFIES: this
    //EFFECTS: removes item with itemName (argument) from items. If not found, does nothing
    public void removeItem(String itemName) {
        Item itemToRemove = new Item("", 0, "");
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                itemToRemove = item;
            }
        }
        items.remove(itemToRemove);
    }

    //REQUIRES: item that needs to be updated must be in the items (ArrayList)
    //MODIFIES: this
    //EFFECTS: updates the name, price or description for item named itemName
    public void updateItem(String itemName, String name, double price, String description) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                item.setName(name);
                item.setPrice(price);
                item.setDescription(description);
            }
        }

    }

    //EFFECTS: returns the number of items/services in items
    public int numberOfItemsInList() {
        return items.size();
    }

    //EFFECTS: returns true if item with itemName is in items. Otherwise, false
    public  Boolean isItInItems(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }


    // EFFECTS: returns this as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Store Items", itemsToJson());
        return json;
    }

    // EFFECTS: returns items in the store as a JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item i : items) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }
}
