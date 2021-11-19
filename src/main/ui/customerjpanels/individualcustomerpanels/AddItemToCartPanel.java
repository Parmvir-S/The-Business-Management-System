package ui.customerjpanels.individualcustomerpanels;

import model.AllCustomers;
import model.Item;
import model.ItemList;
import ui.customerjpanels.AccessCustomerPanel;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows a customer to add items to his/her cart
public class AddItemToCartPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel itemToAddNameLabel;
    private JTextField itemToAddNameTextField;
    private AccessCustomerPanel accessCustomerPanel;

    //EFFECTS: creates a new instance of the AddItemToCartPanel class
    public AddItemToCartPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers,
                              AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        itemToAddNameLabel = new JLabel("Item Name:");
        itemToAddNameTextField = new JTextField(20);

        add(itemToAddNameLabel);
        add(itemToAddNameTextField);

        JButton addItemToCartButton = makeAddItemToCartButton();
        add(addItemToCartButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that when clicked, checks if the entered JTextField value matches a name in storeItems.
    //         If true then add item to cart. Otherwise, do not add.
    public JButton makeAddItemToCartButton() {
        JButton addItemToCartButton = new JButton("Add");
        addItemToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemToAddNameTextField.getText();

                Item item1 = null;
                for (Item i: storeItems.getItems()) {
                    if (i.getName().equals(itemName)) {
                        item1 = i;
                    }
                }
                if (item1 != null) {
                    allCustomers.getCustomer(accessCustomerPanel.getUserName()).getCart().addToCart(item1);
                }
            }
        });
        return addItemToCartButton;
    }

    //EFFECTS: creates a button that when clicked takes the user back to the individual menu
    public JButton makeGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "individualMenu");
            }
        });
        return goBackButton;
    }

}
