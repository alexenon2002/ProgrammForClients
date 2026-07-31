package org.appForClients.calculation;

import org.appForClients.model.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {

    @Test
    void calculate() {

        List<String> newOrders = List.of();

        Order first = new Order(LocalDateTime.of
                (2026, 11, 8, 20, 15),
                "Alex", 243);

        Order second = new Order(LocalDateTime.of
                (2026, 11, 8, 20, 15),
                "Max", 135);

        CalculationProgram calculationProgram = new CalculationProgram
                (200.5, 40, 35, 3);

        OrderCalculator orderCalculator = new OrderCalculator();

        List<String> result = orderCalculator.
                calculate(List.of(first, second), calculationProgram);
        assertEquals("Alex - 791,72", result.getFirst());
        assertEquals("Max - 460,15", result.getLast());
        assertTrue(newOrders.isEmpty());

    }
}