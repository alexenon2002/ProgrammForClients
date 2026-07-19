package org.appForClients.service;

import org.appForClients.model.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderCalculator {

    public List<String> calculate(List<Order> orders,
                                  CalculationProgram config) {

        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparing(Order::getDateOfPurchaseOfCement))
                .toList();

        List<String> result = new ArrayList<>();

        int discount = config.getStartDiscount();

        for (Order order : sortedOrders) {

            double bags = (double) order.getNumberOfKilograms()
                    / config.getBagWeight();

            double price = bags * config.getBagPrice();

            double total = price * (100 - discount) / 100.0;

            result.add(order.getBuyer() + " - " + String.format("%.2f", total));

            discount = Math.max(0,
                    discount - config.getDiscountStep());
        }

        return result;
    }
}