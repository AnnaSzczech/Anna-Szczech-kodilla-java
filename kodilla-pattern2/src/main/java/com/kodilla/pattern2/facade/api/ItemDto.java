package com.kodilla.pattern2.facade.api;

public class ItemDto {
    private final Long productId;
    private final double guantity;

    public ItemDto(Long productId, double guantity) {
        this.productId = productId;
        this.guantity = guantity;
    }

    public Long getProductId() {
        return productId;
    }

    public double getGuantity() {
        return guantity;
    }
}
