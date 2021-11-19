package ui.storejpanels;

import model.AllCustomers;
import model.ItemList;
import ui.mainmenujpanels.MainPanelContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class displays the stores stats - total customers and sales
public class StoreStatsDisplayPanel extends JPanel {

    private MainPanelContainer container;
    private ItemList storeItems;
    private AllCustomers allCustomers;
    private JLabel totalCustomerLabel;
    private JLabel totalSalesLabel;

    //EFFECTS: creates a new instance of the StoreStatsDisplayPanel class
    public StoreStatsDisplayPanel(MainPanelContainer container, ItemList storeItems, AllCustomers allCustomers) {
        this.storeItems = storeItems;
        this.allCustomers = allCustomers;
        this.container = container;
        initialize();
    }

    //EFFECTS: initializes this JPanel
    public void initialize() {
        setBackground(Color.cyan);

        totalCustomerLabel = new JLabel();
        totalSalesLabel = new JLabel();

        add(totalCustomerLabel);
        add(totalSalesLabel);

        JButton getTotalButton = makeGetTotalButton();
        add(getTotalButton);

        JButton goBackButton = makeGoBackButton();
        add(goBackButton);
    }

    //EFFECTS: creates button that when clicked displays total customers and total sales
    public JButton makeGetTotalButton() {
        JButton getTotalButton = new JButton("Total Customers/Sales");
        getTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalCustomers = allCustomers.getTotalNumberOfCustomers();
                double totalSales = allCustomers.getTotalSales();
                totalCustomerLabel.setText("Total Customers: " + totalCustomers);
                totalSalesLabel.setText("Total Sales: " + totalSales);
            }
        });
        return getTotalButton;
    }

    //EFFECTS: creates a button that when clicked takes the user back to the store menu
    public JButton makeGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "storeMenu");
            }
        });
        return goBackButton;
    }
}
