package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.interfaces.InformationService;
import com.kodilla.good.patterns.challenges.interfaces.OrderRepository;
import com.kodilla.good.patterns.challenges.interfaces.OrderService;

public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isAvailable = orderService.order(orderRequest);

        if(isAvailable) {
            informationService.inform(orderRequest.getUser(), createAMessage(orderRequest));
            orderRepository.createOrder(orderRequest);
            return new OrderDto(orderRequest.getOrderedProduct(), true);
        } else {
            return new OrderDto(orderRequest.getOrderedProduct(), false);
        }
    }

    public String createAMessage(OrderRequest orderRequest){
        return " has ordered: " + orderRequest.getQuantityOfProduct() + " " + orderRequest.getOrderedProduct() + "; for: " + orderRequest.getOrderedProduct().getPrice() + " PLN.";
    }
}
