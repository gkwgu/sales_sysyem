package org.example.service;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.parser.OrderParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderFileServiceTest {

    @Mock
    private OrderParser parser;

    private final String outputFile = "test-output.txt";

    @AfterEach
    void cleanUp() {
        File file = new File(outputFile);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void readOrders_shouldReadAllLinesAndParseThem() {
        OrderFileService service = new OrderFileService(parser);

        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        Order order3 = mock(Order.class);

        when(parser.parse("2021-02-09T16:00:22|Industrial|8800"))
                .thenReturn(order1);
        when(parser.parse("2021-02-09T08:42:59|Power Engineer|17480"))
                .thenReturn(order2);
        when(parser.parse("2021-02-09T10:48:34|Mosque|33120"))
                .thenReturn(order3);

        String filePath = getClass()
                .getClassLoader()
                .getResource("test-input.txt")
                .getFile();

        List<Order> orders = service.readOrders(filePath);

        assertEquals(3, orders.size());
        verify(parser, times(3)).parse(anyString());
    }

    @Test
    void readOrders_shouldReturnEmptyListIfFileIsEmpty() {
        OrderFileService service = new OrderFileService(parser);

        String filePath = getClass()
                .getClassLoader()
                .getResource("empty.txt")
                .getFile();

        List<Order> orders = service.readOrders(filePath);

        assertTrue(orders.isEmpty());
        verifyNoInteractions(parser);
    }

    @Test
    void readOrders_shouldThrowExceptionIfFileNotFound() {
        OrderFileService service = new OrderFileService(parser);

        assertThrows(
                IORuntimeException.class,
                () -> service.readOrders("not-exists.txt")
        );
    }

    @Test
    void write_shouldCreateFileAndWriteData() {
        OrderFileService service = new OrderFileService(parser);

        Map<String, Double> data = Map.of(
                "Industrial", 8800.0,
                "Power Engineer", 17480.0
        );

        service.write(outputFile, data);

        File file = new File(outputFile);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}