package com.kodilla.good.patterns.challenges.implementation;

import com.kodilla.good.patterns.challenges.OrderRequest;
import com.kodilla.good.patterns.challenges.interfaces.OrderService;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(OrderRequest orderRequest) {
        System.out.println(orderRequest.getQuantityOfProduct() + " " + orderRequest.getOrderedProduct() + " was ordered by: " + orderRequest.getUser() + " on: " + orderRequest.getDateOfOrder());
        return true;
    }
}
