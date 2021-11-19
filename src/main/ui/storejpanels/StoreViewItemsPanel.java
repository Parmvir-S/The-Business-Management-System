package ui.storejpanels;

import model.AllCustomers;
import model.Item;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//This class displays all items currently in the store
public class StoreViewItemsPanel extends JPanel {
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel allItems;

    //EFFECTS: creates new instance of the StoreViewItemsPanel class
    public StoreViewItemsPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        allItems = new JLabel();
        add(allItems);

        JButton getAllItemsButton = makeGetAllItemsButton();
        add(getAllItemsButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates button that when clicked displays all items currently in the store
    public JButton makeGetAllItemsButton() {
        JButton getAllItemsButton = new JButton("View All Items");
        getAllItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Item> view = storeItems.getItems();
                String itemViewOutput = "";
                for (Item item: view) {
                    String itemName = item.getName();
                    String itemDescription = item.getDescription();
                    Double itemPrice = item.getPrice();
                    itemViewOutput += "Name: " + itemName + ", Description: " + itemDescription + ", Price: "
                            + itemPrice;
                }
                allItems.setText(itemViewOutput);
            }
        });
        return getAllItemsButton;
    }

    //EFFECTS: creates button that when clicked takes the user back to the store menu
    public JButton makeGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeMenu");
            }
        });
        return goBackButton;
    }
}
