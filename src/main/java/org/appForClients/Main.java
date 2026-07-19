package org.appForClients;

import org.appForClients.service.CalculationProgram;
import org.appForClients.service.OrderService;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        CalculationProgram config = new CalculationProgram(
                500,
                50,
                50,
                5
        );

        OrderService orderService = new OrderService();

        orderService.process("discount_day.txt", config);
        orderService.process("discount_day_without_ext", config);
    }
}