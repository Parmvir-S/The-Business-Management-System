package model;

import java.util.ArrayList;

public class CustomerCart {
    private ArrayList<Item> cart;
    private ItemList itemList;

    public CustomerCart(ItemList storeItems) {
        cart = new ArrayList<Item>();
        this.itemList = storeItems; //might need to change this
    }

    //REQUIRES: the item added to the cart must be offered by the store (in ItemList)
    //MODIFIES: this
    //EFFECTS: adds the item with the passed in name to the customers cart
    public void addToCart(Item item) {
        for (Item storeItem: itemList.getItems()) {
            if (storeItem.getName().equals(item.getName())) {
                cart.add(storeItem);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: removes the item with the passed in name from the customers cart
    public void removeFromCart(String itemName) {
        Item itemToRemove = new Item("", 0, "");
        for (Item item: cart) {
            if (item.getName().equals(itemName)) {
                itemToRemove = item;
            }
        }
        cart.remove(itemToRemove);
    }

    //EFFECTS: returns names all the items currently in the customers cart
    public String viewCart() {
        String cartContent = "";
        for (Item item: cart) {
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
        for (Item item: cart) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
