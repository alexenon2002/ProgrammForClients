package org.appForClients.service;

public class CalculationProgram{

    private final double bagPrice;
    private final int bagWeight;
    private final int startDiscount;
    private final int discountStep;

    public CalculationProgram(double bagPrice,
                             int bagWeight,
                             int startDiscount,
                             int discountStep) {
        this.bagPrice = bagPrice;
        this.bagWeight = bagWeight;
        this.startDiscount = startDiscount;
        this.discountStep = discountStep;
    }

    public double getBagPrice() {
        return bagPrice;
    }

    public int getBagWeight() {
        return bagWeight;
    }

    public int getStartDiscount() {
        return startDiscount;
    }

    public int getDiscountStep() {
        return discountStep;
    }
}