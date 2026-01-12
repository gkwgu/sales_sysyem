package org.example.parser;

import org.example.model.Order;

import java.time.LocalDateTime;

public class OrderParserTxt implements OrderParser {
    @Override
    public Order parse(String line) {
        String[] parts = line.split("\\|");

        LocalDateTime time = LocalDateTime.parse(parts[0]);
        String company = parts[1];
        int weight = Integer.parseInt(parts[2]);

        return new Order(time, company, weight);
    }
}
