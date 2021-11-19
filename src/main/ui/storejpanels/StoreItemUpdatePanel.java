package ui.storejpanels;

import model.AllCustomers;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows the user to update items in the store
public class StoreItemUpdatePanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    private JLabel itemToUpdateNameLabel;
    private JTextField itemToUpdateNameTextField;
    private JLabel itemNameLabel;
    private JTextField itemNameTextField;
    private JLabel itemDescriptionLabel;
    private JTextField itemDescriptionTextField;
    private JLabel itemPriceLabel;
    private JTextField itemPriceTextField;

    //EFFECTS: creates a new instance of the StoreItemUpdatePanel class
    public StoreItemUpdatePanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        itemToUpdateNameLabel = new JLabel("Name Of Item You Want To Update");
        itemToUpdateNameTextField = new JTextField(20);

        itemNameLabel = new JLabel(" New Name");
        itemNameTextField = new JTextField(20);

        itemDescriptionLabel = new JLabel("New Description");
        itemDescriptionTextField = new JTextField(20);
        itemPriceLabel = new JLabel("New Price");
        itemPriceTextField = new JTextField(20);

        add(itemToUpdateNameLabel);
        add(itemToUpdateNameTextField);
        add(itemNameLabel);
        add(itemNameTextField);
        add(itemDescriptionLabel);
        add(itemDescriptionTextField);
        add(itemPriceLabel);
        add(itemPriceTextField);

        JButton updateItemButton = makeUpdateButton();
        add(updateItemButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that when clicked takes the JTextField values to update an existing item in the store
    public JButton makeUpdateButton() {
        JButton updateItemButton = new JButton("Update Item");
        updateItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemToUpdateName = itemToUpdateNameTextField.getText();
                String name = itemNameTextField.getText();
                String description = itemDescriptionTextField.getText();
                Double price = Double.valueOf(itemPriceTextField.getText());
                storeItems.updateItem(itemToUpdateName, name, price, description);
            }
        });
        return updateItemButton;
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
