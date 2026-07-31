package org.appForClients.model;

import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime dateOfPurchaseOfCement;
    private final String buyer;
    private final int numberOfKilograms;

    public Order(final LocalDateTime dateOfPurchaseOfCement, String buyer, int numberOfKilograms) {
        this.dateOfPurchaseOfCement = dateOfPurchaseOfCement;
        this.buyer = buyer;
        this.numberOfKilograms = numberOfKilograms;
    }

    public LocalDateTime getDateOfPurchaseOfCement() {
        return dateOfPurchaseOfCement;
    }

    public String getBuyer() {
        return buyer;
    }

    public int getNumberOfKilograms() {
        return numberOfKilograms;
    }
}