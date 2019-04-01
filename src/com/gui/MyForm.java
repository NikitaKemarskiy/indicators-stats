package com.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyForm extends JFrame {
    // Private
    private MyMenuBar menuBar;
    private JPanel rootPanel;
    private JTabbedPane tabbedPane;
    private JPanel tabShow;
    private JPanel tabAdd;

    // Initialization block
    {
        // Menu bar
        menuBar = new MyMenuBar();

        // Root panel
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.setMinimumSize(new Dimension(800, 600));
        rootPanel.setOpaque(true);
        rootPanel.setPreferredSize(new Dimension(800, 600));

        // Left and right panels
        final JPanel panelLeft = new JPanel();
        final JPanel panelRight = new JPanel();
        panelLeft.setLayout(new GridLayout(2, 1));
        panelLeft.setPreferredSize(new Dimension(200, 228));
        panelLeft.setBorder(new EmptyBorder(20, 10, 0, 0));
        panelRight.setLayout(new GridLayout(1, 1));
        panelRight.setOpaque(true);
        panelRight.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Left inner panel
        final JPanel panelLeftInner = new JPanel();
        panelLeftInner.setLayout(new GridLayout(1, 1));

        // Right inner panel
        final JPanel panelRightInner = new JPanel();
        panelRightInner.setLayout(new GridLayout(1, 1));

        // Tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // Tabs
        tabShow = new JPanel();
        tabShow.setLayout(new GridLayout(1, 1));
        tabAdd = new JPanel();
        tabAdd.setLayout(new GridLayout(1, 1));

        // Add components
        tabbedPane.addTab("Добавить", tabAdd);
        tabbedPane.addTab("Показать", tabShow);
        panelLeftInner.add(tabbedPane);
        panelLeft.add(panelLeftInner);
        panelRight.add(panelRightInner);
        rootPanel.add(panelLeft, BorderLayout.WEST);
        rootPanel.add(panelRight, BorderLayout.CENTER);

        panelRight.setBackground(new Color(0, 255, 0));
        panelRightInner.setBackground(new Color(255, 0, 0));
    }

    // Public
    public MyForm() {
        // Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        // MyForm options
        setVisible(true); // Visibility
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close operation
        setMinimumSize(new Dimension(800, 600)); // Minimum size
        setSize(new Dimension(800, 600)); // Size
        setResizable(true); // Resizable
        setJMenuBar(menuBar); // Menu bar

        // Add components
        add(rootPanel);
        pack();
    }
}
