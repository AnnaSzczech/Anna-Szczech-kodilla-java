package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING_TASK = "DRIVING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String SHOPPING_TASK = "SHOPPING_TASK";

    public Task makeTask(final String taskClass){
        switch (taskClass){
            case DRIVING_TASK:
                return new DrivingTask("Driving task", "Gdańsk", "car");
            case PAINTING_TASK:
                return new PaintingTask("Painting task", "Niebieski", "wall");
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping task", "handbag", 1);
                default:
                    return null;
        }
    }
}
