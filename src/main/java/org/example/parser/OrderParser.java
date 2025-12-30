package org.example.parser;

import org.example.exception.IORuntimeException;
import org.example.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderParser {

    private final IFileParserInterface parser;

    public OrderParser(IFileParserInterface parser) {
        this.parser = parser;
    }

    public List<Order> readOrders(String filename) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                orders.add(parser.parse(line));
            }
        }
        catch (IOException e) {
            throw new IORuntimeException(
                    "Ошибка чтения файла: " + filename, e
            );
        }

        return orders;
    }
}