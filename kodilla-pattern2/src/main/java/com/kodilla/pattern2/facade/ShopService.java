package com.kodilla.pattern2.facade;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {

    private final List<Order> orders = new ArrayList<>();

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private ProductService productService;

    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long) orders.stream()
                    .mapToInt(order -> order.getOrderId().intValue())
                    .max().orElse(0);
            orders.add(new Order(productService, maxOrder + 1, userId));
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    public void addItem(Long orderId, Long productId, double qty) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> order.getItems().add(new Item(productId, qty)));
    }

    public boolean removeItem(Long orderId, Long productId) {
        Iterator<Order> iterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();

        while (iterator.hasNext()) {
            Order theOrder = iterator.next();
            for (int i = 0; i < theOrder.getItems().size(); i++) {
                if (theOrder.getItems().get(i).getProductId().equals(productId)) {
                    theOrder.getItems().remove(i);
                    return true;

                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(Long orderId) {
        Iterator<Order> iterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (iterator.hasNext()) {
            Order theOrder = iterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    public boolean doPayment(Long orderId){
        Iterator<Order> iterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (iterator.hasNext()) {
            Order theOrder = iterator.next();
           if (theOrder.isPaid()) {
               return true;
           } else {
               Random random = new Random();
               theOrder.setPaid(random.nextBoolean());
               return theOrder.isPaid();
           }
        }
        return false;
    }

    public boolean verifyOrder(Long orderId){
        Iterator<Order> iterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (iterator.hasNext()) {
            Order theOrder = iterator.next();
            boolean result = theOrder.isPaid();
            Random generator = new Random();
            if (!theOrder.isVerified()) {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.isVerified();
        }
        return false;
    }

    public boolean submitOrder(Long orderId){
        Iterator<Order> iterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (iterator.hasNext()) {
            Order theOrder = iterator.next();
            if (theOrder.isVerified()) {
                theOrder.setSubmitted(true);
            }
            return theOrder.isSubmitted();
        }
        return false;
    }

    public void cancelOrder(Long orderId){
        Iterator<Order> iterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (iterator.hasNext()) {
            Order theOrder = iterator.next();
            orders.remove(theOrder);
        }
    }
}




