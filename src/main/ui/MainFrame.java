package ui;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainFrame {

    private JFrame mainFrame;
    private JPanel mainMenuPanel;
    private JLabel appTitleLabel;

    public MainFrame() {
        initialize();
    }

    public void initialize() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Business Management Application");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(900, 600);
        mainFrame.setLocationRelativeTo(null);

        URL myURL = null;
        try {
            myURL = new URL("file:data/images/logo.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageIcon labelIcon = new ImageIcon(myURL);
        mainFrame.setIconImage(labelIcon.getImage());


        appTitleLabel = new JLabel("The Business Management System", SwingConstants.CENTER);
        appTitleLabel.setForeground(Color.BLACK);
        appTitleLabel.setFont(new Font("Sans-serif", Font.BOLD, 36));
        mainFrame.add(appTitleLabel, BorderLayout.NORTH);


        mainMenuPanel = new MainMenuPanel();
        mainFrame.add(mainMenuPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }
}
