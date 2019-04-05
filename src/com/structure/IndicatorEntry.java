package com.structure;

import java.util.Date;

public class IndicatorEntry {
    // Private
    private Date date;
    private String value;

    // Public
    public IndicatorEntry(Date date, String value) {
        this.date = date;
        this.value = value;
    }

    // Getters
    public Date getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }
}
