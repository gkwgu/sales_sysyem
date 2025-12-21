package org.example;

import org.example.parser.OrderManager;


public class App {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        manager.processor("discount_day.txt","result.txt",0.50, 0.05,0.1);

    }
}