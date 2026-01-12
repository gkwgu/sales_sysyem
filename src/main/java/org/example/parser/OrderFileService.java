package org.example.parser;

import org.example.exception.IORuntimeException;
import org.example.model.Order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderFileService {

    private final OrderParser parser;

    public OrderFileService(OrderParser parser) {
        this.parser = parser;
    }

    public List<Order> readOrders(String filename) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                orders.add(parser.parse(line));
            }
        }
        catch (IOException e) {
            throw new IORuntimeException(
                    "Ошибка чтения файла: " + filename, e
            );
        }

        return orders;
    }

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