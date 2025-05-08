package com.example.pizza.state;

import com.example.pizza.model.Order;

public interface OrderState {
    void next(Order order);
    void prev(Order order);
    String getStatus();
}
