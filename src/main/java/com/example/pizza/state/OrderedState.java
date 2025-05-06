package com.example.pizza.state;

import com.example.pizza.model.Order;

public class OrderedState implements OrderState {
    public void next(Order order) {
        order.setState(new PreparingState());
    }

    public void prev(Order order) {
        System.out.println("Order is already in initial state.");
    }

    public String getStatus() {
        return "Ordered";
    }
}
