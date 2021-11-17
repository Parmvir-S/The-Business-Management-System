package ui.CustomerJPanels.IndividualCustomerPanels;

import model.AllCustomers;
import model.ItemList;
import ui.CustomerJPanels.AccessCustomerPanel;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveItemFromCartPanel extends JPanel {
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel itemToRemoveLabel;
    private JTextField itemToRemoveTextField;

    public RemoveItemFromCartPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers, AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

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
