package com.kodilla.sudoku.game;

public class Move {
    private final int coordinateX;
    private final int coordinateY;
    private final int number;

    public Move(int coordinateX, int coordinateY, int number) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.number = number;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getNumber() {
        return number;
    }
}
