package com.example.pizza.strategy;

public class HomeDeliveryStrategy implements DeliveryStrategy {
    @Override
    public double getDeliveryFee() {
        return 2.5;
    }

    @Override
    public String getMethod(){
        return "Delivery";
    }
}

