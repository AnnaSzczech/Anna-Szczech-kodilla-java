package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.products.Product;

import java.time.LocalDate;

public class OrderRequest {
    private final User user;
    private final LocalDate dateOfOrder;
    private final Product orderedProduct;
    private final int quantityOfProduct;

    public OrderRequest(User user, LocalDate dateOfOrder, Product orderedProduct, int quantityOfProduct) {
        this.user = user;
        this.dateOfOrder = dateOfOrder;
        this.orderedProduct = orderedProduct;
        this.quantityOfProduct = quantityOfProduct;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public int getQuantityOfProduct() {
        return quantityOfProduct;
    }

    @Override
    public String toString() {
        return user + "/" + dateOfOrder + "/" + orderedProduct + "/" + quantityOfProduct + "*" + orderedProduct.getPrice();
    }
}
