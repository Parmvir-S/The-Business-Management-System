package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    public MainMenuPanel() {
        initialize();
    }

    public void initialize() {
//        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//        setLayout(new GridBagLayout());
//        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(new GridLayout(4, 1, 15, 25));

        setBackground(Color.cyan);

        JButton storeMenuButton = new JButton("Store Menu");
        JButton customerMenuButton = new JButton("Customer Menu");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        add(storeMenuButton);
        add(customerMenuButton);
        add(saveButton);
        add(loadButton);

        setVisible(true);
    }

}
