package com.kodilla.sudoku.logic;

import java.util.ArrayList;
import java.util.List;

public class MagicSquare {
    private final List<Coordinates> magicSquareCoordinates;

    public MagicSquare(){
        magicSquareCoordinates = new ArrayList<>();
    }

    public void findCoordinateOfMagicSquare(int indexOfCoordinateX, int indexOfCoordinateY) {
        for (int x : getIndexOfMagicSquare(indexOfCoordinateX)) {
            for (int y : getIndexOfMagicSquare(indexOfCoordinateY)){
                magicSquareCoordinates.add(new Coordinates(x, y));
            }
        }
        magicSquareCoordinates.remove(0);
    }

    private int[] getIndexOfMagicSquare(int indexOfNumber) {
        int index1, index2;
        if (indexOfNumber % 3 == 0) {
            index1 = indexOfNumber - 1;
            index2 = indexOfNumber - 2;
            return new int[]{indexOfNumber, index1, index2};
        } else if (indexOfNumber % 3 == 1) {
            index1 = indexOfNumber + 1;
            index2 = indexOfNumber + 2;
            return new int[]{indexOfNumber, index1, index2};
        } else {
            index1 = indexOfNumber - 1;
            index2 = indexOfNumber + 1;
            return new int[]{indexOfNumber, index1, index2};
        }
    }

    public List<Coordinates> getMagicSquareCoordinates() {
        return magicSquareCoordinates;
    }
}
