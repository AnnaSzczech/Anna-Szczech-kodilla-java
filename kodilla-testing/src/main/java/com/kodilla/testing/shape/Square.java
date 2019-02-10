package com.kodilla.testing.shape;

public class Square implements Shape{
    private String name;
    private double sideA;

    public Square(double sideA, String name) {
        this.sideA = sideA;
        this.name = name;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return sideA*sideA;
    }

    @Override
    public String toString(){
        return getShapeName() + ", pole: " + getField();
    }
}
