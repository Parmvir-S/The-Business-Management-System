package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.lang.reflect.Array;
import java.util.ArrayList;

//This class represents a single customer who will be purchasing items/services
public class Customer implements Writable {
    private final int customerID;
    private String name;
    private final String email;
    private final int phoneNumber;
    private final CustomerCart cart;

    public Customer(int customerID, String name, String email, int phoneNumber, CustomerCart cart) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cart = cart;
    }

    //EFFECTS: returns the customer ID
    public int getCustomerID() {
        return customerID;
    }

    //EFFECTS: returns the customer name
    public String getName() {
        return name;
    }

    //MODIFIES: this
    //EFFECTS: changes the customer name to the passed in name
    public void setName(String name) {
        this.name = name;
    }

    //EFFECTS: returns the customers email
    public String getEmail() {
        return email;
    }

    //EFFECTS: returns the customers phone number
    public int getPhoneNumber() {
        return phoneNumber;
    }

    //EFFECTS: returns the customers current cart of items/services
    public CustomerCart getCart() {
        return cart;
    }

    //EFFECTS: prints out a "receipt"
    public ArrayList<String> getReceipt() {
        ArrayList<String> receiptInfo = new ArrayList<>();
        receiptInfo.add("---RECEIPT---");
        receiptInfo.add("ID: " + getCustomerID());
        receiptInfo.add("Name: " + getName());
        receiptInfo.add("Email: " + getEmail());
        receiptInfo.add("Phone Number: " + getPhoneNumber());
        receiptInfo.add("Cart Items: " + getCart().viewCart());
        receiptInfo.add("Total: " + getCart().totalPrice());
        return receiptInfo;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("customerID", customerID);
        json.put("name", name);
        json.put("email", email);
        json.put("phoneNumber", phoneNumber);
        json.put("cart", customersToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray customersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item i : cart.getItems()) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }
}
