package com.kodilla.pattern2.decorator.taxiportal;

import java.math.BigDecimal;

public abstract class AbstractTaxiOrderDecorator implements TaxiOrder {
    private final TaxiOrder taxiOrder;

    protected AbstractTaxiOrderDecorator(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;
    }

    @Override
    public BigDecimal getCosts() {
        return taxiOrder.getCosts();
    }

    @Override
    public String getDescription() {
        return taxiOrder.getDescription();
    }
}
