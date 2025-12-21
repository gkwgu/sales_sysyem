package org.example.writer;

import org.example.exception.IORuntimeException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class OrderResultWriter {
    public void write(String filename, Map<String, Double> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (var entry : data.entrySet()) {
                writer.write("<" + entry.getKey() + ">" +  " - " + "<" + entry.getValue()+ ">");
                writer.newLine();
            }
        }
        catch (IOException e) {
            throw new IORuntimeException(
                    "Ошибка чтения файла: " + filename, e
            );
        }
    }
}
