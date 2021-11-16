package ui;

import model.AllCustomers;
import model.ItemList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    public CustomerMenu(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

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

    public void makeVisible() {
        this.setVisible(true);
    }

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

    public JButton makeAccessCustomerButton() {
        JButton accessCustomerButton = new JButton("Access Customer");
        accessCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        accessCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "individualMenu");
            }
        });
        return accessCustomerButton;
    }

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
