package com.example.pizza.decorator;

public class Margherita extends Pizza {
    @Override
    public String getDescription() {
        return size.name() + " Margherita";
    }

    @Override
    public double getCost() {
        return 5.00 + size.getExtraCost();
    }
}
