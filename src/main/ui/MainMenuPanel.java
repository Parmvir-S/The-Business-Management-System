package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    private MainPanelContainer container;

    public MainMenuPanel(MainPanelContainer container) {
        this.container = container;
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


        JButton saveButton = makeSaveButton();
        add(saveButton, gbc);

        JButton loadButton = makeLoadButton();
        add(loadButton, gbc);

        makeVisible();
    }

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

    public JButton makeSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        return saveButton;
    }

    public JButton makeLoadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        return loadButton;
    }


    public void makeVisible() {
        this.setVisible(true);
    }

}
