package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWthOnionOrderDecorator extends AbstractPizzaOrderDecorator {
    public PizzaWthOnionOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCosts() {
        return super.getCosts().add(new BigDecimal(1));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", onion";
    }
}
