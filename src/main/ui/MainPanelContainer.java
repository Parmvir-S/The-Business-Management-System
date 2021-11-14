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
        cl.show(this, "mainMenu");


    }
}
