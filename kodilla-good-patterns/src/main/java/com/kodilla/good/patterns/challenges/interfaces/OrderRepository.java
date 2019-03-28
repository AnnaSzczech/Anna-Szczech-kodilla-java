package com.kodilla.good.patterns.challenges.interfaces;

import com.kodilla.good.patterns.challenges.OrderRequest;
import java.util.Set;

public interface OrderRepository {
    void createOrder(OrderRequest orderRequest);
    Set<OrderRequest> getOrderRequestList();
}
