package org.example.service;

import org.example.model.Order;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private DiscountCalculator calculator = new DiscountCalculator();

    public Map<String, Double> process(List<Order> orders) {
        orders.sort(Comparator.comparing(Order::getTime));

        Map<String, Double> result = new LinkedHashMap<>();

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            double price = calculator.calculatePrice(order, i);
            result.put(order.getCompany(), price);
        }
        return result;
    }
}
