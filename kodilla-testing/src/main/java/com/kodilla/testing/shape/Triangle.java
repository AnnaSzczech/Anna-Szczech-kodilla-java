package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double baseOfTheTriangle;
    private double heightOfTheTriangle;

    public Triangle(double baseOfTheTriangle, double heightOfTheTriangle) {
        this.baseOfTheTriangle = baseOfTheTriangle;
        this.heightOfTheTriangle = heightOfTheTriangle;
    }

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return 0.5*(baseOfTheTriangle*heightOfTheTriangle);
    }

    @Override
    public String toString(){
        return getShapeName() + ", pole: " + getField();
    }
}
