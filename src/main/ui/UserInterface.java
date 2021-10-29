package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//This is the UI Class - where all the console based interaction will occur
public class UserInterface {

    private static final String JSON_STORE = "./data/app.json";
    private  Scanner scanner;
    private  ItemList storeItems;
    private  AllCustomers allCustomers;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public UserInterface() {
        scanner = new Scanner(System.in);
        storeItems = new ItemList();
        allCustomers = new AllCustomers();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //EFFECTS: The main method that links all other methods together
    public void start() {
        while (true) {
            System.out.println("Store - Store Options");
            System.out.println("Customer - Customer Options");
            System.out.println("Save - Save Store Data to File");
            System.out.println("Load - Load Store Data to File");
            System.out.println("Quit - Exit The Application");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("quit")) {
                break;
            }

            if (userInput.equals("store")) {
                storeOptions();
            } else if (userInput.equals("customer")) {
                customerOptions();
            } else if (userInput.equals("save")) {
                saveStoreData();
            } else if (userInput.equals("load")) {
                loadStoreData();
            } else {
                System.out.println("Invalid Entry - Try Again");
            }
        }
    }

    //EFFECTS: saves the store data to file
    public void saveStoreData() {
        try {
            jsonWriter.open();
            jsonWriter.write(storeItems);
            jsonWriter.close();
            System.out.println("Store Data Was Saved To " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to to write to file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: loads store data from file
    public void loadStoreData() {
        try {
            storeItems = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS: provides the store options
    public void storeOptions() {
        while (true) {
            System.out.println("View - View Items In Store");
            System.out.println("Add - Add Items To Store");
            System.out.println("Remove - Remove Items From Store");
            System.out.println("Update - Update Items In Store");
            System.out.println("Stats - All Time Stats");
            System.out.println("Quit - Exit Store Menu");
            String userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals("quit")) {
                break;
            }

            if (userInput.equals("view")) {
                viewItems();
            } else if (userInput.equals("add")) {
                addItemsToStore();
            } else if (userInput.equals("remove")) {
                removeItemsFromStore();
            } else if (userInput.equals("update")) {
                updateItemInStore();
            } else if (userInput.equals("stats")) {
                stats();
            }
        }
    }

    //EFFECTS: allows user to view store items
    public void viewItems() {
        ArrayList<Item> view = storeItems.getItems();
        System.out.println(("---STORE ITEMS---"));
        for (Item item: view) {
            System.out.println("ITEM NAME: " + item.getName());
            System.out.println("ITEM DESCRIPTION: " + item.getDescription());
            System.out.println("ITEM PRICE: " + item.getPrice());
            System.out.println("");
        }
    }

    //MODIFIES: this
    //EFFECTS: allows user to add store items
    public void addItemsToStore() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();

        System.out.print("Item Description: ");
        String description = scanner.nextLine();

        System.out.print("Item Price: ");
        Double price = scanner.nextDouble();

        Item storeItem = new Item(name, price, description);
        storeItems.addItem(storeItem);
    }

    //MODIFIES: this
    //EFFECTS: allows user to remove store items
    public void removeItemsFromStore() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        storeItems.removeItem(name);
    }

    //MODIFIES: this
    //EFFECTS: allows user to update store items
    public void updateItemInStore() {
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();

        System.out.print("New Name: ");
        String newName = scanner.nextLine();

        System.out.print("New Description: ");
        String newDescription = scanner.nextLine();

        System.out.print("New Price: ");
        Double newPrice = scanner.nextDouble();


        storeItems.updateItem(itemName, newName, newPrice, newDescription);
    }

    //EFFECTS: allows user to view store stats
    public void stats() {
        int totalCustomers = allCustomers.getTotalNumberOfCustomers();
        double totalSales = allCustomers.getTotalSales();
        System.out.println("TOTAL CUSTOMERS: " + totalCustomers);
        System.out.println("TOTAL SALES: " + totalSales);
    }

    //EFFECTS: gives the customer options menu
    public void customerOptions() {
        while (true) {
            System.out.println("Create - Create Customer");
            System.out.println("View - View All Customers");
            System.out.println("Remove - Remove Customer");
            System.out.println("Access - Access Customer");
            System.out.println("Quit - Exit Customer Menu");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("quit")) {
                break;
            }

            if (userInput.equals("create")) {
                createCustomer();
            } else if (userInput.equals("view")) {
                viewCustomers();
            } else if (userInput.equals("remove")) {
                removeCustomer();
            } else if (userInput.equals("access")) {
                accessCustomer();
            }
        }
    }

    //MODIFIES: this
    //creates a new customer
    public void createCustomer() {
        Random random = new Random();
        int customerID = random.nextInt();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        int phoneNumber = scanner.nextInt();
        CustomerCart cart = new CustomerCart(storeItems);

        Customer customer = new Customer(customerID, name, email, phoneNumber, cart);
        allCustomers.addCustomer(customer);
    }

    //EFFECTS: returns all customers
    public void viewCustomers() {
        System.out.println("ALL CUSTOMERS:");
        String allCustomerNames = allCustomers.allCustomerNames();
        System.out.println(allCustomerNames);
    }

    //EFFECTS: allows access to an individual customers menu
    public void accessCustomer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        for (Customer customer : allCustomers.getAllCustomers()) {
            if (customer.getName().equals(name)) {
                individualCustomerOptions(name);
            }
        }
    }

    //EFFECTS: gives the individual customer menu
    public void individualCustomerOptions(String name) {
        while (true) {
            System.out.println("Add - Add Items To Cart");
            System.out.println("Remove - Remove Items From Cart");
            System.out.println("View - View Items In Cart");
            System.out.println("Total - View The Total Price So Far");
            System.out.println("Print - Print Receipt");
            System.out.println("Quit - Exit to the Customer Options");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("quit")) {
                break;
            }

            if (userInput.equals("add")) {
                addItemToCart(name);
            } else if (userInput.equals("remove")) {
                removeItemFromCart(name);
            } else if (userInput.equals("view")) {
                viewCartItems(name);
            } else if (userInput.equals("total")) {
                getTotalCartCost(name);
            } else if (userInput.equals("print")) {
                printReceipt(name);
            }
        }
    }

    //EFFECTS: allows user to print receipt
    public void printReceipt(String name) {
        ArrayList<String> receiptInfo = allCustomers.getCustomer(name).getReceipt();
        for (String info: receiptInfo) {
            System.out.println(info);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds item to cart
    public void addItemToCart(String customerName) {
        System.out.print("Name: ");
        String itemName = scanner.nextLine();
        allCustomers.getCustomer(customerName).getCart().addToCart(itemName);
    }

    //MODIFIES: this
    //EFFECTS: adds item from cart
    public void removeItemFromCart(String customerName) {
        System.out.print("Name: ");
        String itemName = scanner.nextLine();
        allCustomers.getCustomer(customerName).getCart().removeFromCart(itemName);
    }

    //EFFECTS: view items in cart
    public void viewCartItems(String customerName) {
        System.out.println("---CART ITEMS---");
        String cartItems = allCustomers.getCustomer(customerName).getCart().viewCart();
        System.out.println(cartItems);
    }

    //EFFECTS: view cart total
    public void getTotalCartCost(String customerName) {
        System.out.println("---TOTAL---");
        double total = allCustomers.getCustomer(customerName).getCart().totalPrice();
        System.out.println(total);
    }

    //MODIFIES: this
    //EFFECTS: removes customer from allCustomers
    public void removeCustomer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        allCustomers.removeCustomer(name);
    }
}
