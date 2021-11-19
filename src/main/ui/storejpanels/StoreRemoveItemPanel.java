package ui.storejpanels;

import model.AllCustomers;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows the user to remove items from the store
public class StoreRemoveItemPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel itemToRemoveNameLabel;
    private JTextField itemToRemoveNameTextField;

    //EFFECTS: creates a new instance of the StoreRemoveItemPanel class
    public StoreRemoveItemPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        itemToRemoveNameLabel = new JLabel("Name Of Item To Remove");
        itemToRemoveNameTextField = new JTextField(20);

        add(itemToRemoveNameLabel);
        add(itemToRemoveNameTextField);

        JButton removeItemButton = makeRemoveItemButton();
        add(removeItemButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that when clicked removes an item in the store with the entered name
    public JButton makeRemoveItemButton() {
        JButton removeItemButton = new JButton("Remove");
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = itemToRemoveNameTextField.getText();
                storeItems.removeItem(name);
            }
        });
        return removeItemButton;
    }

    //EFFECTS: creates a button that when clicked takes the user back to the store menu
    public JButton makeGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeMenu");
            }
        });
        return goBackButton;
    }

}
