package com.structure;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Patient {
    // Private
    private String name;
    private Map<String, Indicator> indicators;

    // Initialization block
    {
        indicators = new HashMap<>();
    }

    // Public
    public Patient(String name) {
        this.name = name;
    }

    public void addValue(String indicator, String value) {
        if (!indicators.containsKey(indicator)) { // Indicator is new
            indicators.put(indicator, new Indicator(indicator)); // Put new indicator object to the indicators Map
        }
        indicators.get(indicator).addValue(value); // Add value to the indicator
    }

    // Getters
    public List<IndicatorEntry> getIndicatorValues(String indicator) {
        if (!indicators.containsKey(indicator)) { // There's no indicator with such name
            return null;
        }
        return indicators.get(indicator).getValues(); // Return list of values
    }

    public String getIndicatorNorm(String indicator) {
        if (!indicators.containsKey(indicator)) { // There's no indicator with such name
            return null;
        }
        return indicators.get(indicator).getNorm(); // Return norm
    }

    // Setters
    public void setIndicatorNorm(String indicator, String norm) {
        if (!indicators.containsKey(indicator)) { // Indicator is new
            indicators.put(indicator, new Indicator(indicator)); // Put new indicator object to the indicators Map
        }
        indicators.get(indicator).setNorm(norm);
    }
}
