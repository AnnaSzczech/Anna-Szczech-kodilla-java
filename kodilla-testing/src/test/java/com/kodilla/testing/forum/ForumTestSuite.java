package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ForumTestSuite {
    @Test
    public void testCaseUsername () {

        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        //When
        String result = simpleUser.getUsername();


        //Then
        Assert.assertEquals("theForumUser", result);
    }

}
