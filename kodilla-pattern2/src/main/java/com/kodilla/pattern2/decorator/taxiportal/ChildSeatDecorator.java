package com.kodilla.pattern2.decorator.taxiportal;

import java.math.BigDecimal;

public class ChildSeatDecorator extends AbstractTaxiOrderDecorator {
    public ChildSeatDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCosts() {
        return super.getCosts().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + child seat";
    }
}
