package ui.customerjpanels;

import model.AllCustomers;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class displays the individual menu options for a customer
public class IndividualMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    //EFFECTS: generates a new instance of the IndividualMenu class
    public IndividualMenu(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        setBackground(Color.cyan);

        JButton itemAddButton = makeItemAddButton();
        add(itemAddButton, gbc);

        JButton itemRemoveButton = makeItemRemoveButton();
        add(itemRemoveButton, gbc);

        JButton itemsViewButton = makeItemsViewButton();
        add(itemsViewButton, gbc);

        JButton itemsTotalButton = makeItemsTotalButton();
        add(itemsTotalButton, gbc);

        JButton displayReceiptButton = makeDisplayReceiptButton();
        add(displayReceiptButton, gbc);

        JButton backButton = makeBackButton();
        add(backButton, gbc);

        makeVisible();
    }

    //MODIFIES: this
    //EFFECTS: changes the visibility status of this JPanel to true
    public void makeVisible() {
        this.setVisible(true);
    }

    //EFFECTS: creates a button that when clicked takes the user to the addToCart panel
    public JButton makeItemAddButton() {
        JButton itemAddButton = new JButton("Add Item To Cart");
        itemAddButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        itemAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "addToCart");
            }
        });
        return itemAddButton;
    }

    //EFFECTS: creates a button that when clicked takes the user to the removeFromCart panel
    public JButton makeItemRemoveButton() {
        JButton itemRemoveButton = new JButton("Remove Item From Cart");
        itemRemoveButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        itemRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "removeFromCart");
            }
        });
        return itemRemoveButton;
    }

    //EFFECTS: creates a button that when clicked takes the user to the viewItemsInCart panel
    public JButton makeItemsViewButton() {
        JButton itemsViewButton = new JButton("View Items In Cart");
        itemsViewButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        itemsViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "viewItemsInCart");
            }
        });
        return itemsViewButton;

    }

    //EFFECTS: creates a button that when clicked takes the user to the viewCartTotal panel
    public JButton makeItemsTotalButton() {
        JButton itemsTotalButton = new JButton("View Total");
        itemsTotalButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        itemsTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "viewCartTotal");
            }
        });
        return itemsTotalButton;
    }

    //EFFECTS: creates a button that when clicked takes the user to the viewReceipt panel
    public JButton makeDisplayReceiptButton() {
        JButton displayReceiptButton = new JButton("Show Receipt");
        displayReceiptButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        displayReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "viewReceipt");
            }
        });
        return displayReceiptButton;
    }

    //EFFECTS: creates a button that when clicked takes the user back to the customer menu
    public JButton makeBackButton() {
        JButton backButton = new JButton("Go Back");
        backButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 11;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "customerMenu");
            }
        });
        return backButton;
    }

}
