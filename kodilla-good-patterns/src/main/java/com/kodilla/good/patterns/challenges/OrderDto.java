package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.products.Product;

public class OrderDto {
    private final Product product;
    private final boolean isAvailable;

    public OrderDto(Product product, boolean isAvailable) {
        this.product = product;
        this.isAvailable = isAvailable;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
