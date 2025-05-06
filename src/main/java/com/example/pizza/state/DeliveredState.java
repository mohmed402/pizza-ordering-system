package com.example.pizza.state;

import com.example.pizza.model.Order;

public class DeliveredState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order has already been delivered.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new BakingState());
    }

    @Override
    public String getStatus() {
        return "Delivered";
    }
}
