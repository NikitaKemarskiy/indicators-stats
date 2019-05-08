package com.gui;

import com.cache.PatientCache;
import com.jsondb.Database;
import com.google.gson.Gson;
import com.structure.IndicatorEntry;
import com.structure.Patient;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.internal.series.Series;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class MyForm extends JFrame {
    // Private
    private MyMenuBar menuBar;
    private JPanel rootPanel;
    private JPanel chartPanel;
    private MyTabbedPane tabbedPane;
    private MyForm self;
    private String currentIndicator;

    // Static values
    private static final Path DATABASE_PATH = Paths.get("data"); // Database path
    private static final Gson JSON = new Gson(); // Gson object for serializing / deserializing JSON data
    private static Database database = new Database(DATABASE_PATH); // Database object
    private static PatientCache patientsCache = new PatientCache(); // Patients cache

    // Initialization block
    {
        // Link to this
        this.self = this;

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
                .title("Зміна показників за часом")
                .xAxisTitle("Час")
                .yAxisTitle("Значення")
                .build();

        // Chart panel
        chartPanel = new MyChartPanel(chart);

        // Tabbed pane
        tabbedPane = new MyTabbedPane(patientsCache);

        // Tabbed pane action listeners
        // Read indicator of the special patient from a database
        tabbedPane.getButtonShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final String name = tabbedPane.getShowName().trim(); // Name
                final String surname = tabbedPane.getShowSurname().trim(); // Surname
                final String patronymic = tabbedPane.getShowPatronymic().trim(); // Patronymic
                final String indicator = tabbedPane.getShowIndicator().trim(); // Indicator
                final String patientId = name.toLowerCase() + surname.toLowerCase() + patronymic.toLowerCase(); // Patient ID

                if (patientId.isEmpty() || indicator.isEmpty()) { return; } // Patient ID / indicator is empty

                if (!patientsCache.has(name, surname, patronymic)) { // Add patient to a patients cache
                    patientsCache.add(name, surname, patronymic);
                }

                String data = database.read(patientId); // JSON data from a database

                if (data == null) { // There's no patient with such name
                    JOptionPane.showMessageDialog(self, "Пацієнт з таким ПІБ не був знайдений", "Попередження", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Patient patient = JSON.fromJson(data, Patient.class); // Patient object
                List<IndicatorEntry> entries = patient.getIndicatorValues(indicator.toLowerCase()); // List of indicator entries
                String norm = patient.getIndicatorNorm(indicator.toLowerCase()); // Indicator norm

                if (entries == null) { // There's no indicator with such name
                    JOptionPane.showMessageDialog(self, "Індикатор з такою назвою не був знайдений", "Попередження", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                List<Date> dates = new LinkedList<>();
                List<Double> values = new LinkedList<>();
                List<Double> norms = new LinkedList<>();

                for (IndicatorEntry entry : entries) {
                    dates.add(entry.getDate());
                    values.add(Double.parseDouble(entry.getValue()));
                    norms.add(Double.parseDouble(norm));
                }

                if (currentIndicator != null) {
                    chart.removeSeries(currentIndicator);
                    chart.removeSeries("Норма");
                }

                XYSeries indicatorSeries = chart.addSeries(indicator, dates, values);
                XYSeries normSeries = chart.addSeries("Норма", dates, norms);
                if (dates.size() > 1) { normSeries.setMarkerColor(new Color(0, 0, 0, 0)); }
                chartPanel.repaint();
                currentIndicator = indicator;
            }
        });
        // Add indicator for the special patient to a database
        tabbedPane.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final String name = tabbedPane.getAddName().trim(); // Name
                final String surname = tabbedPane.getAddSurname().trim(); // Surname
                final String patronymic = tabbedPane.getAddPatronymic().trim(); // Patronymic
                final String indicator = tabbedPane.getAddIndicator().trim(); // Indicator
                final String value = tabbedPane.getAddValue().trim(); // Value
                final String patientId = name.toLowerCase() + surname.toLowerCase() + patronymic.toLowerCase(); // Patient ID

                if (patientId.isEmpty() || indicator.isEmpty() || value.isEmpty()) { return; } // Patient ID / indicator / value is empty

                if (!patientsCache.has(name, surname, patronymic)) { // Add patient to a patients cache
                    patientsCache.add(name, surname, patronymic);
                }

                String data = database.read(patientId); // JSON data from a database

                Patient patient = null;
                if (data == null) { // There's no patient with such patient ID
                    patient = new Patient(patientId); // Create new patient object
                } else { // There's a patient in a database
                    patient = JSON.fromJson(data, Patient.class); // Get existing patient
                }

                if (patient.getIndicatorValues(indicator.toLowerCase()) == null) { // There's no indicator with such name
                    String norm = JOptionPane.showInputDialog(self, "Будь ласка, введіть нормальне значення даного індикатора:", "Введення даних", JOptionPane.INFORMATION_MESSAGE);
                    patient.setIndicatorNorm(indicator.toLowerCase(), norm);
                }
                patient.addValue(indicator.toLowerCase(), value.toLowerCase()); // Add indicator value to a patient object

                database.save(patientId, JSON.toJson(patient)); // Save it to a database
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
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent event) { // Close event handler
                patientsCache.save(); // Save a patients cache
            }

            public void windowOpened(WindowEvent event) {}
            public void windowClosed(WindowEvent event) {}
            public void windowIconified(WindowEvent event) {}
            public void windowDeiconified(WindowEvent event) {}
            public void windowActivated(WindowEvent event) {}
            public void windowDeactivated(WindowEvent event) {}
        });
        this.setMinimumSize(new Dimension(800, 600)); // Minimum size
        this.setSize(new Dimension(800, 600)); // Size
        this.setResizable(true); // Resizable
        this.setJMenuBar(menuBar); // Menu bar

        // Add components
        this.add(rootPanel);

        // Visibility
        this.setVisible(true);
    }
}
