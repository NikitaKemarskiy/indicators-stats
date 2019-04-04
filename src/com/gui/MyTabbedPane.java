package com.gui;

import javax.swing.*;
import java.awt.*;

class MyTabbedPane extends JTabbedPane {
    // Private
    private JPanel tabShow;
    private JPanel tabAdd;
    private JTextField textShowName;
    private JTextField textShowIndicator;
    private JTextField textAddName;
    private JTextField textAddIndicator;
    private JTextField textAddValue;
    private JButton buttonShow;
    private JButton buttonAdd;

    // Public
    MyTabbedPane() {
        super();

        // Tabs
        tabShow = new JPanel();
        tabShow.setLayout(new GridLayout(3, 1));
        tabAdd = new JPanel();
        tabAdd.setLayout(new GridLayout(3, 1));

        // JLabels
        JLabel labelShowName = new JLabel("Имя");
        JLabel labelShowIndicator = new JLabel("Показатель");
        JLabel labelAddName = new JLabel("Имя");
        JLabel labelAddIndicator = new JLabel("Показатель");
        JLabel labelAddValue = new JLabel("Значение");

        // JTextFields
        textShowName = new JTextField();
        textShowIndicator = new JTextField();
        textAddName = new JTextField();
        textAddIndicator = new JTextField();
        textAddValue = new JTextField();

        // Tabs content
        tabShow.add(labelShowName);
        tabShow.add(labelShowIndicator);
        tabAdd.add(labelAddName);
        tabAdd.add(labelAddIndicator);
        tabAdd.add(labelAddValue);

        // This options
        setTabPlacement(JTabbedPane.TOP);
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        addTab("Добавить", tabAdd);
        addTab("Показать", tabShow);
    }
}
