package ui.mainmenujpanels;

import model.EventLog;
import model.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

//This class is the main JFrame that holds every component
public class MainFrame {

    private JFrame mainFrame;
    private JLabel appTitleLabel;
    private MainPanelContainer container;

    //EFFECTS: creates a new instance of the MainFrame class
    public MainFrame() {
        initialize();
    }

    //EFFECTS: initializes the JFrame
    public void initialize() {
        mainFrame = new JFrame();
        frameSetup();

        URL myURL = null;
        URL mySmallLogo = null;
        try {
            myURL = new URL("file:data/images/logo.png");
            mySmallLogo = new URL("file:data/images/smallLogo.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageIcon labelIcon = new ImageIcon(myURL);
        mainFrame.setIconImage(labelIcon.getImage());

        appTitleLabel = createLogo();

        ImageIcon logoIcon = new ImageIcon(mySmallLogo);
        appTitleLabel.setIcon(logoIcon);
        mainFrame.add(appTitleLabel, BorderLayout.NORTH);

        container = new MainPanelContainer();
        mainFrame.add(container, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    //EFFECTS: creates the logo/title
    public JLabel createLogo() {
        JLabel appTitleLabel = new JLabel("The Business Management System", SwingConstants.CENTER);
        appTitleLabel.setForeground(Color.BLACK);
        appTitleLabel.setFont(new Font("Sans-serif", Font.BOLD, 36));
        return appTitleLabel;
    }

    //EFFECTS: Prints the events in the event log to the console
    public void printLog() {
        Iterator<Event> eventIterator = EventLog.getInstance().iterator();
        while (eventIterator.hasNext()) {
            System.out.println(eventIterator.next().toString());
        }
    }

    //MODIFIES: this
    //EFFECTS: sets up the JFrame with some basic properties: title, size, location, closing function etc.
    public void frameSetup() {
        mainFrame.setTitle("Business Management Application");
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                printLog();
                mainFrame.dispose();
                System.exit(0);
            }
        });

        mainFrame.setSize(900, 600);
        mainFrame.setLocationRelativeTo(null);
    }
}
