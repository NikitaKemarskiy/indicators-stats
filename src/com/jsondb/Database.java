package com.jsondb;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Database {
    // Private
    private Path path;

    // Public
    public Database(Path path) {
        if (!path.isAbsolute()) {
            try {
                path = path.toRealPath();
            } catch (IOException err) {
                err.printStackTrace();
                System.exit(1);
            }
        }
        this.path = path;
    }

    public String read(String id) { // Read the data from file
        String name = Hashing.md5(id);
        String data = "";
        try (FileReader reader = new FileReader(path.resolve(name).toString())) {
            int ch;
            while ((ch = reader.read()) != -1) {
                data += (char) ch;
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
            return null;
        }
        return data;
    }

    public void save(String id, String data) { // Save the data into file with specified id
        String name = Hashing.md5(id);
        try (FileWriter writer = new FileWriter(path.resolve(name).toString())) {
            writer.write(data);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public void remove(String id) {
        String name = Hashing.md5(id);
        File file = new File(path.resolve(name).toString());
        if (!file.exists()) { return; }
        file.delete();
    }

    // Setters
    public void setPath(Path path) {
        this.path = path;
    }

    // Getters
    public Path getPath() {
        return path;
    }
}
