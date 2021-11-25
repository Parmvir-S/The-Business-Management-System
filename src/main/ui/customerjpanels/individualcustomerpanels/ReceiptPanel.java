package ui.customerjpanels.individualcustomerpanels;

import model.AllCustomers;
import model.ItemList;
import ui.customerjpanels.AccessCustomerPanel;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//This class produces a receipt for a customer
public class ReceiptPanel extends JPanel {

    private MainPanelContainer container;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel viewReceiptLabel;

    //EFFECTS: creates a new instance of the ReceiptPanel class
    public ReceiptPanel(MainPanelContainer container, AllCustomers allCustomers,
                        AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        viewReceiptLabel = new JLabel();
        add(viewReceiptLabel);

        JButton viewReceiptButton = makeViewReceiptButton();
        add(viewReceiptButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates a button that when clicked displays a receipt for the customer
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

    //EFFECTS: creates a button that when clicked takes the user back to the individual menu
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
