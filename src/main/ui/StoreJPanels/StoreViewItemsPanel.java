package ui.StoreJPanels;

import model.AllCustomers;
import model.Item;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreViewItemsPanel extends JPanel {
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel allItems;

    public StoreViewItemsPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        allItems = new JLabel();
        add(allItems);

        JButton getAllItemsButton = makeGetAllItemsButton();
        add(getAllItemsButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

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
