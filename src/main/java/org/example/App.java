package org.example;

import org.example.parser.OrderManager;
import org.example.parser.OrderParser;
import org.example.parser.OrderService;
import org.example.writer.OrderResultWriter;


public class App {
    public static void main(String[] args) {
        OrderParser parser = new OrderParser();
        OrderService service = new OrderService();
        OrderResultWriter writer = new OrderResultWriter();
        OrderManager manager = new OrderManager(parser, service, writer);
        manager.process("discount_day.txt","result.txt",0.50, 0.05,0.1);
    }
}