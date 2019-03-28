package com.kodilla.good.patterns.food2door.process;

import com.kodilla.good.patterns.food2door.order.Order;
import com.kodilla.good.patterns.food2door.order.Product;
import com.kodilla.good.patterns.food2door.order.SingleOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public Order retrieve1(){
        SingleOrder singleOrder1 = new SingleOrder(new Product("product 1", true, 2.50), 4);
        SingleOrder singleOrder2 = new SingleOrder(new Product("product 5", true, 5.55), 11);
        SingleOrder singleOrder3 = new SingleOrder(new Product("product 6", true, 18.90), 1);
        SingleOrder singleOrder4 = new SingleOrder(new Product("product 9", true, 0.35), 21);

        List<SingleOrder> listOfProducts = new ArrayList<>();
        listOfProducts.add(singleOrder1);
        listOfProducts.add(singleOrder2);
        listOfProducts.add(singleOrder3);
        listOfProducts.add(singleOrder4);

        return new Order(new User("Anna", "Szczech"), listOfProducts);
    }

    public Order retrieve2(){
        SingleOrder singleOrder5 = new SingleOrder(new Product("product 1", true, 0.50), 4);
        SingleOrder singleOrder6 = new SingleOrder(new Product("product 5", true, 5.56), 18);
        SingleOrder singleOrder7 = new SingleOrder(new Product("product 6", false, 218.90), 3);
        SingleOrder singleOrder8 = new SingleOrder(new Product("product 9", true, 22.35), 21);

        List<SingleOrder> listOfProducts2 = new ArrayList<>();
        listOfProducts2.add(singleOrder5);
        listOfProducts2.add(singleOrder6);
        listOfProducts2.add(singleOrder7);
        listOfProducts2.add(singleOrder8);

        return new Order(new User("Jan", "Kowalski"), listOfProducts2);
    }
}
