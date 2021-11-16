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


public class MainPanelContainer extends JPanel {
    private static final String JSON_STORE_ITEMS = "./data/storeItemsData.json";
    private static final String JSON_STORE_CUSTOMERS = "./data/allCustomersData.json";
    ItemList storeItems = new ItemList();
    AllCustomers allCustomers = new AllCustomers();
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE_ITEMS);
    JsonReader jsonReader = new JsonReader(JSON_STORE_ITEMS);
    JsonWriterCustomer jsonWriterCustomer = new JsonWriterCustomer(JSON_STORE_CUSTOMERS);
    JsonReaderCustomer jsonReaderCustomer = new JsonReaderCustomer(JSON_STORE_CUSTOMERS);
    //maybe make the save and load buttons here and then add to mainmenupanel

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
    private AddItemToCartPanel addItemToCartPanel = new AddItemToCartPanel(this, storeItems, allCustomers);
    private ReceiptPanel receiptPanel = new ReceiptPanel(this, storeItems, allCustomers);
    private RemoveItemFromCartPanel removeItemFromCartPanel = new RemoveItemFromCartPanel(this, storeItems, allCustomers);
    private ViewItemsInCartPanel viewItemsInCartPanel = new ViewItemsInCartPanel(this, storeItems, allCustomers);
    private ViewTheCartTotalPanel viewTheCartTotalPanel = new ViewTheCartTotalPanel(this, storeItems, allCustomers);
    private CardLayout cl = new CardLayout();
    private GridBagConstraints gbc = new GridBagConstraints();

    public MainPanelContainer() {
        setLayout(cl);

        add(mainMenu, "mainMenu");
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
}
