package ui.CustomerJPanels;

import model.AllCustomers;
import model.Customer;
import model.ItemList;
import ui.MainMenuJPanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This displays the panel that allows the user to access a specific customer
public class AccessCustomerPanel extends JPanel {
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel accessCustomerNameLabel;
    private JTextField accessCustomerNameTextField;
    private String userName;

    //EFFECTS: creates a new instance of the AccessCustomerPanel class
    public AccessCustomerPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: this initializes the JPanel
    public void initialize() {
        setBackground(Color.cyan);

        accessCustomerNameLabel = new JLabel("Customer Name:");
        accessCustomerNameTextField = new JTextField(20);

        add(accessCustomerNameLabel);
        add(accessCustomerNameTextField);

        JButton accessButton = makeAccessButton();
        add(accessButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates a button that when clicked, checks if the name is in the customers list. If true
    //         redirects the user to that customers individual menu panel. If false, then it doesn't redirect
    public JButton makeAccessButton() {
        JButton accessButton = new JButton("Access");
        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = accessCustomerNameTextField.getText();
                for (Customer customer : allCustomers.getAllCustomers()) {
                    if (customer.getName().equals(name)) {
                        userName = name;
                        CardLayout cardLayout = (CardLayout) container.getLayout();
                        cardLayout.show(container, "individualMenu");
                    }
                }
            }
        });
        return accessButton;
    }

    //EFFECTS: return the entered customer name
    public String getUserName() {
        return this.userName;
    }

    //Creates a button that when clicked redirects the user to the customer menu panel
    public JButton makeGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "customerMenu");
            }
        });
        return goBackButton;
    }
}
