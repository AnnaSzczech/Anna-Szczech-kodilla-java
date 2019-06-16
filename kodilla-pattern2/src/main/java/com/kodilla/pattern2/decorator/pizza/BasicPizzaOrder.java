package com.kodilla.pattern2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCosts() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "pizza with tomato sauce, ingredients: cheese";
    }
}
