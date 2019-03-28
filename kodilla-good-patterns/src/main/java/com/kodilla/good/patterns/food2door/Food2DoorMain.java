package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.foodProducers.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.foodProducers.HealthyShop;
import com.kodilla.good.patterns.food2door.information.service.MailService;
import com.kodilla.good.patterns.food2door.order.Order;
import com.kodilla.good.patterns.food2door.order.OrderProcessor;
import com.kodilla.good.patterns.food2door.process.OrderRequestRetriever;

public class Food2DoorMain {
    public static void main(String[] args) {
        System.out.println("     !!!  ORDER 1  !!!");
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        Order order1 = orderRequestRetriever.retrieve1();

        OrderProcessor orderProcessor1 = new OrderProcessor(order1, new ExtraFoodShop(), new MailService());
        orderProcessor1.process();

        System.out.println("\n     !!!  ORDER 2  !!!");
        Order order2 = orderRequestRetriever.retrieve2();
        OrderProcessor orderProcessor2 = new OrderProcessor(order2, new HealthyShop(), new MailService());
        orderProcessor2.process();
    }

}
