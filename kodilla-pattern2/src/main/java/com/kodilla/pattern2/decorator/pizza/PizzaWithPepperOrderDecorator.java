package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWithPepperOrderDecorator extends AbstractPizzaOrderDecorator{
    public PizzaWithPepperOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCosts() {
        return super.getCosts().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", pepper";
    }
}
