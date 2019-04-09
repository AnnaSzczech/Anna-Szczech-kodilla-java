package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void log(){
        Logger.getInstance().log("Ania");
    }

    @Test
    public void testGetLastLog(){
        //given
        //when
        String loggerName = Logger.getInstance().getLastLog();
        //then
        Assert.assertEquals("Ania", loggerName);
    }
}
