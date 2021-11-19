package ui.CustomerJPanels;

import model.AllCustomers;
import model.Customer;
import model.CustomerCart;
import model.ItemList;
import ui.MainMenuJPanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//Displays the add customer JPanel
public class AddCustomerPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel customerNameLabel;
    private JTextField customerNameTextField;
    private JLabel customerEmailLabel;
    private JTextField customerEmailTextField;
    private JLabel customerPhoneNumberLabel;
    private JTextField customerPhoneNumberTextField;

    //EFFECTS: creates a new instance of the AddCustomerPanel class
    public AddCustomerPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        customerNameLabel = new JLabel("New Customer Name:");
        customerNameTextField = new JTextField(20);
        customerEmailLabel = new JLabel("New Customer Email:");
        customerEmailTextField = new JTextField(20);
        customerPhoneNumberLabel = new JLabel("New Customer Phone Number:");
        customerPhoneNumberTextField = new JTextField(20);

        add(customerNameLabel);
        add(customerNameTextField);
        add(customerEmailLabel);
        add(customerEmailTextField);
        add(customerPhoneNumberLabel);
        add(customerPhoneNumberTextField);

        JButton createNewCustomerButton = makeNewCustomerButton();
        add(createNewCustomerButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that when clicked, uses the JTextField values to create and
    //         add a new customer to allCustomers
    public JButton makeNewCustomerButton() {
        JButton createNewCustomerButton = new JButton("Create Customer");
        createNewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int customerID = random.nextInt();
                String name = customerNameTextField.getText();
                String email = customerEmailTextField.getText();
                int phoneNumber = Integer.valueOf(customerPhoneNumberTextField.getText());
                CustomerCart cart = new CustomerCart();

                Customer customer = new Customer(customerID, name, email, phoneNumber, cart);
                allCustomers.addCustomer(customer);
            }
        });
        return createNewCustomerButton;
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
