package org.example;

import org.example.Order;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderCalculator {

    public List<String> calculate(List<Order> orders) {

        AtomicInteger discount = new AtomicInteger(50);

        return orders.stream()

                .sorted(Comparator.comparing(Order::getDateOfPurchaseOfCement))

                .map(order -> {

                    double bags = order.getNumberOfKilograms()/ 50.0;

                    double price = bags * 500;

                    double total = price * (100 - discount.get()) / 100;

                    discount.updateAndGet(d -> Math.max(0, d - 5));

                    return order.getBuyer() + " - " + String.format("%.2f", total);

                })

                .toList();

    }

}