package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "discount_day.txt";

        ReaderForOrder reader;

        if (fileName.endsWith(".txt")) {
            reader = new FileWithTxt();
        } else {
            reader = new HashAdapter();
        }

        List<Order> orders = reader.read(fileName)
                .stream()
                .sorted(Comparator.comparing(Order::getData))
                .toList();

        AtomicInteger discount = new AtomicInteger(50);

        List<String> result = orders.stream()
                .map(order -> {

                    double bags = order.getMass() / 50.0;
                    double price = bags * 500;
                    double total = price * (100 - discount.get()) / 100;

                    discount.updateAndGet(d -> Math.max(0, d - 5));

                    return order.getClients() + " - " + String.format("%.2f", total);
                })
                .toList();

        Files.write(Paths.get("result.txt"), result);

        result.forEach(System.out::println);
    }
}