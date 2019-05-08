package com.cache;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.LinkedList;

public class PatientCache {
    // Private
    private List<Patient> patients;

    private static final File cache;
    private static final String path = "cache/cache.json";
    private static final Gson JSON = new Gson(); // Gson object for serializing / deserializing JSON data
    private static final int dataSize = 5;

    // Static initialization block
    static {
        cache = new File(path);
    }

    // Public
    public PatientCache() {
        init();
    }

    public void init() {
        String data = "";
        try (FileReader reader = new FileReader(cache)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                data += (char) ch;
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
            patients = new LinkedList<>();
            return;
        }
        if (data.isEmpty()) {
            patients = new LinkedList<>();
            return;
        }
        Type type = new TypeToken<List<Patient>>(){}.getType();
        patients = JSON.fromJson(data, type);
    }

    public void save() { // Method that saves a cache into a file
        try (FileWriter writer = new FileWriter(cache)) {
            writer.write(JSON.toJson(patients));
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public void add(String name, String surname, String patronymic) { // Method that adds patient to a cache
        patients.add(new Patient(name, surname, patronymic));
    }


    public List<String> get(String buff) { // Method that gets patients from a cache
        List<String> data = new LinkedList<>();
        int size = 0;
        for (Patient patient : patients) {
            if (patient.getName().contains(buff) && !data.contains(patient.getName())) {
                data.add(patient.getName());
                size++;
                continue;
            }
            if (patient.getSurname().contains(buff) && !data.contains(patient.getSurname())) {
                data.add(patient.getSurname());
                size++;
                continue;
            }
            if (patient.getPatronymic().contains(buff) && !data.contains(patient.getPatronymic())) {
                data.add(patient.getPatronymic());
                size++;
                continue;
            }
        }
        return data;
    }

    public boolean has(String name, String surname, String patronymic) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name) && patient.getSurname().equals(surname) && patient.getPatronymic().equals(patronymic)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Patient patient : patients) {
            System.out.println(patient.getName() + " " + patient.getSurname() + " " + patient.getPatronymic());
        }
    }
}

class Patient {
    // Private
    private String name;
    private String surname;
    private String patronymic;

    // Public
    Patient(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getPatronymic() {
        return patronymic;
    }
}