package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWthExtraCheeseOrderDecorator extends AbstractPizzaOrderDecorator {
    public PizzaWthExtraCheeseOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCosts() {
        return super.getCosts().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", extra cheese";
    }
}
