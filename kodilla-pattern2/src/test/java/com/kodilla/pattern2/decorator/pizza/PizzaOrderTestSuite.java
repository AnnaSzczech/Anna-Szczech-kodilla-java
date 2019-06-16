package com.kodilla.pattern2.decorator.pizza;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaWithCornAndPineappleAndChickenGetCost(){
        //given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaWithCornOrderDecorator(thePizza);
        thePizza = new PizzaWthPineappleOrderDecorator(thePizza);
        thePizza = new PizzaWthChickenOrderDecorator(thePizza);
        //when
        BigDecimal cost = thePizza.getCosts();
        //then
        assertEquals(new BigDecimal(20), cost);
    }

    @Test
    public void testPizzaWithCornAndPineappleAndChickenGetDescription(){
        //given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaWithCornOrderDecorator(thePizza);
        thePizza = new PizzaWthPineappleOrderDecorator(thePizza);
        thePizza = new PizzaWthChickenOrderDecorator(thePizza);
        //when
        String description = thePizza.getDescription();
        //then
        assertEquals("pizza with tomato sauce, ingredients: cheese, corn, pineapple, chicken", description);
    }

    @Test
    public void testPizzaWithBaconAndPepperAndOnionGetCost(){
        //given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaWthBaconOrderDecorator(thePizza);
        thePizza = new PizzaWthBaconOrderDecorator(thePizza);
        thePizza = new PizzaWithPepperOrderDecorator(thePizza);
        thePizza = new PizzaWthOnionOrderDecorator(thePizza);
        //when
        BigDecimal cost = thePizza.getCosts();
        //then
        assertEquals(new BigDecimal(24), cost);
    }

    @Test
    public void testPizzaWithBaconAndPepperAndOnionGetDescription(){
        //given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaWthBaconOrderDecorator(thePizza);
        thePizza = new PizzaWthBaconOrderDecorator(thePizza);
        thePizza = new PizzaWithPepperOrderDecorator(thePizza);
        thePizza = new PizzaWthOnionOrderDecorator(thePizza);
        //when
        String description = thePizza.getDescription();
        //then
        assertEquals("pizza with tomato sauce, ingredients: cheese, bacon, bacon, pepper, onion", description);
    }

    @Test
    public void testBasicPizzaGetCost(){
        //given
        PizzaOrder thePizza = new BasicPizzaOrder();
        //when
        BigDecimal cost = thePizza.getCosts();
        //then
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testBasicPizzaGetDescription(){
        //given
        PizzaOrder thePizza = new BasicPizzaOrder();
        //when
        String description = thePizza.getDescription();
        //then
        assertEquals("pizza with tomato sauce, ingredients: cheese", description);
    }
}