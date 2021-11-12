package ui;

import javax.swing.*;
import java.awt.*;

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

        appTitleLabel = new JLabel("The Business Management System", SwingConstants.CENTER);
        appTitleLabel.setForeground(Color.BLACK);


        appTitleLabel.setFont(new Font("Sans-serif", Font.BOLD, 36));
        mainFrame.add(appTitleLabel, BorderLayout.NORTH);

//        System.out.println(this.getClass().getResource("images//logo.png"));
//        ImageIcon labelIcon = new ImageIcon(this.getClass().getResource("../../data/images/logo.png"));
//        mainFrame.setIconImage(labelIcon.getImage());
        mainMenuPanel = new MainMenuPanel();
        mainFrame.add(mainMenuPanel, BorderLayout.CENTER);


        mainFrame.setVisible(true);
    }
}
