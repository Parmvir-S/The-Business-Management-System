package ui.customerjpanels.individualcustomerpanels;

import model.AllCustomers;
import model.ItemList;
import ui.customerjpanels.AccessCustomerPanel;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows a user to remove an item from his/her cart
public class RemoveItemFromCartPanel extends JPanel {
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel itemToRemoveLabel;
    private JTextField itemToRemoveTextField;

    //EFFECTS: creates a new instance of the RemoveItemFromCartPanel class
    public RemoveItemFromCartPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers,
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

        itemToRemoveLabel = new JLabel("Item Name:");
        itemToRemoveTextField = new JTextField(20);
        add(itemToRemoveLabel);
        add(itemToRemoveTextField);

        JButton removeItemButton = makeRemoveItemButton();
        add(removeItemButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that when clicked, removes the item with the entered name from the customers cart
    public JButton makeRemoveItemButton() {
        JButton removeItemButton = new JButton("Remove");
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemToRemoveTextField.getText();
                allCustomers.getCustomer(accessCustomerPanel.getUserName()).getCart().removeFromCart(itemName);
            }
        });
        return removeItemButton;
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
