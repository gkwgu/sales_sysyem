package org.example.process;

import org.example.model.Order;
import org.example.service.OrderFileService;
import org.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderManagerTest {

    @Mock
    private OrderFileService orderFileService;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderManager orderManager;

    @Test
    void process_shouldReadOrdersProcessThemAndWriteResult() {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        double priceCement = 100.0;
        double startDiscount = 10.0;
        double discountStep = 2.0;

        List<Order> orders = List.of(
                mock(Order.class),
                mock(Order.class)
        );

        Map<String, Double> processedResult = Map.of(
                "order1", 180.0,
                "order2", 190.0
        );

        when(orderFileService.readOrders(inputFile)).thenReturn(orders);

        when(orderService.process(
                orders,
                priceCement,
                startDiscount,
                discountStep
        )).thenReturn(processedResult);

        orderManager.process(
                inputFile,
                outputFile,
                priceCement,
                startDiscount,
                discountStep
        );

        verify(orderFileService).readOrders(inputFile);
        verify(orderService).process(
                orders,
                priceCement,
                startDiscount,
                discountStep
        );
        verify(orderFileService).write(outputFile, processedResult);
    }

}