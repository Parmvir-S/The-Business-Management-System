package ui;

import model.Customer;
import model.Item;
import model.ItemList;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private ItemList storeItems;
//    private Customer customer;

    public UserInterface() {
        scanner = new Scanner(System.in);
        storeItems = new ItemList();
    }

    public void start() {
        while (true) {
            System.out.println("Store - Add/View/Update/Delete Store Items");
            System.out.println("Customer - Add/View/Update/Delete Items In Customer Cart");
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
        System.out.println("View - View Items In Store");
        System.out.println("Add - Add Items To Store");
        System.out.println("Remove - Remove Items From Store");
        System.out.println("Update - Update Items In Store");
        System.out.println("Stats - All Time Stats");
        System.out.println("Quit - Exit Store Menu");
        String userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("quit")) {
            start();
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
        } else {
            System.out.println("Invalid Entry - Try Again");
        }
    }

    public void viewItems() {
        storeItems.viewItems();
        storeOptions();
    }

    public void addItemsToStore() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Item Price: ");
        Double price = Double.valueOf(scanner.nextLine());
        System.out.print("Item Description: ");
        String description = scanner.nextLine();
        System.out.println("");

        Item storeItem = new Item(name, price, description);
        storeItems.addItem(storeItem);
        storeOptions();
    }

    public void removeItemsFromStore() {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        storeItems.removeItem(name);
        System.out.println("");
        storeOptions();
    }

    public void updateItemInStore() {
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("New Name: ");
        String newName = scanner.nextLine();
        System.out.print("New Price: ");
        Double newPrice = Double.valueOf(scanner.nextLine());
        System.out.print("New Description: ");
        String newDescription = scanner.nextLine();
        System.out.println("");

        storeItems.updateItem(itemName, newName, newPrice, newDescription);
        storeOptions();
    }

    public void stats() {
        System.out.println("STILL NEED TO DO THIS");
        System.out.println("");
        storeOptions();
    }

    public void customerOptions() {
        System.out.println();
        storeOptions();
    }
}
