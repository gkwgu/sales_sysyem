package org.example.parser;

import org.example.model.Order;

public interface IFileParserInterface {
    Order parse (String line);
}
