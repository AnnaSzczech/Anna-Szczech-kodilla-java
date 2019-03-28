package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;
import com.kodilla.good.patterns.challenges.implementation.MailService;
import com.kodilla.good.patterns.challenges.implementation.ProductOrderRepository;
import com.kodilla.good.patterns.challenges.implementation.ProductOrderService;

public class GoodPattersMain {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new ProductOrderRepository());
        orderProcessor.process(orderRequest);
    }
}
