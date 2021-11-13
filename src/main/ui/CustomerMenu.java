package ui;

import javax.swing.*;
import java.awt.*;

public class CustomerMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();

    public CustomerMenu() {
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
        return addCustomerButton;
    }

    public JButton makeViewCustomerButton() {
        JButton viewCustomerButton = new JButton("View Customers");
        viewCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        return viewCustomerButton;
    }

    public JButton makeRemoveCustomerButton() {
        JButton removeCustomerButton = new JButton("Remove Customer");
        removeCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        return removeCustomerButton;

    }

    public JButton makeAccessCustomerButton() {
        JButton accessCustomerButton = new JButton("Store Stats");
        accessCustomerButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        return accessCustomerButton;
    }

    public JButton makeBackButton() {
        JButton backButton = new JButton("Go Back");
        backButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        return backButton;
    }

}
