package com.structure;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Indicator {
    // Private
    private String name;
    private String norm;
    private List<IndicatorEntry> values;

    // Initialization block
    {
        norm = null;
        values = new LinkedList<>();
    }

    // Public
    public Indicator(String name) {
        this.name = name;
    }

    public void addValue(String value) {
        Date date = new Date(); // Create new date instance that represents current time
        values.add(new IndicatorEntry(date, value));
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getNorm() {
        return norm;
    }

    public List<IndicatorEntry> getValues() {
        return values;
    }

    // Setters
    public void setNorm(String norm) {
        this.norm = norm;
    }
}
