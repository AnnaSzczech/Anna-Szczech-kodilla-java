package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsFileEngineTestSuite {
    private static SettingsFileEngine settingsFileEngine;

    @BeforeClass
    public static void openSettingsFile(){
        SettingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile(){
        SettingsFileEngine.getInstance().close();
    }

    @Test
    public void testGetNameFile(){
        //given
        //when
        String nameFile = SettingsFileEngine.getInstance().getFileName();
        System.out.println("Opened: " + nameFile);
        //then
        Assert.assertEquals("myapp.settings", nameFile);
    }

    @Test
    public void testLoadSettings(){
        //given
        //when
        boolean result = SettingsFileEngine.getInstance().loadSettings();
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testSaveSettings(){
        //given
        //when
        boolean result = SettingsFileEngine.getInstance().saveSettings();
        //then
        Assert.assertTrue(result);
    }
}
