package ui;

import javax.swing.*;
import java.awt.*;


public class MainPanelContainer extends JPanel {

    private MainMenuPanel mainMenu = new MainMenuPanel(this);
    private StoreMenu storeMenu = new StoreMenu(this);
    private CustomerMenu customerMenu = new CustomerMenu(this);
    private StoreAddItemPanel storeAddItemPanel = new StoreAddItemPanel(this);
    private StoreRemoveItemPanel storeRemoveItemPanel = new StoreRemoveItemPanel(this);
    private StoreItemUpdatePanel storeItemUpdatePanel = new StoreItemUpdatePanel(this);
    private StoreStatsDisplayPanel storeStatsDisplayPanel = new StoreStatsDisplayPanel(this);
    private AddCustomerPanel addCustomerPanel = new AddCustomerPanel(this);
    private ViewCustomersPanel viewCustomersPanel = new ViewCustomersPanel(this);
    private RemoveCustomerPanel removeCustomerPanel = new RemoveCustomerPanel(this);
    private IndividualMenu individualMenu = new IndividualMenu(this);
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
        add(storeStatsDisplayPanel, "storeStats");
        add(addCustomerPanel, "addCustomer");
        add(viewCustomersPanel, "viewCustomers");
        add(removeCustomerPanel, "removeCustomer");
        add(individualMenu, "individualMenu");
        cl.show(this, "mainMenu");


    }
}
