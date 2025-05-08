package com.example.pizza.strategy;

public class CollectionStrategy implements DeliveryStrategy {
    @Override
    public double getDeliveryFee() {
        return 0.0;
    }

    @Override
    public String getMethod() {
        return "Collection";
    }
}