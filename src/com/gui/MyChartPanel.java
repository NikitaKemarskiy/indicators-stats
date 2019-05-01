package com.gui;

import org.knowm.xchart.*;

import javax.swing.*;

class MyChartPanel extends XChartPanel {
    // Private
    private XYChart chart;

    // Public
    MyChartPanel(XYChart chart) {
        super(chart);
        this.chart = chart;
    }
}
