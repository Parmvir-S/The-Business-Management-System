package ui.CustomerJPanels;

import model.AllCustomers;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCustomerPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel customerToRemoveNameLabel;
    private JTextField customerToRemoveNameTextField;

    public RemoveCustomerPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        customerToRemoveNameLabel = new JLabel("Customer Name:");
        customerToRemoveNameTextField = new JTextField(20);

        add(customerToRemoveNameLabel);
        add(customerToRemoveNameTextField);

        JButton removeCustomerButton = makeRemoveCustomerButton();
        add(removeCustomerButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    public JButton makeRemoveCustomerButton() {
        JButton removeCustomerButton = new JButton("Remove");
        removeCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = customerToRemoveNameTextField.getText();
                allCustomers.removeCustomer(name);
            }
        });
        return removeCustomerButton;
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
