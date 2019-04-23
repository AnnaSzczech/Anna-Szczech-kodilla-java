package com.kodilla.sudoku;

import com.kodilla.sudoku.logic.Coordinates;
import com.kodilla.sudoku.logic.MagicSquare;
import org.junit.Assert;
import org.junit.Test;

public class MagicSquareTestSuite {

    @Test
    public void testFindCoordinateOfMagicSquare(){
        //given
        MagicSquare magicSquare = new MagicSquare();
        //when
        magicSquare.findCoordinateOfMagicSquare(5, 6);
        //then
        Coordinates coordinates1 = magicSquare.getMagicSquareCoordinates().get(0);
        Coordinates coordinates2 = magicSquare.getMagicSquareCoordinates().get(1);
        Coordinates coordinates3 = magicSquare.getMagicSquareCoordinates().get(2);
        Coordinates coordinates4 = magicSquare.getMagicSquareCoordinates().get(3);
        Coordinates coordinates5 = magicSquare.getMagicSquareCoordinates().get(4);
        Coordinates coordinates6 = magicSquare.getMagicSquareCoordinates().get(5);
        Coordinates coordinates7 = magicSquare.getMagicSquareCoordinates().get(6);
        Coordinates coordinates8 = magicSquare.getMagicSquareCoordinates().get(7);
        System.out.println(magicSquare.getMagicSquareCoordinates());
        Assert.assertEquals(new Coordinates(5, 5), coordinates1);
        Assert.assertEquals(new Coordinates(5, 4), coordinates2);
        Assert.assertEquals(new Coordinates(4, 6), coordinates3);
        Assert.assertEquals(new Coordinates(4, 5), coordinates4);
        Assert.assertEquals(new Coordinates(4, 4), coordinates5);
        Assert.assertEquals(new Coordinates(6, 6), coordinates6);
        Assert.assertEquals(new Coordinates(6, 5), coordinates7);
        Assert.assertEquals(new Coordinates(6, 4), coordinates8);
    }
}
