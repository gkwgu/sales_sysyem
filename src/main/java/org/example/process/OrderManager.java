package org.example.process;

import org.example.model.Order;
import org.example.parser.OrderFileService;

import java.util.List;
import java.util.Map;

public class OrderManager {
    private final OrderFileService parser;
    private final OrderService service;

    public OrderManager(OrderFileService parser, OrderService service){
        this.parser = parser;
        this.service = service;

    }

    public void process(String fileReader, String fileWriter, double priceCement, double startDiscount, double discountStep){
        List<Order> orders = parser.readOrders(fileReader);
        Map<String, Double> result = service.process(orders, priceCement, startDiscount, discountStep);
        parser.write(fileWriter, result);

    }

}
