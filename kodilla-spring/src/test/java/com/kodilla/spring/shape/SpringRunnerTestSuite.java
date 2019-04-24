package com.kodilla.spring.shape;

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
        Shape shape = (Shape) context.getBean("circle");
        //when
        String result = shape.getShapeName();
        //then
        Assert.assertEquals("This is a circle.", result);
    }

    @Test
    public void testTriangleLoadedIntoContainer(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("triangle");
        //when
        String result = shape.getShapeName();
        //then
        Assert.assertEquals("This is a triangle.", result);
    }

    @Test
    public void testShapeLoadedIntoContainer(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape =(Shape) context.getBean("chooseShape");
        //when
        String result = shape.getShapeName();
        //then
        System.out.println("Chosen shape says: " + result);
    }
}
