package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWithCornOrderDecorator extends AbstractPizzaOrderDecorator {
    public PizzaWithCornOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCosts() {
        return super.getCosts().add(new BigDecimal(1));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", corn";
    }
}
