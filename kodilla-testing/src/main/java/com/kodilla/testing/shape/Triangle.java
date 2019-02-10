package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name = "triangle";
    private double baseOfTheTriangle;
    private double heightOfTheTriangle;

    public Triangle(double baseOfTheTriangle, double heightOfTheTriangle, String name) {
        this.baseOfTheTriangle = baseOfTheTriangle;
        this.heightOfTheTriangle = heightOfTheTriangle;
        this.name = name;
    }

    @Override
    public String getShapeName() {
        return name;
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
