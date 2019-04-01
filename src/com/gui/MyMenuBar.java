package com.gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class MyMenuBar extends JMenuBar {
    // Private
    MyMenuBar self;
    JMenu fileMenu;
    JMenu helpMenu;
    JMenuItem fileMenuExit;
    JMenuItem helpMenuWebsite;
    JMenuItem helpMenuAbout;

    // Initialization block
    {
        // Pointer to this
        self = this;

        // JMenus
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        fileMenu.setForeground(new Color(220, 220, 220));
        helpMenu.setForeground(new Color(220, 220, 220));

        // JMenuItems
        fileMenuExit = new JMenuItem("Exit");
        helpMenuWebsite = new JMenuItem("Official website");
        helpMenuAbout = new JMenuItem("About");

        // Actions
        fileMenuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Exit an application
                System.exit(0);
            }
        });

        helpMenuWebsite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    // Go to the official website
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/NikitaKemarskiy"));
                } catch (IOException err) {
                    System.out.println(err.getMessage());
                }
            }
        });

        helpMenuAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Show message dialog with product information
                JOptionPane.showMessageDialog(self, "This product was developed by Nikita Kemarskiy. GitHub: https://github.com/NikitaKemarskiy", "About product", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add JMenuItems in JMenus
        fileMenu.add(fileMenuExit);
        helpMenu.add(helpMenuWebsite);
        helpMenu.add(helpMenuAbout);
    }

    // Public
    MyMenuBar() {
        super();
        add(fileMenu);
        add(helpMenu);
    }
}
