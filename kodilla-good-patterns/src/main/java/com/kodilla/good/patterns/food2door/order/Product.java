package com.kodilla.good.patterns.food2door.order;

public class Product {
    private String name;
    private boolean isAvailable;
    private double price;

    public Product(String name, boolean isAvailable, double price) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPrice() {
        return price;
    }
}
