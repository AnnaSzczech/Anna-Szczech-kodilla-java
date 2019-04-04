package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testAdd(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //when
        double result = calculator.add(3, 2);
        //then
        Assert.assertEquals(5, result, 0.01);
    }

    @Test
    public void testSub(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //when
        double result = calculator.sub(3, 2);
        //then
        Assert.assertEquals(1, result, 0.01);
    }

    @Test
    public void tesMul(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //when
        double result = calculator.mul(3, 2);
        //then
        Assert.assertEquals(6, result, 0.01);
    }

    @Test
    public void testDiv(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //when
        double result = calculator.div(3, 2);
        //then
        Assert.assertEquals(1.5, result, 0.01);
    }
}
