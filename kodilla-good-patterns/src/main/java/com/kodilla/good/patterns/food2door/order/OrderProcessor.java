package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.foodProducers.FoodProducer;
import com.kodilla.good.patterns.food2door.information.service.InformationService;
import com.kodilla.good.patterns.food2door.process.OrderDTo;

public class OrderProcessor {
    private final Order order;
    private final InformationService informationService;
    private final FoodProducer foodProducer;

    public OrderProcessor(Order order, FoodProducer foodProducer, InformationService informationService) {
        this.order = order;
        this.informationService = informationService;
        this.foodProducer = foodProducer;
    }

    public OrderDTo process(){
        boolean isNotAvailable = order.getListOfProducts().stream().anyMatch(product -> !product.getProduct().isAvailable());
        foodProducer.process();
        if (!isNotAvailable) {
            informationService.inform(order.getUser(), order.getUser() + " your order is completed.");
            return new OrderDTo(order, true);
        } else {
            informationService.inform(order.getUser(), order.getUser() + " your your ordered products aren't available.");
            return new OrderDTo(order, false);
        }
    }
}
