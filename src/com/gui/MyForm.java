package com.gui;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyForm extends JFrame {
    // Private
    private MyMenuBar menuBar;
    private JPanel rootPanel;
    private JPanel chartPanel;
    private MyTabbedPane tabbedPane;

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
        panelLeftInner.setLayout(new GridLayout(1, 1));

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

        // Add components
        panelLeftInner.add(tabbedPane);
        panelRightInner.add(chartPanel);
        panelLeft.add(panelLeftInner);
        panelRight.add(panelRightInner);
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close operation
        setMinimumSize(new Dimension(800, 600)); // Minimum size
        setSize(new Dimension(800, 600)); // Size
        setResizable(true); // Resizable
        setJMenuBar(menuBar); // Menu bar

        // Add components
        add(rootPanel);

        /*chart.addSeries("f(x)", new double[] {1.0, 2.0, 3.0}, new double[] {0.7, 2.4, 3.8});
        chart.addSeries("g(x)", new double[] {1.7, 0.0, 1.4}, new double[] {2.7, 2.4, 1.8});

        chart.removeSeries("f(x)");
        chart.removeSeries("g(x)");*/

        // Visibility
        setVisible(true);
    }
}
