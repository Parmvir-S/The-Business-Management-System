package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomersPanel extends JPanel {

    private MainPanelContainer container;

    public ViewCustomersPanel(MainPanelContainer container) {
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
                cardLayout.show(container, "customerMenu");
            }
        });

        add(button);
    }
}