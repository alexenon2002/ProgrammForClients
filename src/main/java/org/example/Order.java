package org.example;

public class Order {

    private final String dateOfPurchaseOfCement;
    private final String buyer;
    private final int numberOfKilograms;

    public Order(String dateOfPurchaseOfCement, String buyer, int numberOfKilograms) {
        this.dateOfPurchaseOfCement = dateOfPurchaseOfCement;
        this.buyer = buyer;
        this.numberOfKilograms = numberOfKilograms;
    }

    public String getDateOfPurchaseOfCement() {
        return dateOfPurchaseOfCement;
    }

    public String getBuyer() {
        return buyer;
    }

    public int getNumberOfKilograms() {
        return numberOfKilograms;
    }
}