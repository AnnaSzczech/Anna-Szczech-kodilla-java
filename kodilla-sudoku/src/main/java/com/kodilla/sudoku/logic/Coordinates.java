package com.kodilla.sudoku.logic;

public class Coordinates {
    private final int cordinateX, coordinateY;

    public Coordinates(int cordinateX, int coordinateY) {
        this.cordinateX = cordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCordinateX() {
        return cordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    @Override
    public String toString() {
        return "x: " + cordinateX +
                ", y: " + coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        if (getCordinateX() != that.getCordinateX()) return false;
        return getCoordinateY() == that.getCoordinateY();
    }

    @Override
    public int hashCode() {
        int result = getCordinateX();
        result = 31 * result + getCoordinateY();
        return result;
    }
}
