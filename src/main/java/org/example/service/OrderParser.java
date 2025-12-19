package org.example.service;

import org.example.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderParser {

    public List<Order> readOrders(String filename) throws IOException {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                orders.add(parse(line));
            }
        }

        return orders;
    }

    public Order parse(String line) {
        String[] parts = line.split("\\|");

        LocalDateTime time = LocalDateTime.parse(parts[0]);
        String company = parts[1];
        int weight = Integer.parseInt(parts[2]);

        return new Order(time, company, weight);
    }
}