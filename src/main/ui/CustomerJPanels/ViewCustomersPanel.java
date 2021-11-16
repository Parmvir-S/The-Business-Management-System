package ui.CustomerJPanels;

import model.AllCustomers;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomersPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel viewAllCustomerLabel;

    public ViewCustomersPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        viewAllCustomerLabel = new JLabel();
        add(viewAllCustomerLabel);

        JButton viewAllCustomersButton = makeViewAllCustomersButton();
        add(viewAllCustomersButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

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
