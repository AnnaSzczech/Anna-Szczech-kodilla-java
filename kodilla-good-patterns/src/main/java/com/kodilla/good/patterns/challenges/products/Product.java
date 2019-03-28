package com.kodilla.good.patterns.challenges.products;

abstract public class Product {
    private final double price;
    private final String product;

    public Product(double price, String product) {
        this.price = price;
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return product;
    }
}
