package ui.CustomerJPanels.IndividualCustomerPanels;

import model.AllCustomers;
import model.ItemList;
import ui.CustomerJPanels.AccessCustomerPanel;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewItemsInCartPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel itemsInCartLabel;


    public ViewItemsInCartPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers, AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        itemsInCartLabel = new JLabel();
        add(itemsInCartLabel);

        JButton viewCartItemsButton = makeViewCartItemsButton();
        add(viewCartItemsButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    public JButton makeViewCartItemsButton() {
        JButton viewCartItemsButton = new JButton("View Cart Items");
        viewCartItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cartItems = allCustomers.getCustomer(accessCustomerPanel.getUserName()).getCart().viewCart();
                itemsInCartLabel.setText(cartItems);
            }
        });
        return viewCartItemsButton;
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
