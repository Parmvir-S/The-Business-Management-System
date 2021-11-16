package ui;

import model.AllCustomers;
import model.ItemList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StoreMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;

    public StoreMenu(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        setBackground(Color.cyan);

        JButton storeAddButton = makeAddButton();
        add(storeAddButton, gbc);

        JButton storeRemoveButton = makeRemoveButton();
        add(storeRemoveButton, gbc);


        JButton storeUpdateButton = makeUpdateButton();
        add(storeUpdateButton, gbc);

        JButton storeStatsButton = makeStatsButton();
        add(storeStatsButton, gbc);

        JButton storeViewItems = makeViewItemsButton();
        add(storeViewItems, gbc);

        JButton backButton = makeBackButton();
        add(backButton, gbc);

        makeVisible();
    }

    public void makeVisible() {
        this.setVisible(true);
    }

    public JButton makeAddButton() {
        JButton storeAddButton = new JButton("Add Item");
        storeAddButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        storeAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeAddItem");
            }
        });
        return storeAddButton;
    }

    public JButton makeRemoveButton() {
        JButton storeRemoveButton = new JButton("Remove Item");
        storeRemoveButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        storeRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeRemoveItem");
            }
        });
        return storeRemoveButton;
    }

    public JButton makeUpdateButton() {
        JButton storeUpdateButton = new JButton("Update Item");
        storeUpdateButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        storeUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeItemUpdate");
            }
        });
        return storeUpdateButton;
    }

    public JButton makeStatsButton() {
        JButton storeStatsButton = new JButton("Store Stats");
        storeStatsButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        storeStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeStats");
            }
        });
        return storeStatsButton;
    }

    public JButton makeViewItemsButton() {
        JButton storeViewItems = new JButton("View Items");
        storeViewItems.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        storeViewItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "viewItems");
            }
        });
        return storeViewItems;
    }

    public JButton makeBackButton() {
        JButton backButton = new JButton("Go Back");
        backButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 11;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "mainMenu");
            }
        });

        return backButton;
    }

}

