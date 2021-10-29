package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;


import java.util.ArrayList;

//This class represents a customers cart
public class CustomerCart implements Writable {
    private final ArrayList<Item> cart;

    //EFFECTS: creates a new CustomerCart object with no items in it
    public CustomerCart() {
        cart = new ArrayList<>();
    }

    //EFFECTS: returns the cart
    public ArrayList<Item> getItems() {
        return cart;
    }

    //MODIFIES: this
    //EFFECTS: adds the item with the passed in name to the customers cart
    public void addToCart(Item item) {
        cart.add(item);
    }

    //MODIFIES: this
    //EFFECTS: removes the item with the passed in name from the customers cart
    public void removeFromCart(String itemName) {
        Item itemToRemove = new Item("", 0, "");
        for (Item item : cart) {
            if (item.getName().equals(itemName)) {
                itemToRemove = item;
            }
        }
        cart.remove(itemToRemove);
    }

    //EFFECTS: returns names all the items currently in the customers cart
    public String viewCart() {
        String cartContent = "";
        for (Item item : cart) {
            cartContent += item.getName() + ", ";
        }
        return cartContent;
    }


    //EFFECTS: returns how many items are currently in the customers cart
    public int numberOfItemsInCart() {
        return cart.size();
    }

    //EFFECTS: return the total price of all the items/services in the cart
    public double totalPrice() {
        double totalPrice = 0;
        for (Item item : cart) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    // EFFECTS: returns this as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("items", itemsToJson());
        return json;
    }

    // EFFECTS: returns items in cart as a JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item i : cart) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }
}
