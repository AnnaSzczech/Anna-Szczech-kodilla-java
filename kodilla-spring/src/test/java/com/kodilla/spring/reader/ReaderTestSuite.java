package com.kodilla.spring.reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderTestSuite {

    @Test
    public void testRead(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Reader reader = context.getBean(Reader.class);
        // when & then
        reader.read();
    }

    @Test
    public void testConditional(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        //when
        boolean book2Exists = context.containsBean("book2");
        //then
        System.out.println("Bean book2 was found in the container: " + book2Exists);
    }
}
