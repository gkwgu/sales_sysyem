package org.example.service;

import org.example.model.Order;

public class DiscountCalculator {
    private static final double start_discount = 0.50;
    private static final double discount_step = 0.05;
    private static final double price_cement = 0.1;

    public double calculatePrice(Order order, int OrderIndex){
        double discount = start_discount - OrderIndex * discount_step;
        if (discount<0) discount = 0;

        double total = order.getWeight() * price_cement;
        return total * (1-discount);

    }
}
