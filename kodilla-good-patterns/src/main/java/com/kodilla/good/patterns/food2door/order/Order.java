package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.process.User;

import java.util.List;

public class Order {
    private final User user;
    private final List<SingleOrder> listOfProducts;

    public Order(User user, List<SingleOrder> listOfProducts) {
        this.user = user;
        this.listOfProducts = listOfProducts;
    }

    public User getUser() {
        return user;
    }

    public List<SingleOrder> getListOfProducts() {
        return listOfProducts;
    }
}
