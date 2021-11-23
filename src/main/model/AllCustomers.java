package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// This class is represents all customers that a store/business has
public class AllCustomers implements Writable {
    private final ArrayList<Customer> customers;

    //EFFECTS: generates a new AllCustomers object with zero customers
    public AllCustomers() {
        customers = new ArrayList<>();
    }

    //REQUIRES: Customer being searched should be in customers - might change this method
    //EFFECTS: returns customer with given name if found in customers
    public Customer getCustomer(String name) {
        Customer find = customers.get(0);
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                find = customer;
            }
        }
        return find;
    }

    //MODIFIES: this
    //EFFECTS: adds a customer to the customers list
    public void addCustomer(Customer customer) {
        customers.add(customer);
        EventLog.getInstance().logEvent(new Event("Customer " + customer.getName() + " was added to customers"));
    }

    //MODIFIES: this
    //EFFECTS: removes a customer of the given name from the customers list
    public void removeCustomer(String customerName) {
        Customer customerToRemove = new Customer(0, "", "", 0, new CustomerCart());
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                customerToRemove = customer;
            }
        }
        customers.remove(customerToRemove);
        EventLog.getInstance().logEvent(new Event("Customer " + customerToRemove.getName() + " was removed"));
    }

    //EFFECTS: returns the customers list
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    //EFFECTS: returns the total number of customers
    public int getTotalNumberOfCustomers() {
        return customers.size();
    }

    //EFFECTS: returns the total sales of the store
    public double getTotalSales() {
        double total = 0;
        for (Customer customer : customers) {
            total += customer.getCart().totalPrice();
        }
        return total;
    }

    //EFFECTS: returns the names of all the customers in the customers list
    public String allCustomerNames() {
        String customerNames = "";
        for (Customer customer : customers) {
            customerNames += customer.getName() + " - ";
        }
        return customerNames;
    }

    // EFFECTS: returns this as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Customers", customersToJson());
        return json;
    }

    // EFFECTS: returns customers in this AllCustomers list as a JSON array
    private JSONArray customersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Customer c : customers) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}
