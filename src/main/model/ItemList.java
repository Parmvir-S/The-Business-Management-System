package model;

import java.util.ArrayList;

//This class represents a catalogue/ItemList that contains all items/services offered by business
public class ItemList {
    private ArrayList<Item> items;

    //EFFECTS: constructs an ItemList object when called
    public ItemList() {
        items = new ArrayList<Item>();
    }

    //MODIFIES: this
    //EFFECTS: adds an item to items
    public void addItem(Item item) {
        items.add(item);
    }

    //MODIFIES: this
    //EFFECTS: removes item with itemName (argument) from items. If not found, does nothing
    public void removeItem(String itemName) {
        Item itemToRemove = new Item("", 0,"");
        for (Item item: items) {
            if (item.getName().equals(itemName)) {
                itemToRemove = item;
            }
        }
        items.remove(itemToRemove);
    }

    //EFFECTS: print all items/services in items currently
    public void viewItems() {
        for (Item item: items) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
            System.out.println(item.getDescription());
            System.out.println("==========================");
        }
    }

    //REQUIRES: item that needs to be updated must be in the items (ArrayList)
    //MODIFIES: this
    //EFFECTS: updates the name, price or description for item named itemName
    public void updateItem(String itemName, String name, double price, String description) {
        for (Item item: items) {
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
    public Boolean isItInItems(String itemName) {
        for (Item item: items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }


}
