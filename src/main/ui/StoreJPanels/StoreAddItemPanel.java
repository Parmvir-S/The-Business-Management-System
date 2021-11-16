package ui.StoreJPanels;

import model.AllCustomers;
import model.Item;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreAddItemPanel extends JPanel {

    private MainPanelContainer container;
    private JLabel itemNameLabel;
    private JTextField itemNameTextField;
    private JLabel itemDescriptionLabel;
    private JTextField itemDescriptionTextField;
    private JLabel itemPriceLabel;
    private JTextField itemPriceTextField;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    public StoreAddItemPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        itemNameLabel = new JLabel("Name");
        itemNameTextField = new JTextField(20);

        itemDescriptionLabel = new JLabel("Description");
        itemDescriptionTextField = new JTextField(20);
        itemPriceLabel = new JLabel("Price");
        itemPriceTextField = new JTextField(20);

        add(itemNameLabel);
        add(itemNameTextField);
        add(itemDescriptionLabel);
        add(itemDescriptionTextField);
        add(itemPriceLabel);
        add(itemPriceTextField);
        JButton addItemToStoreButton = makeAddItemToStoreButton();
        add(addItemToStoreButton);
        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    public JButton makeAddItemToStoreButton() {
        JButton addItemToStoreButton = new JButton("Add Item");
        addItemToStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = itemNameTextField.getText();
                String description = itemDescriptionTextField.getText();
                Double price = Double.valueOf(itemPriceTextField.getText());
                Item storeItem = new Item(name, price, description);
                storeItems.addItem(storeItem);
            }
        });
        return addItemToStoreButton;
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
