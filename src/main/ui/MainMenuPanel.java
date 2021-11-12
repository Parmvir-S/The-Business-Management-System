package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();

    public MainMenuPanel() {
        initialize();
    }

    public void initialize() {
//        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//        setLayout(new GridLayout(4, 3, 15, 25));

        setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        setBackground(Color.cyan);

        JButton storeMenuButton = makeStoreButton();
        add(storeMenuButton, gbc);

        JButton customerMenuButton = makeCustomerButton();
        add(customerMenuButton, gbc);


        JButton saveButton = new JButton("Save");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(saveButton, gbc);

        JButton loadButton = new JButton("Load");
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(loadButton, gbc);

        makeVisible();
    }

    public JButton makeStoreButton() {
        JButton storeMenuButton = new JButton("Store Menu");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return storeMenuButton;
    }

    public JButton makeCustomerButton() {
        JButton customerMenuButton = new JButton("Customer Menu");
        gbc.gridx = 0;
        gbc.gridy = 3;
        return customerMenuButton;
    }

    public void makeVisible() {
        this.setVisible(true);
    }

}
