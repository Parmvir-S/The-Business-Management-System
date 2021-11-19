package ui.CustomerJPanels;

import model.AllCustomers;
import model.ItemList;
import ui.MainMenuJPanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class displays a view of all the customers currently in the system
public class ViewCustomersPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel viewAllCustomerLabel;

    //EFFECTS: creates a new instance of the ViewCustomersPanel class
    public ViewCustomersPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        viewAllCustomerLabel = new JLabel();
        add(viewAllCustomerLabel);

        JButton viewAllCustomersButton = makeViewAllCustomersButton();
        add(viewAllCustomersButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates a button that when clicked, displays all the users currently in the system
    public JButton makeViewAllCustomersButton() {
        JButton viewAllCustomersButton = new JButton("View All Customers");
        viewAllCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String allCustomerNames = allCustomers.allCustomerNames();
                viewAllCustomerLabel.setText(allCustomerNames);
            }
        });
        return viewAllCustomersButton;
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
