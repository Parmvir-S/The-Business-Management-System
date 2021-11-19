package ui.MainMenuJPanels;

import model.AllCustomers;
import model.ItemList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class displays the customer menu which leads to specific tasks the user can perform
public class CustomerMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    //EFFECTS: creates a new instance of the customerMenu class when called
    public CustomerMenu(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes the JPanel
    public void initialize() {
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        setBackground(Color.cyan);

        JButton addCustomerButton = makeCustomerButton();
        add(addCustomerButton, gbc);

        JButton viewCustomerButton = makeViewCustomerButton();
        add(viewCustomerButton, gbc);

        JButton removeCustomerButton = makeRemoveCustomerButton();
        add(removeCustomerButton, gbc);

        JButton accessCustomerButton = makeAccessCustomerButton();
        add(accessCustomerButton, gbc);

        JButton backButton = makeBackButton();
        add(backButton, gbc);

        makeVisible();
    }

    //MODIFIES: this
    //EFFECTS: sets the JPanels visibility status to true so it can be seen
    public void makeVisible() {
        this.setVisible(true);
    }

    //EFFECTS: creates a JButton that redirects the user to the addCustomerPanel
    public JButton makeCustomerButton() {
        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "addCustomer");
            }
        });
        return addCustomerButton;
    }

    //EFFECTS: creates a JButton that redirects the user to the viewCustomersPanel
    public JButton makeViewCustomerButton() {
        JButton viewCustomerButton = new JButton("View Customers");
        viewCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        viewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "viewCustomers");
            }
        });
        return viewCustomerButton;
    }

    //EFFECTS: creates a JButton that redirects the user to the removeCustomerPanel
    public JButton makeRemoveCustomerButton() {
        JButton removeCustomerButton = new JButton("Remove Customer");
        removeCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        removeCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "removeCustomer");
            }
        });
        return removeCustomerButton;
    }

    //EFFECTS: creates a JButton that redirects the user to the accessCustomerPanel
    public JButton makeAccessCustomerButton() {
        JButton accessCustomerButton = new JButton("Access Customer");
        accessCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        accessCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "accessPanel");
            }
        });
        return accessCustomerButton;
    }

    //EFFECTS: creates a JButton that redirects the user back to the main menu panel
    public JButton makeBackButton() {
        JButton backButton = new JButton("Go Back");
        backButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "mainMenu");
            }
        });
        return backButton;
    }

}
