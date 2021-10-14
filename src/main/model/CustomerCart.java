package model;

import java.util.ArrayList;

public class CustomerCart {
    private ArrayList<Item> cart;
    private int totalPrice;

    public CustomerCart() {
        cart = new ArrayList<Item>();
    }

    //REQUIRES: the item added to the cart must be offered by the store (in ItemList)
    //MODIFIES: this
    //EFFECTS: adds the item with the passed in name to the customers cart
    public void addToCart(Item item) {

    }

    //MODIFIES: this
    //EFFECTS: removes the item with the passed in name from the customers cart
    public void removeFromCart(String itemName) {

    }

    //EFFECTS: returns names all the items currently in the customers cart
    public String viewCart() {
        return "";
    }


    //EFFECTS: returns how many items are currently in the customers cart
    public int numberOfItemsInCart() {
        return cart.size();
    }


}
