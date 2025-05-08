package com.example.pizza.state;

import com.example.pizza.model.Order;

public class PreparingState implements OrderState {
    public void next(Order order) {
        order.setState(new BakingState());
    }

    public void prev(Order order) {
        order.setState(new OrderedState());
    }

    public String getStatus() {
        return "Preparing";
    }
}
