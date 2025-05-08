package com.example.pizza.service;

import com.example.pizza.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final Map<Long, Order> orders = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Order createOrder(String customerName) {
        Long id = idCounter.getAndIncrement();
        Order order = new Order(id, customerName);
        orders.put(id, order);
        return order;
    }

    public Order getOrder(Long id) {
        return orders.get(id);
    }

    public Order advanceOrderState(Long id) {
        Order order = orders.get(id);
        if (order != null) {
            order.nextState();
        }
        return order;
    }

    public Order revertOrderState(Long id) {
        Order order = orders.get(id);
        if (order != null) {
            order.previousState();
        }
        return order;
    }
}
