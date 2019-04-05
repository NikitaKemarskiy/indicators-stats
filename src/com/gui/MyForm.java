package com.gui;

import com.jsondb.Database;
import com.google.gson.Gson;
import com.structure.IndicatorEntry;
import com.structure.Patient;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;

public class MyForm extends JFrame {
    // Private
    private MyMenuBar menuBar;
    private JPanel rootPanel;
    private JPanel chartPanel;
    private MyTabbedPane tabbedPane;

    // Static values
    private static final Path DATABASE_PATH = Paths.get("data"); // Database path
    private static final Gson JSON = new Gson(); // Gson object for serializing / deserializing JSON data
    private static Database database = new Database(DATABASE_PATH); // Database object

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
        panelLeft.setBorder(new EmptyBorder(20, 20, 0, 0));
        panelRight.setLayout(new GridLayout(1, 1));
        panelRight.setOpaque(true);
        panelRight.setBorder(new EmptyBorder(20, 30, 30, 30));

        // Left inner panel
        final JPanel panelLeftInner = new JPanel();
        panelLeftInner.setLayout(new BorderLayout());

        // Right inner panel
        final JPanel panelRightInner = new JPanel();
        panelRightInner.setLayout(new GridLayout(1, 1));

        // Chart XYChart objec
        XYChart chart = new XYChartBuilder()
                .width(panelRightInner.getHeight())
                .height(panelRightInner.getHeight())
                .title("Изменение показателей по времени")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();

        // Chart panel
        chartPanel = new MyChartPanel(chart);

        // Tabbed pane
        tabbedPane = new MyTabbedPane();

        // Tabbed pane action listeners
        tabbedPane.getButtonShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final String name = tabbedPane.getShowName(); // Name
                final String indicator = tabbedPane.getShowIndicator(); // Indicator
                if (name.length() == 0 || indicator.length() == 0) { return; } // Name / indicator is empty
                String data = database.read(name);
                if (data == null) { // There's no patient with such name
                    //...
                    return;
                }
                Patient patient = JSON.fromJson(data, Patient.class);
                List<IndicatorEntry> values = patient.getIndicatorValues(indicator);
                for (IndicatorEntry entry : values) {
                    System.out.println(entry.getDate() + ": " + entry.getValue());
                }
                // Чтение показателя данного пациента из базы
            }
        });
        tabbedPane.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final String name = tabbedPane.getAddName(); // Name
                final String indicator = tabbedPane.getAddIndicator(); // Indicator
                final String value = tabbedPane.getAddValue(); // Value
                if (name.length() == 0 || indicator.length() == 0 || value.length() == 0) { return; } // Name / indicator / value is empty
                String data = database.read(name);
                Patient patient = null;
                if (data == null) { // There's no patient with such name
                    patient = new Patient(name); // Create new patient object
                } else { // There's a patient in a database
                    patient = JSON.fromJson(data, Patient.class); // Get existing patient
                }
                patient.addValue(indicator, value); // Add indicator value to a patient object
                database.save(name, JSON.toJson(patient)); // Save it to a database
                // Добавление показателя для заданого пациента в базу
            }
        });

        // Left and right panels contents
        panelLeftInner.add(tabbedPane, BorderLayout.NORTH);
        panelRightInner.add(chartPanel);
        panelLeft.add(panelLeftInner);
        panelRight.add(panelRightInner);

        // Root panel contents
        rootPanel.add(panelLeft, BorderLayout.WEST);
        rootPanel.add(panelRight, BorderLayout.CENTER);
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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close operation
        this.setMinimumSize(new Dimension(800, 600)); // Minimum size
        this.setSize(new Dimension(800, 600)); // Size
        this.setResizable(true); // Resizable
        this.setJMenuBar(menuBar); // Menu bar

        // Add components
        this.add(rootPanel);

        /*chart.addSeries("f(x)", new double[] {1.0, 2.0, 3.0}, new double[] {0.7, 2.4, 3.8});
        chart.addSeries("g(x)", new double[] {1.7, 0.0, 1.4}, new double[] {2.7, 2.4, 1.8});

        chart.removeSeries("f(x)");
        chart.removeSeries("g(x)");*/

        // Visibility
        this.setVisible(true);
    }
}
