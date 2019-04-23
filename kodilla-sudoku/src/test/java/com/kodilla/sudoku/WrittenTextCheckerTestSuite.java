package com.kodilla.sudoku;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.game.WrittenTextChecker;
import org.junit.Assert;
import org.junit.Test;

public class WrittenTextCheckerTestSuite {
    private static int counter = 0;

    @Test
    public void testIsTextCorrect() {
        //given
        counter++;
        System.out.println("Test #" + counter + ": testIsTextCorrect (9,9,1).");
        WrittenTextChecker writtenTextChecker = new WrittenTextChecker("9,9,1");
        //when
        boolean result = writtenTextChecker.isTextCorrect();
        //then
        Move move = writtenTextChecker.getMove();
        System.out.println("move: " + move.getCoordinateX() + ", " + move.getCoordinateY() + ", " + writtenTextChecker.getMove().getNumber());
        Assert.assertTrue(result);
    }

    @Test
    public void testIsTextIncorrect() {
        //given
        counter++;
        System.out.println("Test #" + counter + ": testIsTextCorrect (9,9).");
        WrittenTextChecker writtenTextChecker = new WrittenTextChecker("9,9");
        //when
        boolean result = writtenTextChecker.isTextCorrect();
        //then
        System.out.println("move: " + writtenTextChecker.getMove());
        Assert.assertFalse(result);
    }

    @Test
    public void testIsTextIncorrectSecond() {
        //given
        counter++;
        System.out.println("Test #" + counter + ": testIsTextCorrect (s,s,s).");
        WrittenTextChecker writtenTextChecker = new WrittenTextChecker("s,s,s");
        //when
        boolean result = writtenTextChecker.isTextCorrect();
        //then
        System.out.println("move: " + writtenTextChecker.getMove());
        Assert.assertFalse(result);
    }

    @Test
    public void testIsTextIncorrectThird() {
        //given
        counter++;
        System.out.println("Test #" + counter + ": testIsTextCorrect (check).");
        WrittenTextChecker writtenTextChecker = new WrittenTextChecker("check");
        //when
        boolean result = writtenTextChecker.isTextCorrect();
        //then
        System.out.println("move: " + writtenTextChecker.getMove());
        Assert.assertFalse(result);
    }

    @Test
    public void testIsTextIncorrectFourth() {
        //given
        counter++;
        System.out.println("Test #" + counter + ": testIsTextCorrect (6,7,10).");
        WrittenTextChecker writtenTextChecker = new WrittenTextChecker("6,7,10");
        //when
        boolean result = writtenTextChecker.isTextCorrect();
        //then
        System.out.println("move: " + writtenTextChecker.getMove());
        Assert.assertFalse(result);
    }
}
