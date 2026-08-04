package org.appForClients.calculation;

import java.util.Objects;

public record CalculationProgram(double bagPrice, int bagWeight, int startDiscount, int discountStep) {

    @Override
    public String toString() {
        return "CalculationProgram[" +
                "bagPrice=" + bagPrice + ", " +
                "bagWeight=" + bagWeight + ", " +
                "startDiscount=" + startDiscount + ", " +
                "discountStep=" + discountStep + ']';
    }


}