package org.example.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ResultWriter {
    public void write(String filename, Map<String, Double> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (var entry : data.entrySet()) {
                writer.write("<" + entry.getKey() + ">" +  " - " + "<" + entry.getValue()+ ">");
                writer.newLine();
            }
        }
    }
}
