package ui.StoreJPanels;

import model.AllCustomers;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreRemoveItemPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel itemToRemoveNameLabel;
    private JTextField itemToRemoveNameTextField;

    public StoreRemoveItemPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

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
