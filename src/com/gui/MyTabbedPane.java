package com.gui;

import com.cache.PatientCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

class MyTabbedPane extends JTabbedPane {
    // Private
    private JPanel tabShow;
    private JPanel tabAdd;
    private JTextField textShowName;
    private JTextField textShowSurname;
    private JTextField textShowPatronymic;
    //private JTextField textShowIndicator;
    private JComboBox<String> textShowIndicator;
    private JTextField textAddName;
    private JTextField textAddSurname;
    private JTextField textAddPatronymic;
    //private JTextField textAddIndicator;
    private JComboBox<String> textAddIndicator;
    private JTextField textAddValue;
    private JButton buttonShow;
    private JButton buttonAdd;

    private PatientCache patientsCache; // Patients cache

    private static final String[] indicators;

    // Static initialization block
    static {
        indicators = new String[] {
                "Сахар крови",
                "Гемоглобин",
                "Билирубин",
                "Вес",
                "pH крови",
                "Кол-во лейкоцитов",
                "Холестерин крови",
                ""
        };
        Arrays.sort(indicators);
    }

    // Initialization block
    {
        // Tabs
        tabShow = new JPanel();
        tabAdd = new JPanel();
        tabShow.setLayout(new FlowLayout(FlowLayout.LEFT));
        tabAdd.setLayout(new FlowLayout(FlowLayout.LEFT));
        tabShow.setBorder(new EmptyBorder(5, 0, 5, 0));
        tabAdd.setBorder(new EmptyBorder(5, 0, 5, 0));

        // JTextFields
        textShowName = new JTextField();
        textShowSurname = new JTextField();
        textShowPatronymic = new JTextField();
        //textShowIndicator = new JTextField();
        textAddName = new JTextField();
        textAddSurname = new JTextField();
        textAddPatronymic = new JTextField();
        //textAddIndicator = new JTextField();
        textAddValue = new JTextField();

        // JComboBoxes
        textShowIndicator = new JComboBox<>();
        textAddIndicator = new JComboBox<>();
        textShowIndicator.setEditable(true);
        textAddIndicator.setEditable(true);
        textShowIndicator.setPreferredSize(new Dimension(50, 20));
        textAddIndicator.setPreferredSize(new Dimension(50, 20));
        for (String indicator : indicators) {
            textShowIndicator.addItem(indicator);
            textAddIndicator.addItem(indicator);
        }


        // JButtons
        buttonShow = new JButton("Показати");
        buttonAdd = new JButton("Додати");
        buttonShow.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        buttonShow.setBorder(new LineBorder(Color.GRAY, 1));
        buttonShow.setPreferredSize(new Dimension(80, 20));
        buttonShow.setMinimumSize(new Dimension(80, 20));
        buttonShow.setMaximumSize(new Dimension(80, 20));
        buttonAdd.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        buttonAdd.setBorder(new LineBorder(Color.GRAY, 1));
        buttonAdd.setPreferredSize(new Dimension(80, 20));
        buttonAdd.setMinimumSize(new Dimension(80, 20));
        buttonAdd.setMaximumSize(new Dimension(80, 20));
    }

    // Public
    MyTabbedPane(PatientCache patientsCache) {
        super();

        // Patients cache
        this.patientsCache = patientsCache;

        // JLabels
        JLabel labelShowName = new JLabel("Ім'я");
        JLabel labelShowSurname = new JLabel("Прізвище");
        JLabel labelShowPatronymic = new JLabel("По батькові");
        JLabel labelShowIndicator = new JLabel("Показник");
        JLabel labelAddName = new JLabel("Ім'я");
        JLabel labelAddSurname = new JLabel("Прізвище");
        JLabel labelAddPatronymic = new JLabel("По батькові");
        JLabel labelAddIndicator = new JLabel("Показник");
        JLabel labelAddValue = new JLabel("Значення");
        labelShowName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddValue.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowName.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelShowSurname.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelShowPatronymic.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelShowIndicator.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelAddName.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelAddSurname.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelAddPatronymic.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelAddIndicator.setBorder(new EmptyBorder(0, 0, 0, 8));
        labelAddValue.setBorder(new EmptyBorder(0, 0, 0, 8));

        // JPanels for rows
        JPanel panelShowName = new JPanel(new GridLayout(1, 2));
        JPanel panelShowSurname = new JPanel(new GridLayout(1, 2));
        JPanel panelShowPatronymic = new JPanel(new GridLayout(1, 2));
        JPanel panelShowIndicator = new JPanel(new GridLayout(1, 2));
        JPanel panelAddName = new JPanel(new GridLayout(1, 2));
        JPanel panelAddSurname = new JPanel(new GridLayout(1, 2));
        JPanel panelAddPatronymic = new JPanel(new GridLayout(1, 2));
        JPanel panelAddIndicator = new JPanel(new GridLayout(1, 2));
        JPanel panelAddValue = new JPanel(new GridLayout(1, 2));
        panelShowName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelShowSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelShowPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelShowIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddValue.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));

        panelShowName.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelShowSurname.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelShowPatronymic.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelShowIndicator.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddName.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddSurname.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddPatronymic.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddIndicator.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddValue.setBorder(new EmptyBorder(0, 0, 15, 0));

        // JPanels for rows contents
        panelShowName.add(labelShowName);
        panelShowName.add(textShowName);
        panelShowSurname.add(labelShowSurname);
        panelShowSurname.add(textShowSurname);
        panelShowPatronymic.add(labelShowPatronymic);
        panelShowPatronymic.add(textShowPatronymic);
        panelShowIndicator.add(labelShowIndicator);
        panelShowIndicator.add(textShowIndicator);
        panelAddName.add(labelAddName);
        panelAddName.add(textAddName);
        panelAddSurname.add(labelAddSurname);
        panelAddSurname.add(textAddSurname);
        panelAddPatronymic.add(labelAddPatronymic);
        panelAddPatronymic.add(textAddPatronymic);
        panelAddIndicator.add(labelAddIndicator);
        panelAddIndicator.add(textAddIndicator);
        panelAddValue.add(labelAddValue);
        panelAddValue.add(textAddValue);

        // JPanels wrappers
        JPanel panelShow = new JPanel();
        JPanel panelAdd = new JPanel();
        panelShow.setLayout(new BoxLayout(panelShow, BoxLayout.Y_AXIS));
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
        panelShow.setAlignmentX(0.5f);
        panelShow.setAlignmentY(0.5f);
        panelAdd.setAlignmentX(0.5f);
        panelAdd.setAlignmentY(0.5f);

        // JPanels wrappers contents
        panelShow.add(panelShowSurname);
        panelShow.add(panelShowName);
        panelShow.add(panelShowPatronymic);
        panelShow.add(panelShowIndicator);
        panelShow.add(buttonShow);
        panelAdd.add(panelAddSurname);
        panelAdd.add(panelAddName);
        panelAdd.add(panelAddPatronymic);
        panelAdd.add(panelAddIndicator);
        panelAdd.add(panelAddValue);
        panelAdd.add(buttonAdd);

        // Tabs content
        tabShow.add(panelShow);
        tabAdd.add(panelAdd);

        // This options
        this.setTabPlacement(JTabbedPane.TOP);
        this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.addTab("Показати", tabShow);
        this.addTab("Додати", tabAdd);
    }

    // Method
    String getShowName() {
        return textShowName.getText();
    }

    String getShowSurname() {
        return textShowSurname.getText();
    }

    String getShowPatronymic() {
        return textShowPatronymic.getText();
    }

    String getShowIndicator() {
        //return textShowIndicator.getText();
        return (String) textShowIndicator.getSelectedItem();
    }

    String getAddName() {
        return textAddName.getText();
    }

    String getAddSurname() {
        return textAddSurname.getText();
    }

    String getAddPatronymic() {
        return textAddPatronymic.getText();
    }

    String getAddIndicator() {
        //return textAddIndicator.getText();
        return (String) textAddIndicator.getSelectedItem();
    }

    String getAddValue() {
        return textAddValue.getText();
    }

    JButton getButtonShow() {
        return buttonShow;
    }

    JButton getButtonAdd() {
        return buttonAdd;
    }
}
