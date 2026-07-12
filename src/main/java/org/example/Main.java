package org.example;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "discount_day.txt";
        // String fileName = "discount_day_without_ext";

        OrderService service = new OrderService();

        service.process(fileName);
    }
}