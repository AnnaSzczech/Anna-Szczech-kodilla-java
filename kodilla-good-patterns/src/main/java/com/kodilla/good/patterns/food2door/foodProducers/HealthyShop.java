package com.kodilla.good.patterns.food2door.foodProducers;

public class HealthyShop implements FoodProducer {
    @Override
    public void process() {
        System.out.println("Process: The food was ordered in the HealthyShop");
    }
}
