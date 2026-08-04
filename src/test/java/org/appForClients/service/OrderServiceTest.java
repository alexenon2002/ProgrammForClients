package org.appForClients.service;

import org.appForClients.calculation.CalculationProgram;
import org.appForClients.calculation.OrderCalculator;
import org.appForClients.filter.FileFilter;
import org.appForClients.writer.ResultWriter;
import org.appForClients.model.Order;
import org.appForClients.reader.ReaderForOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @ExtendWith(MockitoExtension.class)

    @Mock
    private static final String FILE_TYPE = "orders.txt";

    @Mock
    private FileFilter fileFilter;

    @Mock
    private OrderCalculator calculator;

    @Mock
    private ResultWriter writer;

    @Mock
    private ReaderForOrder reader;


    @Test
    void shouldProcessOrders() throws IOException {
        OrderService orderService = new OrderService(fileFilter, calculator, writer);

        CalculationProgram calculationProgram =
                new CalculationProgram(300, 40, 25, 3);

        List<Order> orders = List.of(new Order(
                LocalDateTime.of(2025, 10, 10, 22, 25, 10),
                "Alex", 400));

        List<String> result = List.of("Alex : 3000");
        when(fileFilter.getReader(FILE_TYPE))
                .thenReturn(reader);
        when(reader.catalog(FILE_TYPE))
                .thenReturn(orders);
        when(calculator.calculate(orders, calculationProgram))
                .thenReturn(result);
        orderService.process(FILE_TYPE, calculationProgram);
        verify(fileFilter).getReader(FILE_TYPE);
        verify(reader).catalog(FILE_TYPE);
        verify(calculator).calculate(orders, calculationProgram);
        verify(writer).write(result);
    }

    @Test
    void shouldThrowIOExceptionWhenReadingFileFails() throws IOException {
        OrderService orderService = new OrderService(fileFilter, calculator, writer);
        CalculationProgram calculationProgram = new CalculationProgram(400, 40, 40, 4);
        when(fileFilter.getReader(FILE_TYPE))
                .thenReturn(reader);
        when(reader.catalog(FILE_TYPE))
                .thenThrow(new IOException());

        assertThrows(IOException.class,
                () -> orderService.process(FILE_TYPE, calculationProgram));
        verify(calculator, never()).calculate(any(), any());
        verify(writer, never()).write(any());
    }
}