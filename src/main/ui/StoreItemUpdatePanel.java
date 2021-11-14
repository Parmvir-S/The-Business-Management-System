package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreItemUpdatePanel extends JPanel {

    private MainPanelContainer container;

    public StoreItemUpdatePanel(MainPanelContainer container) {
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        JButton button = new JButton("back");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeMenu");
            }
        });

        add(button);
    }
}
