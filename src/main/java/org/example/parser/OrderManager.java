package org.example.parser;

import org.example.model.Order;
import org.example.writer.OrderResultWriter;

import java.util.List;
import java.util.Map;

public class OrderManager {
    private final OrderParser parser;
    private final OrderService service;
    private final OrderResultWriter writer;

    public OrderManager(OrderParser parser, OrderService service, OrderResultWriter writer){
        this.parser = parser;
        this.service = service;
        this.writer = writer;

    }

    public void process(String fileReader, String fileWriter, double priceCement, double startDiscount, double discountStep){
        List<Order> orders = parser.readOrders(fileReader);
        Map<String, Double> result = service.process(orders, priceCement, startDiscount, discountStep);
        writer.write(fileWriter, result);

    }

}
