package org.example.parser;

import org.example.model.Order;
import org.example.writer.OrderResultWriter;

import java.util.List;
import java.util.Map;

public class OrderManager {

    public void processor(String fileReader, String fileWriter, double priceCement, double startDiscount, double discountStep){
        OrderParser parser = new OrderParser();
        OrderService service = new OrderService();
        OrderResultWriter writer = new OrderResultWriter();

        List<Order> orders = parser.readOrders(fileReader);
        Map<String, Double> result = service.process(orders, priceCement, startDiscount, discountStep);
        writer.write(fileWriter, result);

    }

}
