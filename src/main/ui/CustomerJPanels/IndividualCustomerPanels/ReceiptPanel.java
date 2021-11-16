package ui.CustomerJPanels.IndividualCustomerPanels;

import model.AllCustomers;
import model.ItemList;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;


    public ReceiptPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);


        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }


    public JButton makeGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "individualMenu");
            }
        });
        return goBackButton;
    }
}
