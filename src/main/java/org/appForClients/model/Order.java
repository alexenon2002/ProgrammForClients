package org.appForClients.model;

import java.time.LocalDateTime;

public record Order(LocalDateTime dateOfPurchaseOfCement, String buyer, int numberOfKilograms) {

}