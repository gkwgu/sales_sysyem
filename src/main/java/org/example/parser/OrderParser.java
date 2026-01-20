package org.example.parser;

import org.example.model.Order;

public interface OrderParser {
    Order parse (String line);
}
