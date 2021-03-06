package ui.customerjpanels.individualcustomerpanels;

import model.AllCustomers;
import model.ItemList;
import ui.customerjpanels.AccessCustomerPanel;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows the user to view the cart total so far
public class ViewTheCartTotalPanel extends JPanel {

    private MainPanelContainer container;
    private AllCustomers allCustomers;
    private AccessCustomerPanel accessCustomerPanel;
    private JLabel cartTotalLabel;

    //EFFECTS: creates a new instance of the ViewTheCartTotalPanel class
    public ViewTheCartTotalPanel(MainPanelContainer container, AllCustomers allCustomers,
                                 AccessCustomerPanel accessCustomerPanel) {
        this.accessCustomerPanel = accessCustomerPanel;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        cartTotalLabel = new JLabel();
        add(cartTotalLabel);

        JButton viewCartTotalButton = makeViewCartTotalButton();
        add(viewCartTotalButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates a button that when clicked displays the current total of the cart
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
