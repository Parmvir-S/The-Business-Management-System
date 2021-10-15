package ui;

import model.*;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final ItemList storeItems;
    private final AllCustomers allCustomers;

    public UserInterface() {
        scanner = new Scanner(System.in);
        storeItems = new ItemList();
        allCustomers = new AllCustomers();
    }

    public void start() {
        while (true) {
            System.out.println("Store - Store Options");
            System.out.println("Customer - Customer Options");
            System.out.println("Quit - Exit The Application");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("quit")) {
                break;
            }

            if (userInput.equals("store")) {
                storeOptions();
            } else if (userInput.equals("customer")) {
                customerOptions();
            } else {
                System.out.println("Invalid Entry - Try Again");
            }
        }
    }

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

    public void viewItems() {
        storeItems.viewItems();
    }

    public void addItemsToStore() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Item Price: ");
        Double price = scanner.nextDouble();
        System.out.print("Item Description: ");
        String description = scanner.nextLine();

        Item storeItem = new Item(name, price, description);
        storeItems.addItem(storeItem);
    }

    public void removeItemsFromStore() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        storeItems.removeItem(name);
    }

    public void updateItemInStore() {
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("New Name: ");
        String newName = scanner.nextLine();
        System.out.print("New Price: ");
        Double newPrice = scanner.nextDouble();
        System.out.print("New Description: ");
        String newDescription = scanner.nextLine();

        storeItems.updateItem(itemName, newName, newPrice, newDescription);
    }

    public void stats() {
        int totalCustomers = allCustomers.getTotalNumberOfCustomers();
        double totalSales = allCustomers.getTotalSales();
        System.out.println("TOTAL CUSTOMERS: " + totalCustomers);
        System.out.println("TOTAL SALES: " + totalSales);
    }

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

    public void viewCustomers() {
        System.out.println("ALL CUSTOMERS:");
        String allCustomerNames = allCustomers.allCustomerNames();
        System.out.println(allCustomerNames);
    }

    public void accessCustomer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        for (Customer customer : allCustomers.getAllCustomers()) {
            if (customer.getName().equals(name)) {
                individualCustomerOptions(name);
            }
        }
    }

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

    public void printReceipt(String name) {
        allCustomers.getCustomer(name).printReceipt();
    }

    public void addItemToCart(String customerName) {
        System.out.print("Name: ");
        String itemName = scanner.nextLine();
        allCustomers.getCustomer(customerName).getCart().addToCart(itemName);
    }

    public void removeItemFromCart(String customerName) {
        System.out.print("Name: ");
        String itemName = scanner.nextLine();
        allCustomers.getCustomer(customerName).getCart().removeFromCart(itemName);
    }

    public void viewCartItems(String customerName) {
        System.out.println("---CART ITEMS---");
        String cartItems = allCustomers.getCustomer(customerName).getCart().viewCart();
        System.out.println(cartItems);
    }

    public void getTotalCartCost(String customerName) {
        System.out.println("---TOTAL---");
        double total = allCustomers.getCustomer(customerName).getCart().totalPrice();
        System.out.println(total);
    }

    public void removeCustomer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        allCustomers.removeCustomer(name);
    }
}
