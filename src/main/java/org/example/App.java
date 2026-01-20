package org.example;

import org.example.parser.OrderParser;
import org.example.process.OrderManager;
import org.example.service.OrderFileService;
import org.example.service.OrderService;
import org.example.parser.OrderParserTxt;


public class App {
    public static void main(String[] args) {
        OrderParser fileParser = new OrderParserTxt();
        OrderFileService orderParser = new OrderFileService(fileParser);
        OrderService service = new OrderService();
        OrderManager manager = new OrderManager(orderParser, service);
        manager.process("discount_day.txt","result.txt",0.50, 0.05,0.1);
    }
}