package ui;

import model.AllCustomers;
import model.ItemList;
import persistence.JsonReader;
import persistence.JsonReaderCustomer;
import persistence.JsonWriter;
import persistence.JsonWriterCustomer;
import ui.CustomerJPanels.*;
import ui.CustomerJPanels.IndividualCustomerPanels.*;
import ui.StoreJPanels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainPanelContainer extends JPanel {
    private static final String JSON_STORE_ITEMS = "./data/storeItemsData.json";
    private static final String JSON_STORE_CUSTOMERS = "./data/allCustomersData.json";
    ItemList storeItems = new ItemList();
    AllCustomers allCustomers = new AllCustomers();
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE_ITEMS);
    JsonReader jsonReader = new JsonReader(JSON_STORE_ITEMS);
    JsonWriterCustomer jsonWriterCustomer = new JsonWriterCustomer(JSON_STORE_CUSTOMERS);
    JsonReaderCustomer jsonReaderCustomer = new JsonReaderCustomer(JSON_STORE_CUSTOMERS);

    private MainMenuPanel mainMenu = new MainMenuPanel(this, storeItems, allCustomers);
    private StoreMenu storeMenu = new StoreMenu(this, storeItems, allCustomers);
    private CustomerMenu customerMenu = new CustomerMenu(this, storeItems, allCustomers);
    private StoreAddItemPanel storeAddItemPanel = new StoreAddItemPanel(this, storeItems, allCustomers);
    private StoreRemoveItemPanel storeRemoveItemPanel = new StoreRemoveItemPanel(this, storeItems, allCustomers);
    private StoreItemUpdatePanel storeItemUpdatePanel = new StoreItemUpdatePanel(this, storeItems, allCustomers);
    private StoreStatsDisplayPanel storeStatsDisplayPanel = new StoreStatsDisplayPanel(this, storeItems, allCustomers);
    private StoreViewItemsPanel storeViewItemsPanel = new StoreViewItemsPanel(this, storeItems, allCustomers);
    private AddCustomerPanel addCustomerPanel = new AddCustomerPanel(this, storeItems, allCustomers);
    private ViewCustomersPanel viewCustomersPanel = new ViewCustomersPanel(this, storeItems, allCustomers);
    private RemoveCustomerPanel removeCustomerPanel = new RemoveCustomerPanel(this, storeItems, allCustomers);
    private IndividualMenu individualMenu = new IndividualMenu(this, storeItems, allCustomers);
    private AccessCustomerPanel accessCustomerPanel = new AccessCustomerPanel(this, storeItems, allCustomers);
    private AddItemToCartPanel addItemToCartPanel = new AddItemToCartPanel(this, storeItems, allCustomers, accessCustomerPanel);
    private ReceiptPanel receiptPanel = new ReceiptPanel(this, storeItems, allCustomers, accessCustomerPanel);
    private RemoveItemFromCartPanel removeItemFromCartPanel = new RemoveItemFromCartPanel(this, storeItems, allCustomers, accessCustomerPanel);
    private ViewItemsInCartPanel viewItemsInCartPanel = new ViewItemsInCartPanel(this, storeItems, allCustomers, accessCustomerPanel);
    private ViewTheCartTotalPanel viewTheCartTotalPanel = new ViewTheCartTotalPanel(this, storeItems, allCustomers, accessCustomerPanel);
    private CardLayout cl = new CardLayout();
    private GridBagConstraints gbc = new GridBagConstraints();

    public MainPanelContainer() {
        setLayout(cl);
        gbc.insets = new Insets(10, 10, 10, 10);

        add(mainMenu, "mainMenu");

        mainMenu.add(makeSaveButton(), gbc);
        mainMenu.add(makeLoadButton(), gbc);

        add(storeMenu, "storeMenu");
        add(customerMenu, "customerMenu");
        add(storeAddItemPanel, "storeAddItem");
        add(storeRemoveItemPanel, "storeRemoveItem");
        add(storeItemUpdatePanel, "storeItemUpdate");
        add(storeViewItemsPanel, "viewItems");
        add(storeStatsDisplayPanel, "storeStats");
        add(addCustomerPanel, "addCustomer");
        add(viewCustomersPanel, "viewCustomers");
        add(removeCustomerPanel, "removeCustomer");
        add(individualMenu, "individualMenu");
        add(accessCustomerPanel, "accessPanel");
        add(addItemToCartPanel, "addToCart");
        add(receiptPanel, "viewReceipt");
        add(removeItemFromCartPanel, "removeFromCart");
        add(viewItemsInCartPanel,"viewItemsInCart");
        add(viewTheCartTotalPanel, "viewCartTotal");
        cl.show(this, "mainMenu");
    }

    public JButton makeSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(storeItems);
                    jsonWriter.close();

                    jsonWriterCustomer.open();
                    jsonWriterCustomer.write(allCustomers);
                    jsonWriterCustomer.close();
                    System.out.println("Store Data Was Saved To " + JSON_STORE_ITEMS + " and " + JSON_STORE_CUSTOMERS);
                } catch (FileNotFoundException error) {
                    System.out.println("Unable to write to file: " + JSON_STORE_ITEMS + " or " + JSON_STORE_CUSTOMERS);
                }
            }
        });
        return saveButton;
    }

    public JButton makeLoadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    storeItems = jsonReader.read();
                    allCustomers = jsonReaderCustomer.read();
                    System.out.println("Loaded from " + JSON_STORE_ITEMS + " and " + JSON_STORE_CUSTOMERS);
                } catch (IOException error) {
                    System.out.println("Unable to read from file: " + JSON_STORE_ITEMS + " or " + JSON_STORE_CUSTOMERS);
                }
            }
        });
        return loadButton;
    }
}
