package org.example;

import org.example.parser.IFileParserInterface;
import org.example.parser.OrderManager;
import org.example.parser.OrderParser;
import org.example.parser.OrderService;
import org.example.parser.TxtFileParser;
import org.example.writer.OrderResultWriter;


public class App {
    public static void main(String[] args) {
        IFileParserInterface fileParser = new TxtFileParser();
        OrderParser orderParser = new OrderParser(fileParser);
        OrderService service = new OrderService();
        OrderResultWriter writer = new OrderResultWriter();
        OrderManager manager = new OrderManager(orderParser, service, writer);
        manager.process("discount_day.txt","result.txt",0.50, 0.05,0.1);
    }
}