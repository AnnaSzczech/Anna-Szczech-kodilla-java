package com.kodilla.good.patterns.food2door.process;

import com.kodilla.good.patterns.food2door.order.Order;

public class OrderDTo {
    private final Order order;
    private final boolean isOrderCompleted;

    public OrderDTo(Order order, boolean isOrderCompleted) {
        this.order = order;
        this.isOrderCompleted = isOrderCompleted;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isOrderCompleted() {
        return isOrderCompleted;
    }
}
