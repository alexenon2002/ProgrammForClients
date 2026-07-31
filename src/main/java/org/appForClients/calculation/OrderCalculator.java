package org.appForClients.calculation;

import org.appForClients.model.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderCalculator {

    public List<String> calculate(List<Order> orders, CalculationProgram config) {

        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparing(Order::dateOfPurchaseOfCement))
                .toList();

        List<String> result = new ArrayList<>();

        int discount = config.startDiscount();

        for (Order order : sortedOrders) {

            double bags = (double) order.numberOfKilograms() / config.bagWeight();

            double price = bags * config.bagPrice();

            double total = price * (100 - discount) / 100.0;

            result.add(order.buyer() + " - " + String.format("%.2f", total));

            discount = Math.max(0, discount - config.discountStep());
        }

        return result;
    }
}