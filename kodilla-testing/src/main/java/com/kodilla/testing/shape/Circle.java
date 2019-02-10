package com.kodilla.testing.shape;

public class Circle implements Shape{
    private String name = "circle";
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString(){
        return getShapeName() + ", pole: " + getField();
    }
}
