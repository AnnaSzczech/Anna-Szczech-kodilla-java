package com.kodilla.good.patterns.challenges.implementation;

import com.kodilla.good.patterns.challenges.OrderRequest;
import com.kodilla.good.patterns.challenges.interfaces.OrderRepository;

import java.util.HashSet;
import java.util.Set;

public class ProductOrderRepository implements OrderRepository {
    private final Set<OrderRequest> orderRequestList = new HashSet();

    @Override
    public void createOrder(OrderRequest orderRequest) {
        orderRequestList.add(orderRequest);
        System.out.println("Order added to repository! Repository quantity: " + orderRequestList.size() + " - " + orderRequestList);
    }

    @Override
    public Set<OrderRequest> getOrderRequestList() {
        return orderRequestList;
    }
}
