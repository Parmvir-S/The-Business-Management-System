package ui;

import javax.swing.*;
import java.awt.*;


public class StoreMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();


    public StoreMenu() {
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
        return storeAddButton;
    }

    public JButton makeRemoveButton() {
        JButton storeRemoveButton = new JButton("Remove Item");
        storeRemoveButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        return storeRemoveButton;
    }

    public JButton makeUpdateButton() {
        JButton storeUpdateButton = new JButton("Update Item");
        storeUpdateButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        return storeUpdateButton;

    }

    public JButton makeStatsButton() {
        JButton storeStatsButton = new JButton("Store Stats");
        storeStatsButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        return storeStatsButton;
    }

    public JButton makeBackButton() {
        JButton backButton = new JButton("Go Back");
        backButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        return backButton;
    }

}

