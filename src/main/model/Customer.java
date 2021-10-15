package model;

//This class represents a single customer who will be purchasing items/services
public class Customer {
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
    public void printReceipt() {
        System.out.println("---RECEIPT---");
        System.out.println("ID: " + getCustomerID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Cart Items: " + getCart().viewCart());
    }
}
