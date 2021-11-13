package ui;

import javax.swing.*;
import java.awt.*;

public class IndividualMenu extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();

    public IndividualMenu() {
        initialize();
    }

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

    public void makeVisible() {
        this.setVisible(true);
    }

    public JButton makeItemAddButton() {
        JButton itemAddButton = new JButton("Add Item To Cart");
        itemAddButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return itemAddButton;
    }

    public JButton makeItemRemoveButton() {
        JButton itemRemoveButton = new JButton("Remove Item From Cart");
        itemRemoveButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        return itemRemoveButton;
    }

    public JButton makeItemsViewButton() {
        JButton itemsViewButton = new JButton("View Items In Cart");
        itemsViewButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        return itemsViewButton;

    }

    public JButton makeItemsTotalButton() {
        JButton itemsTotalButton = new JButton("View Total");
        itemsTotalButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        return itemsTotalButton;
    }

    public JButton makeDisplayReceiptButton() {
        JButton displayReceiptButton = new JButton("Show Receipt");
        displayReceiptButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        return displayReceiptButton;
    }


    public JButton makeBackButton() {
        JButton backButton = new JButton("Go Back");
        backButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 11;
        return backButton;
    }

}
