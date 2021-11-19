package ui.MainMenuJPanels;

import model.AllCustomers;
import model.ItemList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class holds the main menu panel that allows you to access store/customer options and save/load data
public class MainMenuPanel extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    //EFFECTS: creates a new instance of the MainMenuPanel class
    public MainMenuPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: this method initializes the JPanel
    public void initialize() {
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        setBackground(Color.cyan);

        JButton storeMenuButton = makeStoreButton();
        add(storeMenuButton, gbc);

        JButton customerMenuButton = makeCustomerButton();
        add(customerMenuButton, gbc);

        makeVisible();
    }

    //EFFECTS: creates a JButton that redirects the user to the store menu
    public JButton makeStoreButton() {
        JButton storeMenuButton = new JButton("Store Menu");
        storeMenuButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        storeMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeMenu");
            }
        });
        return storeMenuButton;
    }

    //EFFECTS: creates a JButton that redirects the user to the customer menu
    public JButton makeCustomerButton() {
        JButton customerMenuButton = new JButton("Customer Menu");
        customerMenuButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        customerMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "customerMenu");
            }
        });
        return customerMenuButton;
    }

    //MODIFIES: this
    //EFFECTS: changes the visibility status of this JPanel to true
    public void makeVisible() {
        this.setVisible(true);
    }
}
