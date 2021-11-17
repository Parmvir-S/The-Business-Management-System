package ui.CustomerJPanels.IndividualCustomerPanels;

import model.AllCustomers;
import model.ItemList;
import ui.CustomerJPanels.AccessCustomerPanel;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReceiptPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel viewReceiptLabel;

    public ReceiptPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers, AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        viewReceiptLabel = new JLabel();
        add(viewReceiptLabel);

        JButton viewReceiptButton = makeViewReceiptButton();
        add(viewReceiptButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    public JButton makeViewReceiptButton() {
        JButton viewReceiptButton = new JButton("Print Receipt");
        viewReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> receipt = allCustomers.getCustomer(accessCustomerPanel.getUserName()).getReceipt();
                String receiptOutput = "";
                for (String info: receipt) {
                    receiptOutput += info;
                }
                viewReceiptLabel.setText(receiptOutput);
            }
        });
        return viewReceiptButton;
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
