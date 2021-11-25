package ui.storejpanels;

import model.AllCustomers;
import model.Item;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows the user to add items to the store
public class StoreAddItemPanel extends JPanel {

    private MainPanelContainer container;
    private JLabel itemNameLabel;
    private JTextField itemNameTextField;
    private JLabel itemDescriptionLabel;
    private JTextField itemDescriptionTextField;
    private JLabel itemPriceLabel;
    private JTextField itemPriceTextField;
    private ItemList storeItems;

    //EFFECTS: creates a new instance of the StoreAddItemPanel class
    public StoreAddItemPanel(MainPanelContainer container, ItemList storeItems) {
        this.storeItems = storeItems;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
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

    //MODIFIES: this
    //Creates a button that when clicked, takes the JTextField values to create a new item and add then add it to store
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

    //EFFECTS: creates a button that when clicked takes the user back to the store menu
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
