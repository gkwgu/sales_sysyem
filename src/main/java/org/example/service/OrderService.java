package org.example.service;

import org.example.model.Order;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    public Map<String, Double> process(List<Order> orders,double priceCement, double startDiscount, double discountStep) {
        orders.sort(Comparator.comparing(Order::getDateTime));

        Map<String, Double> result = new LinkedHashMap<>();

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            double price = calculatePrice(order, i, startDiscount, discountStep,priceCement);
            result.merge(order.getCompany(), price, Double::sum);
        }
        return result;
    }

    private double calculatePrice(Order order, int orderIndex, double startDiscount, double discountStep, double priceCement){
        double discount = startDiscount - orderIndex * discountStep;
        if (discount < 0) {
            discount = 0;
        }
        double total = order.getWeight() * priceCement;
        return total * (1-discount);

    }
}
