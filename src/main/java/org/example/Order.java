package org.example;

public class Order {

    private final String data;
    private final String clients;
    private final int mass;

    public Order(String data, String clients, int mass) {
        this.data = data;
        this.clients = clients;
        this.mass = mass;
    }

    public String getData() {
        return data;
    }

    public String getClients() {
        return clients;
    }

    public int getMass() {
        return mass;
    }
}