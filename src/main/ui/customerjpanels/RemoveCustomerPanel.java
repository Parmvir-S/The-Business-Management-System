package ui.customerjpanels;

import model.AllCustomers;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class displays the panel which allows the user to remove a customer
public class RemoveCustomerPanel extends JPanel {

    private MainPanelContainer container;
    private AllCustomers allCustomers;
    private JLabel customerToRemoveNameLabel;
    private JTextField customerToRemoveNameTextField;

    //EFFECTS: creates a new instance of the RemoveCustomerPanel class
    public RemoveCustomerPanel(MainPanelContainer container, AllCustomers allCustomers) {
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
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

    //MODIFIES: this
    //EFFECTS: creates a button that when clicked removes the customer with the entered name
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

    //EFFECTS: creates a button that when clicked takes the user back to the customer menu
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
