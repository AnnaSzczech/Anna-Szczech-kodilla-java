package com.kodilla.rps;

import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.Player;
import com.kodilla.rps.movement.moves.*;
import org.junit.*;

import java.util.List;

public class PlayerTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nAll tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("\nPreparing to execute test #" + testCounter);
    }

    @Test
    public void testIsWin(){
        //given
        Player lizard = new Lizard();
        Player spock = new Spock();
        Player scisors = new Scissors();
        Player rock = new Rock();
        //when
        //then
        Assert.assertTrue(lizard.isWin(spock.getMove()));
        Assert.assertTrue(rock.isWin(scisors.getMove()));
        Assert.assertFalse(spock.isWin(lizard.getMove()));
        Assert.assertFalse(scisors.isWin(rock.getMove()));
    }

    @Test
    public void testWhichMoveComputerShouldChooseToWin(){
        //given
        Player scissors = new Scissors();
        //when
        List<Move> winningMove = scissors.whichMoveComputerShouldChooseToWin();
        //then
        Assert.assertEquals(2, winningMove.size());
        Assert.assertEquals("rock", winningMove.get(0).toString());
        Assert.assertEquals("spock", winningMove.get(1).toString());
    }
}
