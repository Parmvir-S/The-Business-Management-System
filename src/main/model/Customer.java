package model;

//This class represents a single customer who will be purchasing items/services
public class Customer {
    private int customerID;
    private String name;
    private String email;
    private int phoneNumber;
    private CustomerCart cart;

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

    //MODIFIES: this
    //EFFECTS: changes the customer ID to what the passed in value is
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    //MODIFIES: this
    //EFFECTS: changes the customer email to the passed in email
    public void setEmail(String email) {
        this.email = email;
    }

    //EFFECTS: returns the customers phone number
    public int getPhoneNumber() {
        return phoneNumber;
    }

    //MODIFIES: this
    //EFFECTS: changes the customers phone number to the phone number passed in
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //EFFECTS: returns the customers current cart of items/services
    public CustomerCart getCart() {
        return cart;
    }

    //EFFECTS: prints out a "receipt"
    public String printReceipt() {
        return "---Receipt---"
                + getCustomerID()
                + getName()
                + getEmail()
                + getPhoneNumber()
                + getCart().viewCart();
    }
}
