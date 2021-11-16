package ui.CustomerJPanels;

import model.AllCustomers;
import model.Customer;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessCustomerPanel extends JPanel {
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel accessCustomerNameLabel;
    private JTextField accessCustomerNameTextField;

    public AccessCustomerPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

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

    public JButton makeAccessButton() {
        JButton accessButton = new JButton("Access");
        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = accessCustomerNameTextField.getText();
                for (Customer customer : allCustomers.getAllCustomers()) {
                    if (customer.getName().equals(name)) {
                        CardLayout cardLayout = (CardLayout) container.getLayout();
                        cardLayout.show(container, "individualMenu");
                    }
                }
            }
        });
        return accessButton;
    }


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
