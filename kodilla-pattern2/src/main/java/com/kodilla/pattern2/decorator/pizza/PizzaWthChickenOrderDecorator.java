package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWthChickenOrderDecorator extends AbstractPizzaOrderDecorator {
    public PizzaWthChickenOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCosts() {
        return super.getCosts().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", chicken";
    }
}
