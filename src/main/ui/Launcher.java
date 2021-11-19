package ui;

import ui.mainmenujpanels.MainFrame;

import javax.swing.*;

//This class is the main entry point into the gui application
public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
            }
        });

    }
}
