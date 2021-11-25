package ui.customerjpanels.individualcustomerpanels;

import model.AllCustomers;
import model.ItemList;
import ui.customerjpanels.AccessCustomerPanel;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows the user to view all the items in a customers cart
public class ViewItemsInCartPanel extends JPanel {

    private MainPanelContainer container;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel itemsInCartLabel;

    //EFFECTS: creates a new instance of the ViewItemsInCartPanel class
    public ViewItemsInCartPanel(MainPanelContainer container,
                                AllCustomers allCustomers, AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        itemsInCartLabel = new JLabel();
        add(itemsInCartLabel);

        JButton viewCartItemsButton = makeViewCartItemsButton();
        add(viewCartItemsButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates a button that when clicked, displays the name of every item in the customers cart
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
