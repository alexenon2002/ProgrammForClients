package org.appForClients;

import org.appForClients.service.OrderService;

import java.io.IOException;

public class Main {

    static void main(String[] args) throws IOException {

        OrderService orderService = new OrderService();

        orderService.process("discount_day.txt");
        orderService.process("discount_day_without_ext");

    }
}