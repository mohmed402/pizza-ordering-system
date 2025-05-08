package com.example.pizza.strategy;

public interface DeliveryStrategy {
    double getDeliveryFee();
    String getMethod(); // Optional for display
}

