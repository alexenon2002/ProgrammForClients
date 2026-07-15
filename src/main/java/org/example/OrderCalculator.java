package org.example;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderCalculator {

    private static final double BAG_PRICE = 500;
    private static final int BAG_WEIGHT = 50;
    private static final int START_DISCOUNT = 50;
    private static final int DISCOUNT_STEP = 5;

    public List<String> calculate(List<Order> orders) {

        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparing(Order::getDateOfPurchaseOfCement))
                .toList();

        List<String> result = new ArrayList<>();

        int discount = START_DISCOUNT;

        for (Order order : sortedOrders) {

            double bags = (double) order.getNumberOfKilograms() / BAG_WEIGHT;
            double price = bags * BAG_PRICE;
            double total = price * (100 - discount) / 100.0;

            result.add(order.getBuyer() + " - " + String.format("%.2f", total));

            discount = Math.max(0, discount - DISCOUNT_STEP);
        }

        return result;
    }
}