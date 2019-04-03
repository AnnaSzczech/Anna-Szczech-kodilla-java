package com.kodilla.spring;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTestSuite {

    @Test
    public void testCircleLoadedIntoContainer(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Circle.class);
        //when
        String result = shape.getShapeName();
        //then
        Assert.assertEquals("This is a circle.", result);
    }

    @Test
    public void testTriangleLoadedIntoContainer(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Triangle.class);
        //when
        String result = shape.getShapeName();
        //then
        Assert.assertEquals("This is a triangle.", result);
    }
}
