package com.kodilla.good.patterns.food2door.order;

public class SingleOrder {
    private final Product product;
    private final int quantity;

    public SingleOrder(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
