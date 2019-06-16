package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCosts() {
        return pizzaOrder.getCosts();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
