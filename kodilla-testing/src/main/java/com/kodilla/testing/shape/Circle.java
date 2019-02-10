package com.kodilla.testing.shape;

public class Circle implements Shape{
    private String name;
    private double radius;

    public Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
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
