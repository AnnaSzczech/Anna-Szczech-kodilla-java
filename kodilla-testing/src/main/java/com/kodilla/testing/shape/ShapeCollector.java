package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    public ArrayList<Shape> geometricFigures = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        geometricFigures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (geometricFigures.contains(shape)) {
            geometricFigures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (n >= 0 && n < geometricFigures.size()) {
            shape = geometricFigures.get(n);
        }
        return shape;
    }

    public String showFigures(){
        String figureInCollection = "";
        System.out.println("Figury geometryczne znajdujące się w kolekcji:");
        for (Shape shape : geometricFigures) {
            figureInCollection = figureInCollection + shape + "\n";
        }
        return figureInCollection;
    }
}
