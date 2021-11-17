package ui.CustomerJPanels.IndividualCustomerPanels;

import model.AllCustomers;
import model.ItemList;
import ui.CustomerJPanels.AccessCustomerPanel;
import ui.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTheCartTotalPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel cartTotalLabel;

    public ViewTheCartTotalPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers, AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    public void initialize() {
        setBackground(Color.cyan);

        cartTotalLabel = new JLabel();
        add(cartTotalLabel);

        JButton viewCartTotalButton = makeViewCartTotalButton();
        add(viewCartTotalButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    public JButton makeViewCartTotalButton() {
        JButton viewCartTotalButton = new JButton("View Total");
        viewCartTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = allCustomers.getCustomer(accessCustomerPanel.getUserName()).getCart().totalPrice();
                cartTotalLabel.setText(String.valueOf(total));
                cartTotalLabel.setFont(new Font("Arial", Font.BOLD, 48));
            }
        });
        return viewCartTotalButton;
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
