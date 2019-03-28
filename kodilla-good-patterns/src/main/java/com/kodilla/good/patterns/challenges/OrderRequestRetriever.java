package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.products.Clothes;
import com.kodilla.good.patterns.challenges.products.Product;

import java.time.LocalDate;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){

        User user = new User("Anna", "Szczech");

        LocalDate dateOfOrder = LocalDate.of(2017, 8, 1);
        Product orderedProduct = new Clothes(55, "lipstick");

        return new OrderRequest(user, dateOfOrder, orderedProduct, 2);
    }
}
