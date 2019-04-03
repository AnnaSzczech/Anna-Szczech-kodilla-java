package com.kodilla.forum;

import com.kodilla.spring.Application;
import com.kodilla.spring.forum.ForumUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ForumUserTestSuite {
    @Test
    public void testGetUserName(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser user = context.getBean(ForumUser.class);
        //when
        String result = user.getUserName();
        //then
        Assert.assertEquals("John Smith", result);
    }
}
