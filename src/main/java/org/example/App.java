package org.example;


import org.example.model.Order;
import org.example.service.OrderParser;
import org.example.service.OrderService;
import org.example.service.ResultWriter;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        OrderParser parser = new OrderParser();
        OrderService service = new OrderService();
        ResultWriter writer = new ResultWriter();

        List<Order> orders = parser.readOrders("discount_day.txt");
        Map<String, Double> result = service.process(orders);
        writer.write("result.txt", result);
    }
}