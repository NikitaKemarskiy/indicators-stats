package com.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

class MyTabbedPane extends JTabbedPane {
    // Private
    private JPanel tabShow;
    private JPanel tabAdd;
    private JPanel tabRemove;
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
    private JTextField textRemoveName;
    private JTextField textRemoveSurname;
    private JTextField textRemovePatronymic;
    private JComboBox<String> textRemoveIndicator;
    private JButton buttonShow;
    private JButton buttonAdd;
    private JButton buttonRemove;

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
        tabRemove = new JPanel();
        tabShow.setLayout(new FlowLayout(FlowLayout.LEFT));
        tabAdd.setLayout(new FlowLayout(FlowLayout.LEFT));
        tabRemove.setLayout(new FlowLayout(FlowLayout.LEFT));
        tabShow.setBorder(new EmptyBorder(5, 0, 5, 0));
        tabAdd.setBorder(new EmptyBorder(5, 0, 5, 0));
        tabRemove.setBorder(new EmptyBorder(5, 0, 5, 0));

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
        textRemoveName = new JTextField();
        textRemoveSurname = new JTextField();
        textRemovePatronymic = new JTextField();

        // JComboBoxes
        textShowIndicator = new JComboBox<>();
        textAddIndicator = new JComboBox<>();
        textRemoveIndicator = new JComboBox<>();
        textShowIndicator.setEditable(true);
        textAddIndicator.setEditable(true);
        textRemoveIndicator.setEditable(true);
        textShowIndicator.setPreferredSize(new Dimension(70, 20));
        textAddIndicator.setPreferredSize(new Dimension(70, 20));
        textRemoveIndicator.setPreferredSize(new Dimension(70, 20));
        for (String indicator : indicators) {
            textShowIndicator.addItem(indicator);
            textAddIndicator.addItem(indicator);
            textRemoveIndicator.addItem(indicator);
        }

        // JButtons
        buttonShow = new JButton("Показати");
        buttonAdd = new JButton("Додати");
        buttonRemove = new JButton("Видалити");
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
        buttonRemove.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        buttonRemove.setBorder(new LineBorder(Color.GRAY, 1));
        buttonRemove.setPreferredSize(new Dimension(80, 20));
        buttonRemove.setMinimumSize(new Dimension(80, 20));
        buttonRemove.setMaximumSize(new Dimension(80, 20));
    }

    // Public
    MyTabbedPane() {
        super();

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
        JLabel labelRemoveName = new JLabel("Ім'я");
        JLabel labelRemoveSurname = new JLabel("Прізвище");
        JLabel labelRemovePatronymic = new JLabel("По батькові");
        JLabel labelRemoveIndicator = new JLabel("Показник");
        labelShowName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelAddValue.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelRemoveName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelRemoveSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelRemovePatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelRemoveIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        labelShowName.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelShowSurname.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelShowPatronymic.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelShowIndicator.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelAddName.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelAddSurname.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelAddPatronymic.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelAddIndicator.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelAddValue.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelRemoveName.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelRemoveSurname.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelRemovePatronymic.setBorder(new EmptyBorder(0, 5, 0, 20));
        labelRemoveIndicator.setBorder(new EmptyBorder(0, 5, 0, 20));

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
        JPanel panelRemoveName = new JPanel(new GridLayout(1, 2));
        JPanel panelRemoveSurname = new JPanel(new GridLayout(1, 2));
        JPanel panelRemovePatronymic = new JPanel(new GridLayout(1, 2));
        JPanel panelRemoveIndicator = new JPanel(new GridLayout(1, 2));
        panelShowName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelShowSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelShowPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelShowIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddPatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelAddValue.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelRemoveName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelRemoveSurname.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelRemovePatronymic.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        panelRemoveIndicator.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));

        panelShowName.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelShowSurname.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelShowPatronymic.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelShowIndicator.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddName.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddSurname.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddPatronymic.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddIndicator.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelAddValue.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelRemoveName.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelRemoveSurname.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelRemovePatronymic.setBorder(new EmptyBorder(0, 0, 15, 0));
        panelRemoveIndicator.setBorder(new EmptyBorder(0, 0, 15, 0));

        panelShowName.setPreferredSize(new Dimension(80, 20));
        panelShowSurname.setPreferredSize(new Dimension(80, 20));
        panelShowPatronymic.setPreferredSize(new Dimension(80, 20));
        panelShowIndicator.setPreferredSize(new Dimension(80, 20));
        panelAddName.setPreferredSize(new Dimension(80, 20));
        panelAddSurname.setPreferredSize(new Dimension(80, 20));
        panelAddPatronymic.setPreferredSize(new Dimension(80, 20));
        panelAddIndicator.setPreferredSize(new Dimension(80, 20));
        panelAddValue.setPreferredSize(new Dimension(80, 20));
        panelRemoveName.setPreferredSize(new Dimension(80, 20));
        panelRemoveSurname.setPreferredSize(new Dimension(80, 20));
        panelRemovePatronymic.setPreferredSize(new Dimension(80, 20));
        panelRemoveIndicator.setPreferredSize(new Dimension(80, 20));

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
        panelRemoveName.add(labelRemoveName);
        panelRemoveName.add(textRemoveName);
        panelRemoveSurname.add(labelRemoveSurname);
        panelRemoveSurname.add(textRemoveSurname);
        panelRemovePatronymic.add(labelRemovePatronymic);
        panelRemovePatronymic.add(textRemovePatronymic);
        panelRemoveIndicator.add(labelRemoveIndicator);
        panelRemoveIndicator.add(textRemoveIndicator);

        // JPanels wrappers
        JPanel panelShow = new JPanel();
        JPanel panelAdd = new JPanel();
        JPanel panelRemove = new JPanel();
        panelShow.setLayout(new BoxLayout(panelShow, BoxLayout.Y_AXIS));
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
        panelRemove.setLayout(new BoxLayout(panelRemove, BoxLayout.Y_AXIS));
        panelShow.setAlignmentX(0.5f);
        panelShow.setAlignmentY(0.5f);
        panelAdd.setAlignmentX(0.5f);
        panelAdd.setAlignmentY(0.5f);
        panelRemove.setAlignmentX(0.5f);
        panelRemove.setAlignmentY(0.5f);

        // JPanels wrappers contents
        panelShow.add(panelShowSurname);
        panelShow.add(panelShowName);
        panelShow.add(panelShowPatronymic);
        panelShow.add(panelShowIndicator);
        panelShow.add(buttonShow);
        panelShow.setPreferredSize(new Dimension(215, 160));
        panelAdd.add(panelAddSurname);
        panelAdd.add(panelAddName);
        panelAdd.add(panelAddPatronymic);
        panelAdd.add(panelAddIndicator);
        panelAdd.add(panelAddValue);
        panelAdd.add(buttonAdd);
        panelAdd.setPreferredSize(new Dimension(215, 200));
        panelRemove.add(panelRemoveSurname);
        panelRemove.add(panelRemoveName);
        panelRemove.add(panelRemovePatronymic);
        panelRemove.add(panelRemoveIndicator);
        panelRemove.add(buttonRemove);
        panelRemove.setPreferredSize(new Dimension(215, 160));

        // Tabs content
        tabShow.add(panelShow);
        tabAdd.add(panelAdd);
        tabRemove.add(panelRemove);

        // This options
        this.setTabPlacement(JTabbedPane.TOP);
        this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.addTab("Показати", tabShow);
        this.addTab("Додати", tabAdd);
        this.addTab("Видалити", tabRemove);
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
        return (String) textAddIndicator.getSelectedItem();
    }

    String getAddValue() {
        return textAddValue.getText();
    }

    String getRemoveName() {
        return textRemoveName.getText();
    }

    String getRemoveSurname() {
        return textRemoveSurname.getText();
    }

    String getRemovePatronymic() {
        return textRemovePatronymic.getText();
    }

    String getRemoveIndicator() {
        return (String) textRemoveIndicator.getSelectedItem();
    }

    JButton getButtonShow() {
        return buttonShow;
    }

    JButton getButtonAdd() {
        return buttonAdd;
    }

    JButton getButtonRemove() {
        return buttonRemove;
    }
}
