package com.example.pizza.state;

import com.example.pizza.model.Order;

public class DeliveringState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new BakingState());
    }

    @Override
    public String getStatus() {
        return "Delivering";
    }
}


