package org.example.service;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.parser.OrderParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderFileService {

    private final OrderParser parser;

    public OrderFileService(OrderParser parser) {
        this.parser = parser;
    }

    public List<Order> readOrders(String filename) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filename))) {

           return bufferedReader.lines().map(parser::parse).collect(Collectors.toList());
        }
        catch (IOException e) {
            throw new IORuntimeException(
                    "Ошибка чтения файла: " + filename, e
            );
        }
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